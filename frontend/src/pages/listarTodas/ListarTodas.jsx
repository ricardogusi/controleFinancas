import React, { useEffect, useState } from 'react'
import Dashboard from '../dashboard/Dashboard'
import './listarTodas.css'

export default function Listar() {

    const axios = require('axios');


    const [contas, setContas] = useState([])
    
    
    
    useEffect(()=>{
        axios.get('http://localhost:8081/api/contas/1')
               .then(r => setContas(r.data))
    }, [axios])
                            
            
        
    console.log(contas)
    


    return (
        <Dashboard>
            <div className="box">
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
                        <li>{conta.data[2]}/{conta.data[1]}/{conta.data[0]}</li>
                        <li>{conta.categoria}</li>
                    </ul>         
                    ))}
                    


                </div>
            </div>
        </Dashboard>
    )
}
