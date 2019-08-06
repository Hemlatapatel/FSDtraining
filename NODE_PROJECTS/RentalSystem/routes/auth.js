const mongoose = require('mongoose');
const {User} = require('../models/user');
const express = require('express');
const router = express.Router();

router.post('/', async (req, res) => {

    let userExist  = await User.findOne({
        $and: [ { email: req.body.email },
            { password:  req.body.password } ] });

    if(userExist) return res.send('valid user');

    res.send('invalid user');
})


module.exports = router;