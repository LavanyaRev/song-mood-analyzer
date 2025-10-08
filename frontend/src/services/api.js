import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:5000/api", // backend URL (change later if needed)
});

// Upload song
export const uploadSong = (formData) => API.post("/upload-song", formData, {
  headers: { "Content-Type": "multipart/form-data" },
});

// Analyze mood
export const analyzeMood = (songId) => API.post(`/analyze-mood/${songId}`);

// Fetch playlist
export const getSongs = () => API.get("/songs");

export default API;
