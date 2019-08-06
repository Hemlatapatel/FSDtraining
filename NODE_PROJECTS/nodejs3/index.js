/*
//1 look for the same folder
//2. look into global/default  folder

const _ = require('underscore');

let result = _.contains([1,2,3], 3);

console.log("result is " + result);

let max = _.max([3,5,2,8]);
console.log("max : " + max);

let min = _.min([67,45,34,78,90]);
console.log("min " + min);

let filtered = _.filter([1,2,6,3,4,5,6], (num) => {
    return num == 6;
});
console.log("filtered is " + filtered);

let increment = _.each([1,2,3,4], (num) => {
    return num+1;
})

console.log("incremented array "+ increment);
================================================================
*/


const _ = require('underscore');

const http = require('http');
const server = http.createServer((req, res) => {
    if(req.url === '/') {
        res.write("Hello world");
        res.end();
    }
});

console.log("port is======"+ process.env.PORT);
const port = process.env.PORT || 3000;

server.on('connection', () => {
    console.log("server is listening on port :" + port) ;
} )

server.listen(port);

