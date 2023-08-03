import React from 'react'
import ProductForm from './components/ProductForm'
import ProductList from './components/ProductList'

export default function App() {
  return (
    <div>
      <h1>Home</h1>
      <ProductList />
      <ProductForm />
    </div>
  )
}
