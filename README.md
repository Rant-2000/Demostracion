
# Mini Demostración API REST en Spring Boot con JPA y MySQL 8

Este proyecto es una demostración de una API REST utilizando Spring Boot, JPA (Java Persistence API) y MySQL 8 como base de datos.

## Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

- **Java 17** o superior
- **Maven** (si no lo usas como parte de tu IDE)
- **MySQL 8** o superior
- **Git** (para clonar el repositorio)

## Configuración de la base de datos

1. Crea una base de datos MySQL llamada `demostracion_api`:
   ```sql
   CREATE DATABASE demostracion_api;
   ```

2. Configura tu conexión a la base de datos en el archivo `src/main/resources/application.properties` o `application.yml` con las credenciales correctas:

   ### Si usas `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/demostracion_api?useSSL=false&serverTimezone=UTC
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

   ### Si usas `application.yml`:
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/demostracion_api?useSSL=false&serverTimezone=UTC
       username: tu_usuario
       password: tu_contraseña
     jpa:
       hibernate:
         ddl-auto: update
       show-sql: true
   ```

## Ejecutar el Proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/demostracion-api-rest.git
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd demostracion-api-rest
   ```

3. Ejecuta el proyecto usando Maven:
   ```bash
   mvn spring-boot:run
   ```

4. La API estará disponible en `http://localhost:8080`.

## Endpoints de la API

### 1. Verificar Conexión
- **Método**: `GET`
- **URL**: `/`
- **Descripción**: Verifica que la API está funcionando.
- **Respuesta**:
  ```json
  "Conectado"

  ### 2. Listar clientes
- **Método**: `GET`
- **URL**: `/Clientes`
- **Descripción**: Obtiene una lista de todos los clientes almacenados.
- **Respuesta**:
  ```json
  [
  {
    "idCliente": 1,
    "nombre": "Juan",
    "apellidos": "Pérez"
  },
  {
    "idCliente": 2,
    "nombre": "Ana",
    "apellidos": "García"
  }
  ]
  ```
### Crear un nuevo Cliente
- **Método**: `POST`
- **URL**: `/guardar`
- **Cuerpo del Request**:
  ```json
  {
    "nombre": "Juan",
    "apellidos": "Pérez"
  }
  ```
- **Respuesta**: `200 Correcto`

### Actualizar un Cliente
- **Método**: `PUT`
- **URL**: `/editar/{idCliente}`
- **Cuerpo del Request**:
  ```json
  {
    "nombre": "Carlos",
    "apellidos": "López"
  }
  ```
- **Respuesta**: `200 Actualizado`


  ### Eliminar un Cliente
- **Método**: `DELETE`
- **URL**: `/clientes/{idCliente}`
- **Respuesta**: `200 Cliente borrado`

- 

## Estructura del Proyecto

```plaintext
src
├── main
│   ├── java
│   │   └── com
│   │       └── ejemplo
│   │           └── api
│   │               ├── controller
│   │               │   └── ClienteController.java
│   │               ├── model
│   │               │   └── Cliente.java
│   │               ├── repository
│   │               │   └── ClienteRepository.java
│   │               └── DemoApiApplication.java
│   └── resources
│       ├── application.properties
│       └── data.sql
└── test
```

## Dependencias Utilizadas

- **Spring Boot Starter Web**: Para crear la API REST.
- **Spring Boot Starter Data JPA**: Para la interacción con la base de datos mediante JPA.
- **MySQL Connector**: Para la conexión con MySQL.
- **Spring Boot Starter Test**: Para pruebas unitarias.

## Licencia

Este proyecto está bajo la licencia MIT. Puedes ver más detalles en el archivo `LICENSE`.

