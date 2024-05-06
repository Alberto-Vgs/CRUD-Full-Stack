import React, { useState, useEffect } from 'react';

const Product = () => {
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [users, setUsers] = useState([]);

    // Credenciales de usuario y contraseña
    const username = 'alberto_vgs';
    const password = 'c8be15de-4488-4490-9dc6-fab3f91435c6';

    // Codificar las credenciales en Base64
    const token = btoa(`${username}:${password}`);

    // URL de la API a la que deseas acceder
    const apiUrl = 'http://localhost:8080/back-end/api/v1/product';

    // Configurar las opciones de la solicitud fetch
    const requestOptions = {
        method: 'GET',
        headers: {
            'Authorization': `Basic ${token}`,
            'Content-Type': 'application/json'
        }
    };

    useEffect(() => {
        fetch(apiUrl, requestOptions)
            .then(res => res.json())
            .then(
                (data) => {
                    setIsLoaded(true);
                    setUsers(data);
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
                    
                </ul>
            </div>
        );
    }
}

export default Product;
