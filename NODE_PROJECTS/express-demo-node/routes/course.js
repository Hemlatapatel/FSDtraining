const Joi = require('joi');
const express = require('express');
const courses = require('../courses');
const router = express.Router();

const schema = Joi.object().keys({
    name:Joi.string().min(3).required(),
    amount: Joi.number().integer().min(1000),
    email: Joi.string().email({ minDomainAtoms: 2 }),
    password: Joi.string().regex(/^[a-zA-Z0-9]{3,30}$/),

})

router.get('/', function (req, res) {
    res.send(courses);
});

router.get('/:id', (req, res) => {
    var temp =  courses.find((course) => {
        return course.id == parseInt(req.params.id)

    })
    if (!temp) {
        res.status(400).send("no course found of given id : " + req.params.id);
    } else {
        res.send(temp);
    }
})

router.post('/', (req, res) => {

    const result = Joi.validate(req.body, schema);

    if(result.error) {
        res.status(400).send("Invalid data");
    }
    const course = {
        id:courses.length+1,
        name:req.body.name,
        year:req.body.amount,
        email: req.body.email,
        password: req.body.password
    }

    courses.push(course);
    res.send(course);
})

router.delete("/:id", (req, res) => {
    let arrId = courses.findIndex((value) => value.id === parseInt(req.params.id));
    if(arrId == -1) {
        res.send("no data found of given id ")
    }
    courses.splice(arrId, 1);

    res.send("Delete success");
})


router.put("/:id", (req, res) => {
    var temp =  courses.find((course) => {
        return course.id == parseInt(req.params.id)

    })
    if(!temp) {
        res.send("no data found of given id ")
    } else {
        const result = Joi.validate(req.body, schema);

        if(result.error) {
            res.status(400).send("Invalid data");
        }


        temp.name  = req.body.name;
        temp.amount = req.body.amount;
        temp.email =  req.body.email;
        temp.password =  req.body.password;


        res.send(temp);
    }
})

module.exports = router;