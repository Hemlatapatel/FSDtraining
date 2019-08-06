var express = require('express');
var router = express.Router();
const {User, validate} = require('../models/user');
const _ = require('lodash');
const bcrypt = require('bcrypt');


/* GET users listing. */
router.get('/', async function(req, res, next) {
  const users = await User.find();
  var usersList = [];
  for(user in users) {
     usersList.push(_.pick(user, ['_id', 'name', 'email']));
  }
  res.send(usersList);
});

router.post('/', async(req, res) => {
  const {error} = validate(req.body);
  if(error) return res.status(400).send(error.details[0].message);

  /*let user = new User({
    name: req.body.name,
    email: req.body.email,
    password: req.body.password
  });
*/

  let user  = await User.findOne({email: req.body.email});
   console.log("user", user);
  if(user) return res.status(400).send('User already exist');

  const salt = await bcrypt.genSalt(10);
  req.body.password = await bcrypt.hash(req.body.password, salt);

  user = new User(_.pick(req.body, ['name', 'email', 'password']));

  user = await user.save();

  // set the token in the header
  const token  = user.generateAuthToken();
  res.header('x-auth-token', token).send(_.pick(user, ['_id', 'name', 'email']));

})

module.exports = router;
