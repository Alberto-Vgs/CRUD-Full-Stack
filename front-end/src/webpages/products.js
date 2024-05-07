import React, { useState, useEffect } from 'react';
import Api from '../service/config';

const Product = () => {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const api = Api()

    const products =null;

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
                    products = data;
                    console.log(data)
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
                    {/* {products} */}
                </ul>
            </div>
        );
    }
}

export default Product;
