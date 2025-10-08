import React, { useEffect, useState } from "react";
import { getSongs, analyzeMood } from "../services/api";
import Navbar from "../components/Navbar";


function Playlist() {
  const [songs, setSongs] = useState([]);

  useEffect(() => {
    fetchSongs();
  }, []);

  const fetchSongs = async () => {
    try {
      const res = await getSongs();
      setSongs(res.data);
    } catch {
      console.error("Error fetching songs");
    }
  };

  const handleAnalyze = async (id) => {
    try {
      const res = await analyzeMood(id);
      alert(`🎧 Mood: ${res.data.mood}`);
      fetchSongs(); // refresh after analysis
    } catch {
      alert("Error analyzing mood");
    }
  };

  return (
    <div className="min-h-screen bg-[#f2f8f5] text-gray-800 p-6">
      <h2 className="text-2xl font-semibold mb-6 text-center">🎶 My Playlist</h2>
      {songs.length === 0 ? (
        <p className="text-center">No songs uploaded yet.</p>
      ) : (
        <div className="grid gap-4 max-w-xl mx-auto">
          {songs.map((song) => (
            <div key={song._id} className="bg-white p-4 rounded-2xl shadow-md">
              <h3 className="font-bold">{song.songName}</h3>
              <p className="text-sm text-gray-600">{song.artistName}</p>
              <p className="text-sm text-gray-600">
                Mood: {song.mood || "Not analyzed yet"}
              </p>
              <button
                onClick={() => handleAnalyze(song._id)}
                className="mt-2 bg-green-400 hover:bg-green-500 text-white px-3 py-1 rounded-lg"
              >
                Analyze Mood
              </button>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default Playlist;
