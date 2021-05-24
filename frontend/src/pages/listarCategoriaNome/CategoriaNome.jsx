import React from "react";
import Dashboard from "../dashboard/Dashboard";

export default function CategoriaNome() {
  return (
    <Dashboard>
      <div className="box">
        <input type="text" placeholder="Nome da Categoria" />
        <select>
          <option>Ano</option>
          <option value="2019">2019</option>
          <option value="2020">2020</option>
          <option value="2021">2021</option>
        </select>
        <button className="buttonSave">Buscar</button>
      </div>
    </Dashboard>
  );
}
