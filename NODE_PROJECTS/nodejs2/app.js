const Eventemitter = require('events');
const event = new Eventemitter();
event.on('messageLogged',()=> {

    console.log('Hey I have listened');
});

event.addListener('messageLogged', () => {
    console.log('Hey I have listened');

})
console.log('emting an event');
event.emit('messageLogged');
