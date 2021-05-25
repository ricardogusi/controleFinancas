import React, { useEffect, useState } from "react";
import Dashboard from "../dashboard/Dashboard";
import '../listarContasMesAno/contasmesano.css'

export default function CategoriaNome() {
  const axios = require("axios");

  const [contas, setContas] = useState([]);
  const [categoria, setCategoria] = useState("");
  const [mes, setMes] = useState("");
  const [ano, setAno] = useState("");

  const [status, setStatus] = useState(true);

  useEffect(() => {
    axios
      .get(
        `http://localhost:8081/api/contas/categoria/1/${categoria}/${mes}/${ano}`
      )
      .then((r) => setContas(r.data));
  }, [axios, ano, categoria, mes]);

  function handleMes(event) {
    setMes(event.target.value);
  }

  function handleAno(event) {
    setAno(event.target.value);
  }

  function handleCategoria(event) {
    setCategoria(event.target.value);
  }

  function handleVoltar() {
    setStatus(true);
    document.getElementById("selectAno").value = "Ano";
    document.getElementById("selectMes").value = "Mês";
    document.getElementById("selectCategoria").value = "Categorias";
  }

  

  return (
    <Dashboard>
      <div className={status ? "box" : "boxGone"}>
        <select
          id="selectCategoria"
          type="text"
          placeholder="Categoria"
          onChange={handleCategoria}
        >
          <option>Categorias</option>
          <option value="Moradia">Moradia</option>
          <option value="Lazer">Lazer</option>
          <option value="Mercado">Mercado</option>
          <option value="Transporte">Transporte</option>
          <option value="Outros">Outros</option>
        </select>
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
        <select id="selectAno" onChange={handleAno}>
          <option>Ano</option>
          <option value="2019">2019</option>
          <option value="2020">2020</option>
          <option value="2021">2021</option>
        </select>
        
        <button className="buttonSave" onClick={()=> setStatus(false)}>Buscar</button>
      </div>

      <div className={status ? "boxResultGone" : "boxResult"}>
        <div className="containnerContas">
          
          <ul className="ulTitulo">
            <li>Nome</li>
            <li>Valor Total</li>            
          </ul>
          
            <ul className="ulConteudo">
              <li>{contas.categorias}</li>
              <li>R$ {contas.valor}</li>              
            </ul>
          
          <button className="buttonSave" onClick={handleVoltar}>
            Voltar
          </button>
        </div>
      </div>
    </Dashboard>
  );
}
