import axios from "axios";
import React, { useState } from "react";
import Dashboard from "../dashboard/Dashboard";
import "./cadastrar.css";

export default function Cadastrar() {
  const [nome, setNome] = useState("");
  const [valor, setValor] = useState(0);
  const [data, setData] = useState("");
  const [categoria, setCategoria] = useState("");

  const conta = {
    nome: nome,
    valor: valor,
    data: data,
    categorias: categoria,
    usuarioId: 1,
  };

  function handleNome(event) {
    setNome(event.target.value);
  }

  function handleValor(event) {
    setValor(event.target.value);
  }

  function handleData(event) {
    setData(event.target.value.split("-").reverse().join("/"));
  }

  function handleCategoria(event) {
    setCategoria(event.target.value);
  }

  function saveConta(event) {
    event.preventDefault();
    axios
      .post("http://localhost:8081/api/contas/1", conta)
      .then(alert("Conta cadastrada com sucesso!"));
    

     
  }


  return (
    <Dashboard>
      <div className="box">
        <input type="text" placeholder="Nome da Conta" onChange={handleNome} />
        <input type="number" placeholder="Valor" onChange={handleValor} />
        <input type="date" placeholder="Data" onChange={handleData} />
        <select type="text" placeholder="Categoria" onChange={handleCategoria}>
          <option>Categorias</option>
          <option value="Moradia">Moradia</option>
          <option value="Lazer">Lazer</option>
          <option value="Mercado">Mercado</option>
          <option value="Transporte">Transporte</option>
          <option value="Outros">Outros</option>
        </select>
        <button className="buttonSave" onClick={saveConta}>
          Salvar
        </button>
      </div>
    </Dashboard>
  );
}
