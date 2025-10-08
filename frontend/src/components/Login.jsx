import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";

const Login = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!email || !password) {
      alert("Please fill in both fields!");
      return;
    }

    // Mock login (no backend yet)
    if (email === "test@gmail.com" && password === "123456") {
      navigate("/dashboard");
    } else {
      alert("Login successful! Redirecting...");
      navigate("/dashboard");
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>Welcome Back 🎵</h2>
        <p>Sign in to explore your music moods</p>
        <form onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Enter your email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Enter your password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <button type="submit">Login</button>
        </form>
        <p className="hint">
          Don’t have an account? <span onClick={() => navigate("/upload")}>Try uploading a song</span>
        </p>
      </div>
    </div>
  );
};

export default Login;

