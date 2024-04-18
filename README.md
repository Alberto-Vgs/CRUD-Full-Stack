# CRUD-Full-Stack
Prueba técnica de programador full-stack usando spring-boot para el back-end y React para el front-end 

# Spring Boot - Documentación de Servicio para Gestión de Productos

Este documento detalla los servicios disponibles para la gestión de productos en la aplicación.

# Product API

This is a sample project for a Spring Boot REST API for managing products.

## Requirements

- Java 17
- Spring Boot 3.2.4
- Spring Boot Starter Data JPA
- Spring Boot Starter Web
- H2 Database
- Lombok
- Spring Boot Starter Test
- Spring Boot Starter Security

## Credenciales de Consumo

Para acceder a los endpoints de la API, se requieren credenciales de autenticación básica. A continuación se detallan las credenciales necesarias:

- **Username:** alberto_vgs
- **Password:** c8be15de-4488-4490-9dc6-fab3f91435c6


## Path de consumo

`http://localhost:8080/back-end/api/v1`

## Guardar Producto

Guarda un nuevo producto en la base de datos.

- **URL:** `/product`
- **Método HTTP:** `POST`
- **Parámetros de cuerpo:** Objeto `ProductDTO` con los detalles del producto a guardar en formato JSON.
- **Respuesta:** Retorna un objeto `ResponseDTO` con el producto guardado y el código de estado HTTP 201 (CREATED).

## Guardar Productos

Guarda una lista de productos en la base de datos.

- **URL:** `/products`
- **Método HTTP:** `POST`
- **Parámetros de cuerpo:** Lista de objetos `ProductDTO` con los detalles de los productos a guardar en formato JSON.
- **Respuesta:** Retorna un objeto `ResponseDTO` con la lista de productos guardados y el código de estado HTTP 201 (CREATED).

## Obtener Lista de Productos

Obtiene una lista de todos los productos disponibles.

- **URL:** `/product`
- **Método HTTP:** `GET`
- **Respuesta:** Retorna un objeto `ResponseDTO` con la lista de productos y el código de estado HTTP 200 (OK).

## Obtener Producto por ID

Obtiene un producto específico por su ID.

- **URL:** `/product/{id}`
- **Método HTTP:** `GET`
- **Parámetros de ruta:** `id` - ID del producto a obtener.
- **Respuesta:** Retorna un objeto `ResponseDTO` con el producto encontrado y el código de estado HTTP 200 (OK).

## Actualizar Producto

Actualiza un producto existente por su ID.

- **URL:** `/product/{id}`
- **Método HTTP:** `PUT`
- **Parámetros de cuerpo:** Objeto `Product` con los nuevos detalles del producto en formato JSON.
    ```json
    {
        "productName": "test",
        "productPrice": "1.50",
        "productQuantity": 3
    }
    ```
- **Parámetros de ruta:** `id` - ID del producto a actualizar.
- **Respuesta:** Retorna un objeto `ResponseDTO` con el producto actualizado y el código de estado HTTP 200 (OK).

## Actualizar Productos

Actualiza una lista de productos existentes.

- **URL:** `/product`
- **Método HTTP:** `PUT`
- **Parámetros de cuerpo:** Lista de objetos `ProductDTO` con los nuevos detalles de los productos en formato JSON.
    ```json
    [
        {
            "productName": "test",
            "productPrice": "1.0",
            "productQuantity": 2
        },
        {
            "productName": "test2",
            "productPrice": "50",
            "productQuantity": 16
        }
    ]
    ```
- **Respuesta:** Retorna un objeto `ResponseDTO` con la lista de productos actualizados y el código de estado HTTP 200 (OK).

## Eliminar Producto por ID

Elimina un producto por su ID.

- **URL:** `/product/{id}`
- **Método HTTP:** `DELETE`
- **Parámetros de ruta:** `id` - ID del producto a eliminar.
- **Respuesta:** Retorna un objeto `ResponseDTO` con el código de estado HTTP 204 (NO CONTENT) indicando que el producto ha sido eliminado exitosamente.

