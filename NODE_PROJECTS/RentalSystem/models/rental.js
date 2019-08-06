const Joi = require('joi');
const mongoose = require('mongoose');
const {genreSchema} = require('./genre');

const Rental = mongoose.model('Rental', new mongoose.Schema({
    customer: {
        type: new mongoose.Schema({
            name: {
                type: String,
                required: true,
                minLength: 5,
                maxLength: 50
            },
            isGold: {
                type: Boolean,
                default: false
            },
            phone: {
                type: String,
                required: true,
                minLength: 5,
                maxLength: 50
            }
        }),
        required: true
    },
    movie : {
        type: new mongoose.Schema({
            title: {
                type: String,
                required: true,
                trim: true,
                minLength: 5,
                maxLength: 255
            },
            genre: {
                type: genreSchema,
                required: true
            },
            numberInStock: {
                type: Number,
                required: true,
                min: 0,
                max: 255
            },
            dailyRentalRate: {
                type: Number,
                required: true,
                min: 0,
                max: 255
            }
        }),
        required: true
    },
    dateOut: {
        type: Date,
        required: true,
        default: Date.now()
    },
    dateReturned: {
        type: Date
    },
    rentalFee: {
        type: Number,
        min: 0
    }

}))


function validateRental(rental) {
    const schema = {
        customerId: Joi.string().required(),
        movieId:Joi.string().required()
    };

    return Joi.validate(rental, schema);
}

exports.Rental = Rental;
exports.validate = validateRental;