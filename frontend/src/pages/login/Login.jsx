import React from "react";
import { Link } from "react-router-dom";
import "./login.css";

export default function Home() {
  return (
    <div className="containner">        
      <div className="loginBox">
        <div className="loginInputs">
          <input placeholder="E-mail" />
          <input placeholder="Senha" />
          <Link to="/dashboard">
          <button className="buttonLogin" to="/dashboard" >Login</button>
          </Link>
        </div>
      </div>
    </div>
  );
}
