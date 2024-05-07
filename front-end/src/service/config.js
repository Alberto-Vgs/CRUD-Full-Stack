const Api = () => {
    // Credenciales de usuario y contraseña
    const username = 'alberto_vgs';
    const password = 'c8be15de-4488-4490-9dc6-fab3f91435c6';

    // Codificar las credenciales en Base64
    const token = btoa(`${username}:${password}`);

    // URL de la API a la que deseas acceder
    const apiUrl = 'http://localhost:8080/back-end/api/v1/';
    
    return {"token":token,"apiUrl":apiUrl}
}

export default Api;