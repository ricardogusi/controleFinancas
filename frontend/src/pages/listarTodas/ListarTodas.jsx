import React, { useEffect, useState } from "react";
import Dashboard from "../dashboard/Dashboard";
import "./listarTodas.css";
import deleteImg from "../../assets/delete.svg";

export default function Listar() {
  const axios = require("axios");

  const [contas, setContas] = useState([]);
  

    useEffect(() => {
      axios
      .get("http://localhost:8081/api/contas/1")
      .then((r) => setContas(r.data));
    }, [axios]);
    

  
 


  return (
    <Dashboard>
      <div className="box">
        <div className="containnerplus containnerContas">
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
              <li>
                {conta.data.split("-").reverse().join("/")}
              </li>
              <li>{conta.categoria}</li>
              <li>
                <img className="deleteImg" alt="trashbin" src= {deleteImg} 
                        onClick={() => {
                            axios.delete(`http://localhost:8081/api/contas/${conta.id}`)
                            alert("Conta Deletada")
                            window.location='http://localhost:3000/listarTodas'
                            }} />
              </li>
            </ul>
          ))}
        </div>
      </div>
    </Dashboard>
  );
}
