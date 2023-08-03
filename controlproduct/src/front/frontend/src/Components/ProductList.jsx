import axios from 'axios'
import React from 'react'
import { useEffect } from 'react'
import { useState } from 'react'

export default function ProductList() {

  const [product,setProduct] = useState([])

  const getAllProducts = ()=>{
    axios.get("http://localhost:8080/products")
    .then(Response =>{
        setProduct(Response.data)
    })
    .catch(error=>{console.log(error)})
  }

  useEffect(()=>{
    getAllProducts()
  },[])
  

  return (
    <div>
        <h1>ProductList</h1>
    </div>
  )
}
