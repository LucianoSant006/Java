import axios from 'axios'
import React from 'react'
import { useState } from 'react'

export default function ProductForm() {

    const [product, setProduct] = useState({
        name: "",
        price: "",
        description: ""
    })

    const handleChange = (e) => {
        const [name, value] = e.target
        setProduct(valorAntigo => ({
            ...product,
            [name]: value
        }))
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        axios.post("http://localhost:8080/products").then(response => {
            console.log("product created", response.data)
            setProduct({
                name: "",
                price: "",
                description: ""
            })
        })
            .catch(error => { console.log(error) })
    }



    return (
        <div>
            <h1>ProductForm</h1>
        </div>
    )
}
