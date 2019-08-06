const Logger = require('./event1');
const emitter = new Logger();
emitter.addListener('messageLogged', ()=> {
    console.log("Hello I have listened");
})

emitter.log("Hemlata");

