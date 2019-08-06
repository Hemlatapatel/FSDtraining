const {User}  = require('../models/user');

module.exports = async function(req, res, next){
   console.log('req.user===', req.user);
    const user1 = await User.findById({_id: req.user._id});
console.log("user1====", user1);
    if(!user1.isAdmin) res.status(403).send("Access denied");

    next();
}