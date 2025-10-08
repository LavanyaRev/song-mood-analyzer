const express = require('express');
const multer = require('multer');
const path = require('path');

const router = express.Router();

// Storage setup for uploaded files
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    cb(null, 'uploads/'); // Folder where uploads will be saved
  },
  filename: function (req, file, cb) {
    const uniqueSuffix = Date.now() + '-' + Math.round(Math.random() * 1E9);
    cb(null, uniqueSuffix + path.extname(file.originalname));
  }
});

// Multer upload middleware
const upload = multer({ storage: storage });

// Route: Upload song
router.post('/upload', upload.single('song'), (req, res) => {
  try {
    if (!req.file) {
      return res.status(400).json({ error: 'No file uploaded!' });
    }

    console.log('✅ File uploaded successfully:', req.file.filename);
    res.json({
      message: 'File uploaded successfully!',
      file: req.file.filename
    });

  } catch (err) {
    console.error('❌ Upload error:', err);
    res.status(500).json({ error: 'File upload failed.' });
  }
});

module.exports = router;
