import React, { useEffect, useState } from "react";
import Dashboard from "../dashboard/Dashboard";
import "./contasmesano.css";

export default function ContasMesAno() {
  const axios = require("axios");

  const [contas, setContas] = useState([]);
  const [mes, setMes] = useState("");
  const [ano, setAno] = useState("");
  const [status, setStatus] = useState(true);

  useEffect(() => {
    if (mes !== "" && ano !== "") {
      axios
        .get(`http://localhost:8081/api/contas/1/${mes}/${ano}`)
        .then((r) => setContas(r.data));
    }
  }, [axios, ano, mes]);

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
        <button className="buttonSave" onClick={() => setStatus(false)}>
          Buscar
        </button>
      </div>

      <div className={status ? "boxResultGone" : "boxResult"}>
        <div className="containnerContas">
          <ul className="ulTitulo">
            <li>Nome</li>
            <li>Valor</li>
            <li>Data</li>
            <li>Categoria</li>
          </ul>
          {contas.map((conta, i) => (
            <ul key={i} className="ulConteudo">
              <li>{conta.nome}</li>
              <li>R$ {conta.valor}</li>
              <li>{conta.data.split("-").reverse().join("/")}</li>
              <li>{conta.categoria}</li>
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
