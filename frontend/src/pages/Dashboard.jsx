import React from "react";
import "./Dashboard.css";
import { useNavigate } from "react-router-dom";
import { FaMusic, FaHistory, FaUser, FaSignOutAlt, FaHome } from "react-icons/fa";

const Dashboard = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    navigate("/"); // Redirect to login
  };

  return (
    <div className="dashboard-container">
      {/* Navbar */}
      <header className="navbar">
        <div className="logo">
          <FaMusic className="logo-icon" /> MoodTune
        </div>
        <div className="nav-right">
          <FaUser /> <span>Hi, User!</span>
        </div>
      </header>

      {/* Sidebar */}
      <aside className="sidebar">
        <ul>
          <li onClick={() => navigate("/dashboard")}>
            <FaHome /> Home
          </li>
          <li onClick={() => navigate("/upload")}>
            <FaMusic /> My Playlist
          </li>
          <li onClick={() => navigate("/history")}>
            <FaHistory /> History
          </li>
          <li onClick={handleLogout}>
            <FaSignOutAlt /> Logout
          </li>
        </ul>
      </aside>

      {/* Main content */}
      <main className="main-content">
        <h2>Welcome to your music dashboard 🎶</h2>
        <p>Upload songs, analyze moods, and explore your playlists.</p>

        <div className="card-container">
          <div className="card" onClick={() => navigate("/upload")}>
            🎵 Upload a new song
          </div>
          <div className="card" onClick={() => navigate("/analyze")}>
            💫 Check mood analysis
          </div>
          <div className="card" onClick={() => navigate("/history")}>
            📜 View history
          </div>
        </div>
      </main>
    </div>
  );
};

export default Dashboard;
