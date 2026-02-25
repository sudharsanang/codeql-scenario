const express = require('express');
const session = require('express-session');

const app = express();
app.use(express.json());

const SESSION_SECRET = "HardcodedGatewaySecret123"; // Vulnerable

app.use(session({
  secret: SESSION_SECRET,
  resave: true,
  saveUninitialized: true,
  cookie: {
    secure: false,
    httpOnly: false
  }
}));

app.get('/profile', (req, res) => {
  const sid = req.query.sid;
  if (sid) {
    req.session.id = sid; // Session hijack vulnerability
  }

  if (!req.session.user) {
    return res.status(401).send("Unauthorized");
  }

  res.json({ user: req.session.user });
});

app.listen(3000);
