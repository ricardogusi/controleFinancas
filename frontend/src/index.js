import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import reportWebVitals from "./reportWebVitals";
import Login from "./pages/login/Login";
import Dashboard from "./pages/dashboard/Dashboard"
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Cadastrar from "./pages/cadastrar/Cadastrar";
import ListarTodas from "./pages/listarTodas/ListarTodas";
import ContasMesAno from "./pages/listarContasMesAno/ContasMesAno"
import CategoriaAno from "./pages/listarCategoriaAno/CategoriaAno";
import CategoriaNome from "./pages/listarCategoriaNome/CategoriaNome";
import TotalMensal from "./pages/listarTotalMensal/TotalMensal";

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <Switch>
        <Route exact path="/">
          <Login />
        </Route>
        <Route path="/dashboard">
          <Dashboard />
        </Route>
        <Route path="/cadastrar">
          <Cadastrar />
        </Route>
        <Route path="/listarTodas">
          <ListarTodas />
        </Route>
        <Route path="/listarContasMesAno">
          <ContasMesAno />
        </Route>
        <Route path="/listarCategoriaAno">
          <CategoriaAno />
        </Route>
        <Route path="/listarCategoriaNome">
          <CategoriaNome />
        </Route>
        <Route path="/listarTotalMensal">
          <TotalMensal />
        </Route>
        



      </Switch>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
