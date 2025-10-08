const express = require("express");
const cors = require("cors");
const multer = require("multer");
const path = require("path");
const fs = require("fs");
require("dotenv").config();

const app = express();
app.use(cors());
app.use(express.json());

// Create uploads folder if missing
const uploadDir = path.join(__dirname, "uploads");
if (!fs.existsSync(uploadDir)) {
  fs.mkdirSync(uploadDir);
  console.log("📁 Created uploads folder");
}

// Multer config
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, uploadDir);
  },
  filename: (req, file, cb) => {
    cb(null, Date.now() + "-" + file.originalname);
  },
});

const upload = multer({ storage });

// Test route
app.get("/", (req, res) => {
  res.send("✅ Song Mood Analyzer Backend is Running!");
});

// Upload route
app.post("/api/songs/upload", upload.single("file"), (req, res) => {
  try {
    if (!req.file) {
      console.error("❌ No file received!");
      return res.status(400).json({ message: "No file uploaded" });
    }

    console.log("✅ File uploaded:", req.file.filename);

    // Random mood simulation
    const moods = ["Happy", "Sad", "Energetic", "Calm"];
    const randomMood = moods[Math.floor(Math.random() * moods.length)];

    res.json({
      message: "File uploaded successfully!",
      file: req.file.filename,
      mood: randomMood,
    });
  } catch (err) {
    console.error("❌ Error during upload:", err);
    res.status(500).json({ message: "Internal Server Error", error: err.message });
  }
});

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`🚀 Server running on port ${PORT}`));
