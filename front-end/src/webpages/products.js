import React, { useState, useEffect } from 'react';
import Api from '../service/config';

const Product = () => {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [products, setProducts] = useState([]);
    const api = Api()

    // Configurar las opciones de la solicitud fetch
    const requestOptions = {
        method: 'GET',
        headers: {
            'Authorization': `Basic ${api.token}`,
            'Content-Type': 'application/json'
        }
    };

    useEffect(() => {
        fetch(api.apiUrl + "product", requestOptions)
            .then(res => res.json())
            .then(
                (data) => {
                    setIsLoaded(true);
                    setProducts(data.data);
                },
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
        }, [])
        
    if (error) {
        return <div>Error: {error.message}</div>;
    } else if (!isLoaded) {
        return <div>Loading...</div>;
    } else {
        return (
            <div>
                <h1>Product Lists</h1>
                <ul>
                    {products.map(product => (
                        <li key={product.productId}>
                            {product.productName} 
                        </li>
                    ))}
                </ul>
            </div>
        );
    }
}

export default Product;
