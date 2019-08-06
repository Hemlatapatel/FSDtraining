const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');
const auth = require('../middleware/auth');
const admin = require('../middleware/admin');
const {Genre, validate} = require ('../models/genre');

router.get('/', async(req, res) => {
    const genres = await Genre.find();
    res.send(genres);
})

router.post('/', [auth, admin], async(req, res) => {
    const {error} = validate(req.body);
    if(error) return res.status(400).send(error.details[0].message);
    let genre  = new  Genre ({
        name: req.body.name
    });

    genre = await genre.save();
    res.send(genre);
})

module.exports = router;