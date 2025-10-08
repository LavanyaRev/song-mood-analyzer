import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import UploadSong from "./pages/UploadSong";
import Playlist from "./pages/Playlist";
import Login from "./pages/Login";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/upload" element={<UploadSong />} />
        <Route path="/playlist" element={<Playlist />} />
      </Routes>
    </Router>
  );
}

export default App;
