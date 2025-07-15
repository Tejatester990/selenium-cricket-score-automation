const express = require('express');
const fs = require('fs');
const app = express();
const PORT = 3000;

app.get('/api/score', (req, res) => {
  fs.readFile('data.json', (err, data) => {
    if (err) throw err;
    res.setHeader('Content-Type', 'application/json');
    res.send(data);
  });
});

app.use(express.static('.'));

app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
