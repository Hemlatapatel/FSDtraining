const EventEmmiter = require('events');

class Logger extends EventEmmiter {
    log(message) {
        console.log('Hello '+ message);
        console.log('emiting event');
        this.emit('messageLogged');
    }
}

module.exports=Logger;