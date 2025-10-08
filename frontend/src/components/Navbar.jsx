import React from "react";
import { Link, useNavigate } from "react-router-dom";

function Navbar() {
  const navigate = useNavigate();

  const handleLogout = () => {
    // you can later clear auth tokens here
    navigate("/");
  };

  return (
    <nav className="bg-[#dff3ea] shadow-md py-3 px-6 flex justify-between items-center">
      <h1 className="text-2xl font-bold text-green-700">🎵 Moodify</h1>
      <div className="flex gap-6 text-gray-700 font-medium">
        <Link to="/upload" className="hover:text-green-600">Upload</Link>
        <Link to="/playlist" className="hover:text-green-600">Playlist</Link>
        <button
          onClick={handleLogout}
          className="bg-green-500 hover:bg-green-600 text-white px-3 py-1 rounded-lg"
        >
          Logout
        </button>
      </div>
    </nav>
  );
}

export default Navbar;
