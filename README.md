# BassicBlog

BassicBlog es un sistema avanzado de gestión de blogs desarrollado con **Java Spring Boot**. Este proyecto incluye funcionalidades CRUD completas para publicaciones, categorías, etiquetas, usuarios y roles. Además, permite la subida de imágenes mediante la integración con **Imgbb** y utiliza una base de datos PostgreSQL en un contenedor Docker.

## Funcionalidades principales

1. **Gestión de publicaciones**: Crear, listar y eliminar publicaciones, incluyendo la subida de imágenes.
2. **Gestión de categorías**: Organizar las publicaciones en categorías.
3. **Gestión de etiquetas**: Asignar etiquetas a las publicaciones para mejorar la búsqueda.
4. **Gestión de usuarios**: Crear y administrar usuarios.
5. **Gestión de roles**: Crear, modificar y eliminar roles.
6. **Subida de imágenes**: Integración con **Imgbb** para el manejo de imágenes.

## Estructura de endpoints

### Publicaciones (`/post`)
- **GET** `/post`: Obtiene todas las publicaciones.
- **POST** `/post`: Crea una publicación con imagen, título, contenido, autor, categoría y etiquetas.
- **DELETE** `/post`: Elimina una publicación específica.
- **POST** `/post/upload`: Sube una imagen a Imgbb y devuelve la URL.

### Categorías (`/category`)
- **GET** `/category`: Obtiene todas las categorías.
- **POST** `/category`: Crea una nueva categoría.
- **DELETE** `/category`: Elimina una categoría existente.

### Etiquetas (`/tag`)
- **GET** `/tag`: Obtiene todas las etiquetas.
- **POST** `/tag`: Crea una nueva etiqueta.
- **DELETE** `/tag`: Elimina una etiqueta existente.

### Usuarios (`/user`)
- **GET** `/user`: Obtiene todos los usuarios.
- **POST** `/user`: Crea un nuevo usuario.
- **DELETE** `/user`: Elimina un usuario existente.

### Roles (`/role`)
- **GET** `/role`: Obtiene todos los roles.
- **GET** `/role/{id}`: Obtiene un rol por su ID.
- **POST** `/role/create`: Crea un nuevo rol.
- **PUT** `/role`: Actualiza un rol existente.
- **DELETE** `/role`: Elimina un rol.

## Configuración

### Docker Compose

El proyecto utiliza una base de datos PostgreSQL configurada mediante Docker Compose. A continuación, se muestra el archivo `docker-compose.yaml`:

```yaml
services:
  postgres:
    image: 'postgres:latest'
    environment:
      - 'POSTGRES_DB=blogDB'
      - 'POSTGRES_PASSWORD=qwGa3PArSd435'
      - 'POSTGRES_USER=userblogDB'
    ports:
      - '5432:5432'
```

### Archivo `application.properties`

El archivo de configuración utiliza variables de entorno para gestionar los valores sensibles y la configuración dinámica:

```properties
spring.application.name=blog

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update

springdoc.swagger-ui.enabled=true
springdoc.api-docs.enabled=true

server.port=8088

# Configuración del token para Imgbb
imgbb.api.token=${IMGBB_API_TOKEN}
```

### Variables de entorno

Asegúrate de definir las siguientes variables de entorno antes de iniciar el proyecto:

```bash
export DB_URL=jdbc:postgresql://localhost:5432/blogDB
export DB_USERNAME=userblogDB
export DB_PASSWORD=qwGa3PArSd435
export IMGBB_API_TOKEN=adbe48b6f1ccf0cfde757e0f2b70e15f
```

## Servicio de subida de imágenes

El proyecto utiliza **Imgbb** para gestionar la subida de imágenes. El token de la API se configura en el archivo `application.properties` como se muestra arriba. La clase `ImgbbService` se encarga de realizar las solicitudes a la API de Imgbb.

## Requisitos

- **Java** 17 o superior.
- **Maven** para la gestión de dependencias.
- **Docker** y **Docker Compose** para la base de datos.
- **Imgbb API Token** para subir imágenes.
- **Postman** (opcional) para probar los endpoints.

## Ejecución

1. Clona el repositorio:
   ```bash
   git clone <URL-del-repo>
   cd BassicBlog
   ```

2. Levanta la base de datos con Docker:
   ```bash
   docker-compose up -d
   ```

3. Configura las variables de entorno necesarias.

4. Ejecuta el proyecto:
   ```bash
   mvn spring-boot:run
   ```

## Próximos pasos

- Implementar autenticación y autorización con **Spring Security**.
- Mejorar la validación y manejo de errores.
- Agregar ejemplos de solicitudes y respuestas JSON en la documentación.

---

¿Te gustaría que agreguemos ejemplos de peticiones con cURL o Postman para probar los endpoints? También podría incluir un diagrama de arquitectura si es necesario.

