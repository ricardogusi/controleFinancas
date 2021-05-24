import React from "react";
import { Link } from "react-router-dom";
import "./dashboard.css";

export default function Dashboard({children}) {
  return (
    <div className="containnerPrincipal">
      <div className="dashboard">
        <div className="menu">         
        <Link to="/dashboard">
          <div className="home">Home</div>
          </Link>   
          <Link to="/cadastrar">
          <div className="cadastrar">Cadastrar Gasto</div>
          </Link>
          <Link to="/listarTodas">
          <div className="listar">Listar Contas</div>
          </Link>

          <Link to="/listarContasMesAno">
          <div className="listar">Contas Por Mês/Ano</div>
          </Link>

          <Link to="/listarCategoriaNome">
          <div className="listar">Categoria por Nome</div>
          </Link>

          <Link to="/listarCategoriaAno">
          <div className="listar">Categoria por Ano</div>
          </Link>

          <Link to="/listarTotalMensal">
          <div className="listar">Total Mensal</div>
          </Link>



        </div>
        <div className="children">
          {children}
        </div>
      </div>
    </div>
  );
}
