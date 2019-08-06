/*const logger = require('./log')
logger("Ibmer");


const os = require('os');
console.log('total memory',os.totalmem());
console.log('available memory', os.freemem());

console.log('hostname', os.hostname());
console.log('homeDir', os.homedir());*/

const EventEmitter = require('events');

const event = new EventEmitter();

event.on(event: 'messageLogged', ()=> {
    console.log('Hey I have listened');
});

console.log('emitting an event: messageLogged');
event.emit(event:'messageLogged');



