const Logger = require('./event1');
const emitter = new Logger();

function mult(a,b) {
    console.log('multiplication is : ' + (a*b));
    emitter.addListener('messageLogged', ()=> {
        console.log("multiplication is done");
    })
}

module.exports = mult;