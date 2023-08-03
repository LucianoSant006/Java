import React, { useState } from 'react';
import axios from 'axios';

const ProductForm = () => {
  const [products, setProduct] = useState({
    name: '',
    description: '',
    price: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/product', product)
      .then(response => {
        console.log('Product created:', response.data);
        setProduct({
          name: '',
          description: '',
          price: ''
        });
      })
      .catch(error => {
        console.error('Error creating product:', error);
      });
  };

  return (
    <div>
      <h2>Create Product</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Name:</label>
          <input type="text" name="name" value={product.name} onChange={handleChange} />
        </div>
        <div>
          <label>Description:</label>
          <input type="text" name="description" 
          value={product.description} onChange={handleChange} />
        </div>
        <div>
          <label>Price:</label>
          <input type="text" name="price" value={product.price} onChange={handleChange} />
        </div>
        <button type="submit">Create</button>
      </form>
    </div>
  );
};

export default ProductForm;