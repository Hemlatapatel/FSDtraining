const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground')
.then(() => {
    console.log("connected to mongoDB")
}).catch(err => {
    console.log("could not connect to mongo....", err);
})

const authorSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true,
        min: 3,
        max: 50
    },

    bio:{
        type: String,
        required: true
    },
    website: {
        type:String,
        required: true
    }
});

const Author = mongoose.model('Author', authorSchema);

const Course = mongoose.model('Course', new Author({
    name: String,

}));

async function createCourse(name, author) {
    const course = new Course({
        name,
        author
    });

    const result = course.save();
    console.log(result);
}

async function listCourses() {
    const courses = await Course.find();
    console.log(courses);
}


createCourse('Hemlata', new Author ({name: 'Patel', bio: 'female', website: 'http://www.patel.com'}));

listCourses();