const add = require('./add');
const Logger = require('./mult');

// const Logger = require('./event1');
const emitter = new Logger();
emitter.addListener('messageLogged', ()=> {
    console.log("Hello I have listened");
})

emitter.log("Hemlata");

add(10,20);
mult(20,30);