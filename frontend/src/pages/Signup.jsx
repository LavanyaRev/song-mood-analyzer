import React, { useState } from "react";
import { Link } from "react-router-dom";

const Signup = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleSignup = (e) => {
    e.preventDefault();
    alert("Signup successful!");
  };

  return (
    <div
      style={{
        height: "100vh",
        background: "linear-gradient(135deg, #fbc2eb 0%, #a6c1ee 100%)",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        fontFamily: "Poppins, sans-serif",
      }}
    >
      <div
        style={{
          background: "rgba(255,255,255,0.9)",
          padding: "40px 50px",
          borderRadius: "20px",
          boxShadow: "0 8px 25px rgba(0,0,0,0.1)",
          width: "350px",
          textAlign: "center",
        }}
      >
        <h1 style={{ color: "#2c3e50", marginBottom: "20px" }}>Sign Up</h1>
        <form onSubmit={handleSignup}>
          <input
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            style={inputStyle}
          />
          <input
            type="password"
            placeholder="Password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            style={inputStyle}
          />
          <button type="submit" style={buttonStyle}>
            Sign Up
          </button>
        </form>
        <p style={{ marginTop: "10px" }}>
          Already have an account?{" "}
          <Link to="/login" style={{ color: "#8e44ad" }}>
            Login
          </Link>
        </p>
      </div>
    </div>
  );
};

const inputStyle = {
  width: "100%",
  padding: "10px",
  margin: "10px 0",
  border: "1px solid #ccc",
  borderRadius: "8px",
  fontSize: "1rem",
};

const buttonStyle = {
  width: "100%",
  padding: "10px",
  background: "linear-gradient(90deg, #d4fc79, #96e6a1)",
  color: "#fff",
  border: "none",
  borderRadius: "8px",
  fontSize: "1rem",
  cursor: "pointer",
};

export default Signup;
