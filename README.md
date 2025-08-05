# 🛒 Proyecto Backend BASIC-CART-SYSTEM
Este proyecto es una implementación **básica y funcional** de un sistema de carrito de compras para un futuro
sistema e-commerce desarrollado en **Java-Spring Boot**. Fue creado con fines de aprendizaje, enfocándome en
consolidar conceptos clave como relaciones entre entidades, mapeo con DTOs y arquitectura en capas.

## ⌚ Duración 

Inicio:25/07/2025

Fin:05/08/2025
## 📚 ¿Qué aprendí en este proyecto?
Este proyecto me permitió consolidar varios conceptos fundamentales del desarrollo backend con Spring Boot y trabajar por primera vez con una base de datos relacional (MySQL).

Modelo entidad-relación básico: aprendí a modelar una estructura simple pero funcional que incluye usuarios, productos y un carrito de compras con un listado de ítems (relaciones uno a muchos y muchos a uno).

Manejo de excepciones personalizadas: terminé de comprender el manejo personalizado de errores y respuestas HTTP claras ante fallos como elementos no encontrados o errores de lógica.

Persistencia con JPA y MySQL: configuré una base de datos MySQL usando Workbench y establecí la conexión a través del archivo application.properties, utilizando Spring Data JPA para mapear entidades a tablas y facilitar las operaciones CRUD.

Uso de Postman: probé todos los endpoints de la API REST con Postman, aprendiendo a enviar solicitudes HTTP con distintos métodos (GET, POST, PUT, DELETE) y cuerpos de datos en formato JSON.

Buenas prácticas estructurales: mantuve una estructura clara basada en capas (controller, service, repository, dto, mapper, exception), lo que hace al proyecto más escalable y mantenible.

### 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL (MySQL Workbench)
- Maven
- Postman
- IntelliJ IDEA (IDE)

## 🧱 Funcionalidades implementadas

### ✅ Entidades:
- `User` - Representa a los usuarios.
- `Product` - Representa los productos disponibles.
- `CartItem` - Relación entre el carrito y los productos.
- `ShoppingCart` - Carrito de compras asociado a un usuario.

### ✅ Características:
- Crear productos y usuarios.
- Asociar productos a un carrito (CartItem).
- Obtener el carrito de un usuario.
- Calcular subtotal por producto y total del carrito.
- Limpiar el carrito por ID de usuario.
- Eliminar completamente el carrito.
- DTOs para respuestas limpias.

## 📁 Estructura del proyecto
    src
    └── main
        └── java
            └── com.christianrondon.ecommerce
                ├── config
                ├── controller
                ├── dto
                    ├── CartItem
                        ├── request
                        ├── response
                    ├── Product
                        ├── request
                        ├── response
                    ├── ShoppingCart
                        ├── request
                        ├── response
                    ├── User
                        ├── request
                        ├── response

                ├── entity
                ├── exception
                ├── mapper
                ├── repository
                └── service


## 🧪 Endpoints
### 🛍️ Product

| Método | Endpoint                               | Descripción                                                        |
|--------|----------------------------------------|--------------------------------------------------------------------|
| GET    | /products                              | Listar todos los productos                                         |
| POST   | /products                              | Crear un nuevo producto                                            |
| PUT    | /products/{id}                         | Actualizar un producto por ID                                      |
| DELETE | /products/{id}                         | Eliminar un producto por ID                                        |
| POST   | /products/search/name                  | Buscar productos por nombre                                        |
| POST   | /products/search/category              | Buscar productos por categoría                                     |
| POST   | /products/search/price                 | Buscar productos por rango de precio                               |
| POST   | /products/search/name-category         | Buscar productos por nombre y categoría                            |
| POST   | /products/search/category-priceless    | Buscar productos por categoría con precio menor a X                |
| POST   | /products/search/category-price_greater| Buscar productos por categoría con precio mayor a X                |
| PATCH  | /products/patch/name/{id}              | Actualizar nombre de un producto                                   |
| PATCH  | /products/patch/description/{id}       | Actualizar descripción de un producto                              |
| PATCH  | /products/patch/category/{id}          | Actualizar categoría de un producto                                |

### 👤 User

| Método | Endpoint                        | Descripción                                      |
|--------|---------------------------------|--------------------------------------------------|
| GET    | /users                          | Listar todos los usuarios                        |
| POST   | /users                          | Crear un nuevo usuario                           |
| PUT    | /users/{id}                     | Actualizar un usuario por ID                     |
| DELETE | /users/{id}                     | Eliminar un usuario por ID                       |
| POST   | /users/search/name              | Buscar usuarios por nombre                       |
| POST   | /users/search/email             | Buscar usuarios por correo electrónico           |
| PATCH  | /users/patch/name/{id}          | Actualizar nombre de usuario                     |
| PATCH  | /users/patch/email/{id}         | Actualizar correo electrónico de usuario         |

### 🛒 CartItem

| Método | Endpoint           | Descripción                         |
|--------|--------------------|-------------------------------------|
| POST   | /cart-items/add    | Agregar un producto al carrito      |

### 🛒 ShoppingCart

| Método | Endpoint                          | Descripción                                      |
|--------|-----------------------------------|--------------------------------------------------|
| GET    | /shopping-carts/user/{id}         | Obtener el carrito de compras de un usuario      |
| DELETE | /shopping-carts/clear/user/{id}   | Vaciar el carrito de compras de un usuario       |
| DELETE | /shopping-carts/kill/user/{id}    | Eliminar completamente el carrito de un usuario  |

## 🔨 Siguiente proyecto

### 🚪 Alternativa 1: Sistema de Autenticación (Login)
- 🔐 Implementar un sistema de login básico (sin Spring Security) usando sesiones o tokens manuales.
- 🛡️ Implementar autenticación y autorización con Spring Security, roles y protección de endpoints.

### 💬 Alternativa 2: Aplicación con WebSockets
- 💻 Crear un sistema de chat en tiempo real entre múltiples usuarios.
- 🌐 Desarrollar una red social básica con publicaciones en vivo, notificaciones o reacciones instantáneas.


## 🎯 Objetivos para los siguientes proyectos
🧭 Refinar mi Arquitectura RESTful

- 📌 Nombrar rutas de forma semántica (/api/cart/add → /api/cart-items)

- ⚙️ Usar correctamente los verbos HTTP (GET, POST, PUT, DELETE)

- 🧩 Nombrar métodos de forma coherente y descriptiva

📐 Consistencia en el código

- 🧠 Usar nombres de variables claros y consistentes (productDto, cartItemRequest, etc.)


## ✍️ Autor
Christian Rondón Cachay 

Estudiante de Ingeniería de Software