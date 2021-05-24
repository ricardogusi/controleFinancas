import React from "react";
import Dashboard from "../dashboard/Dashboard";
// import Listar from "../listarTodas/ListarTodas";

export default function ContasMesAno() {
  return (
    <Dashboard>
      <div className="box">
        <p>Escolha o Mês:</p>
        <select>
          <option>Mês</option>
          <option value="1">Janeiro</option>
          <option value="2">Fevereiro</option>
          <option value="3">Março</option>
          <option value="4">Abril</option>
          <option value="5">Maio</option>
          <option value="6">Junho</option>
          <option value="7">Julho</option>
          <option value="8">Agosto</option>
          <option value="9">Setembro</option>
          <option value="10">Outubro</option>
          <option value="11">Novembro</option>
          <option value="12">Dezembro</option>
        </select>

        <p>Escolha o Ano</p>
        <select>
          <option>Ano</option>
          <option value="2019">2019</option>
          <option value="2020">2020</option>
          <option value="2021">2021</option>
        </select>
        <button className="buttonSave">Buscar</button>
      </div>

      {/* <Listar></Listar> */}
    </Dashboard>
  );
}