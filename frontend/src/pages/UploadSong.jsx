import React, { useState } from "react";
import axios from "axios";
import { FaMusic } from "react-icons/fa";

const UploadSongs = () => {
  const [file, setFile] = useState(null);
  const [message, setMessage] = useState("");
  const [mood, setMood] = useState("");

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
    setMessage("");
    setMood("");
  };

  const handleUpload = async () => {
    if (!file) {
      setMessage("Please choose a file before uploading!");
      return;
    }

    const formData = new FormData();
    formData.append("file", file);

    try {
      const response = await axios.post("http://localhost:5000/api/songs/upload", formData, {
        headers: { "Content-Type": "multipart/form-data" },
      });

      setMessage("✅ Upload successful!");
      setMood(`🎧 Detected Mood: ${response.data.mood}`);
    } catch (error) {
      console.error("Upload error:", error);
      setMessage("❌ Upload failed. Please try again.");
    }
  };

  return (
    <div
      style={{
        height: "100vh",
        background: "linear-gradient(135deg, #a8edea 0%, #fed6e3 100%)",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        flexDirection: "column",
        fontFamily: "Poppins, sans-serif",
      }}
    >
      <div
        style={{
          background: "rgba(255, 255, 255, 0.85)",
          padding: "40px 60px",
          borderRadius: "20px",
          boxShadow: "0 8px 20px rgba(0, 0, 0, 0.1)",
          textAlign: "center",
          width: "400px",
        }}
      >
        <FaMusic size={40} color="#3b3b98" />
        <h1 style={{ color: "#2c3e50", fontSize: "2rem", marginTop: "10px" }}>
          Upload Your Song
        </h1>
        <p style={{ color: "#555", fontSize: "1rem", marginBottom: "20px" }}>
          Analyze your music mood instantly!
        </p>

        <input
          type="file"
          accept="audio/*"
          onChange={handleFileChange}
          style={{
            marginBottom: "15px",
            border: "1px solid #ccc",
            borderRadius: "8px",
            padding: "6px",
          }}
        />
        <br />
        <button
          onClick={handleUpload}
          style={{
            background: "linear-gradient(90deg, #6dd5ed, #2193b0)",
            color: "#fff",
            border: "none",
            borderRadius: "8px",
            padding: "10px 25px",
            fontSize: "1rem",
            cursor: "pointer",
          }}
        >
          Upload
        </button>

        {message && (
          <p
            style={{
              marginTop: "15px",
              color: message.includes("✅") ? "green" : "red",
            }}
          >
            {message}
          </p>
        )}

        {mood && (
          <p
            style={{
              marginTop: "10px",
              fontWeight: "bold",
              color: "#333",
            }}
          >
            {mood}
          </p>
        )}
      </div>
    </div>
  );
};

export default UploadSongs;
