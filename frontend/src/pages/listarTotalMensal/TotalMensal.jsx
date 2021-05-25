import React, { useState } from "react";
import Dashboard from "../dashboard/Dashboard";

export default function TotalMensal() {
  const axios = require("axios");

  const [contas, setContas] = useState([]);
  const [mes, setMes] = useState("");
  const [ano, setAno] = useState("");
  const [status, setStatus] = useState(true);

  
  function buscar() {
    
    axios
      .get(`http://localhost:8081/api/contas/totalmensal/1/${mes}/${ano}`)
      .then((r) => setContas(r.data));

    setStatus(false);
   
  }

  function handleMes(event) {
    setMes(event.target.value);
  }

  function handleAno(event) {
    setAno(event.target.value);
  }

  function handleVoltar() {
    setStatus(true);
    document.getElementById("selectAno").value = "Ano";
    document.getElementById("selectMes").value = "Mês";
  }

  return (
    <Dashboard>
      <div className={status ? "box" : "boxGone"}>
        <p>Escolha o Mês:</p>
        <select id="selectMes" onChange={handleMes}>
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
        <select id="selectAno" onChange={handleAno}>
          <option>Ano</option>
          <option value="2019">2019</option>
          <option value="2020">2020</option>
          <option value="2021">2021</option>
        </select>
        <button className="buttonSave" onClick={buscar}>
          Buscar
        </button>
      </div>

      <div className={status ? "boxResultGone" : "boxResult"}>
        <div className="containnerContas">
          <ul className="ulTitulo">
            <li style={{ width: "400px" }}>
              Valor Total de {mes}/{ano}
            </li>
          </ul>

          {contas.map((conta, i) => (
            <ul key={i} className="ulConteudo">              
              <li>R$ {conta.valor}</li>
            </ul>
          ))}

          <button className="buttonSave" onClick={handleVoltar}>
            Voltar
          </button>
        </div>
      </div>
    </Dashboard>
  );
}
