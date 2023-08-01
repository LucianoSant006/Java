import React, {useState,useEffect} from 'react';
import axios from 'axios';

const ProductList = () => {

    const [products,setProducts] = useState([]); 

    useEffect(() => {
        axios.get('http://localhost:8080/products')
        .then(response =>{

            setProducts(response.data);

        })
        .cath(error => ('Error de listagem de produtos',error));
    },[]);
    
        return (
        <div>
            <h2>Lista de produtos</h2>
            <ul>
                    {products.map(product =>(
                     <li key={product.id}>
                        {product.name} - {product.description} - {product.price}

                     </li>


                    ))} 
            </ul>
        </div>
    );

};








