const Joi = require('joi');
const express = require('express');
const app=express();
const pug = require('pug');

const courseRouter = require('./routes/course');
const homeRouter = require('./routes/home');


app.use(express.json());

app.use('/api/courses', courseRouter);
// app.use('/', homeRouter);
app.set('view engine', 'pug');

app.get('/', (req, res) => {
    res.render('index', {
        title:'Hello',
        message : 'I am inside the pug file.... '
    })
})
const port = process.env.PORT || 3000;
app.listen(port, () => {
    console.log(`Server is listening on port: ${port}`);
})