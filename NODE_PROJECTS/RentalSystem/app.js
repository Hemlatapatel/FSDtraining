var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var mongoose = require('mongoose');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var customersRouter = require('./routes/customers');
var genresRouter = require('./routes/genres');
var moviesRouter = require('./routes/movies');
var rentalRouter = require('./routes/rentals');
var authRouter = require('./routes/auth');
var app = express();

var cors = require('cors');

// use it before all route definitions
app.use(cors({origin: 'http://localhost:4200'}));

mongoose.connect('mongodb://localhost/vidly')
    .then(() => {
      console.log('connected to mongodb');
    })
    .catch(err => {
      console.error('could not connect to mongoDB');
    })

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/api/users', usersRouter);
app.use('/api/customers', customersRouter);
app.use('/api/genres', genresRouter);
app.use('/api/movies', moviesRouter);
app.use('/api/rentals', rentalRouter);
app.use('/api/auth', authRouter);
// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});




module.exports = app;
