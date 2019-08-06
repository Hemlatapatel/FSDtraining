const http = require('http');
/*
const server = http.createServer();
server.on('connection', () => {
    console.log('server created and ready');
});

server.listen(3000);*/

const port=3000;
const Student = {
    id: 1,
    name:"Hemlata",
    comp:"IBM"
}

const event = {
    name: 'birthday event',
    personinvited: ['Hemlata', 'Bhupii', 'Anu'],
    greetInvitee() {
        // this.personinvited.for
        for( str in this.personinvited) {
            console.log(  this.personinvited[str]  + " is invited");
        }
    }
}

const server = http.createServer((req, res) => {

    server.on("connection", ()=> {
        console.log("server is running on port "+ port);
    })

    if(req.url===('/')) {
        event.greetInvitee();
        res.write("Hello node... welcome in FSD training..");
        res.end();
    }


    if(req.url===('/student')) {
        res.write(JSON.stringify(Student));
        res.end();
    }
});

server.listen(port);
