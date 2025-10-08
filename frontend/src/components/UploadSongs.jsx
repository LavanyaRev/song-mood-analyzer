import React, { useState } from "react";
import axios from "axios";

function UploadSongs() {
  const [file, setFile] = useState(null);
  const [message, setMessage] = useState("");

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
    setMessage("");
  };

  const handleUpload = async () => {
    if (!file) {
      setMessage("⚠️ Please select a file first!");
      return;
    }

    const formData = new FormData();
    formData.append("song", file); // ✅ MUST MATCH backend's 'upload.single("song")'

    try {
      const res = await axios.post("http://localhost:5000/api/songs/upload", formData, {
        headers: { "Content-Type": "multipart/form-data" },
      });
      console.log("✅ Upload response:", res.data);
      setMessage("✅ Upload successful!");
    } catch (error) {
      console.error("❌ Upload error:", error);
      setMessage("❌ Upload failed. Please try again.");
    }
  };

  return (
    <div style={{
      background: "linear-gradient(135deg, #e0f7fa, #e1bee7)",
      height: "100vh",
      display: "flex",
      alignItems: "center",
      justifyContent: "center"
    }}>
      <div style={{
        background: "#fff",
        padding: "2rem",
        borderRadius: "20px",
        boxShadow: "0 4px 15px rgba(0,0,0,0.2)",
        textAlign: "center"
      }}>
        <h2>🎵 Upload Your Song</h2>
        <p>Analyze your music mood instantly!</p>
        <input
          type="file"
          accept="audio/*"
          onChange={handleFileChange}
          style={{ margin: "10px" }}
        />
        <br />
        <button
          onClick={handleUpload}
          style={{
            background: "#007bff",
            color: "white",
            border: "none",
            padding: "10px 20px",
            borderRadius: "10px",
            cursor: "pointer"
          }}
        >
          Upload
        </button>
        <p style={{
          marginTop: "10px",
          color: message.includes("✅") ? "green" : "red"
        }}>
          {message}
        </p>
      </div>
    </div>
  );
}

export default UploadSongs;
