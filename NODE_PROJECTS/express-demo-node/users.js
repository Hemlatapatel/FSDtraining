const express = require('express');
const app = express();
const apiRequest = require('request');

const url = "https://jsonplaceholder.typicode.com/users";

app.get("/users", (request, response) => {
    apiRequest.get(url, {json: true}, (err, res, body) => {
        if (err) {
            return console.log(err);
        }
        response.send(res);
    })
})

app.get("/users/:id", (request, response) => {
    apiRequest.get(url+"/"+ request.params.id, {json: true}, (err, res, body) => {
        if (err) {
            return console.log(err);
        }
        response.send(res);
    })
})


app.delete("/users/:id", (request, response) => {
    apiRequest.delete(url+"/"+ request.params.id, {json: true}, (err, res, body) => {
        if (err) {
            return console.log(err);
        }
        response.send(res);
    })
})




const port = process.env.PORT || 3000;

app.listen(port, (req, res) => {
    console.log("Server is listening on port :" + port);
})
