import React from "react";
import { Link } from "react-router-dom";
import "./login.css";

export default function Home() {
  return (
    <div className="containner">
      <div className="loginBox">
        <div className="loginInputs">
          <input type="text" placeholder="E-mail" />
          <input type="password" placeholder="Senha" />
          <Link to="/dashboard">
            <button className="buttonLogin">Login</button>
          </Link>
        </div>
      </div>
    </div>
  );
}
