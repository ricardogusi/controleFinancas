import React, { useEffect, useState } from "react";
import Dashboard from "../dashboard/Dashboard";

export default function CategoriaAno() {

  const axios = require("axios");

  const [contas, setContas] = useState([]);  
  const [ano, setAno] = useState("");

  const [status, setStatus] = useState(true);

  useEffect(() => {
    axios
      .get(
        `http://localhost:8081/api/contas/categorias/1/${ano}`
      )
      .then((r) => setContas(r.data));
  }, [axios, ano]);

 
  function handleAno(event) {
    setAno(event.target.value);
  }

 

  function handleVoltar() {
    setStatus(true);
    document.getElementById("selectAno").value = "Ano"; 
  }




  return (
    <Dashboard>
      <div className={status ? "box" : "boxGone"}>
        <p>Buscar Total por ano agrupado por categoria</p>
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
            <li>Categoria</li>
            <li>Valor Total</li>            
          </ul>
          {contas.map((conta, i) => (
            <ul key={i} className="ulConteudo">
              <li>{conta.categorias}</li>
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
