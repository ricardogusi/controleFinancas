import React from "react";
import Dashboard from "../dashboard/Dashboard";

export default function CategoriaAno() {
  return (
    <Dashboard>
      <div className="box">
        <p>Buscar Total por ano agrupado por categoria</p>
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
