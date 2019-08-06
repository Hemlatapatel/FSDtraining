const Logger = require('./event1');
const emitter = new Logger();

function mult(a,b) {
    console.log('add is : ' + (a+b));
    const EventEmmiter = require('events');
}

class Logger extends EventEmmiter {
        log(message) {
            console.log('Hello '+ message);
            console.log('emiting event');
            this.emit('messageLogged');
        }
    }


module.exports = mult,Logger;