# Flock Demo

- Una vez iniciada la aplicación de manera local, se puede acceder al siguiente link con documentación de tipo swagger: http://localhost:8080/swagger-ui.html
- En el directorio raíz del proyecto se adjunta una carpeta con una colección para Postman con los modelos de prueba para los dos endpoints.
- Una vez ejecutada, se generará un archivo de logs en el directorio raíz del proyecto  con el nombre **flock-demo-log.log**
- En el archivo **pom.xml** se dejan comentarios sobre los grupos de dependencias usadas y cuál es su uso.

---

## Login


Endpoint que genera un Jason Web Token (JWT con algoritmo HMAC-SHA256) en base a un usuario y contraseña enviados en el body del request, la validez de los mismos es definido en el archivo **application.properties** del proyecto.

- ##### Ejemplo de Request

> **POST** - https://localhost:8080/flock-demo/login

```json
{
    "user": "flock",
    "password": "12345n67890"
}
```

- ##### Ejemplo de Response

```json
{
    "data": {
        "user": "flock",
        "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiZmxvY2siLCJwYXNzd29yZCI6IjEyMzQ1bjY3ODkwIn0.5A9BBCrFdHYhCbJL11OTIwxY3w0Rg8FtFJAx3EVbkt8"
    },
    "errors": null
}
```

- ##### Response Inválido

```json
{
    "data": null,
    "errors": {
        "statusCode": 400,
        "message": "invalid authentication for: ale",
        "trace": null
    }
}
```

---

## Get Coordinates

Endpoint con método GET que consulta la API pública del gobierno nacional (https://apis.datos.gob.ar/georef/api/provincias) y retorna los valores de latitud y longitud geográficas, haciendo una búsqueda por nombre de provincia.

|Parámetro     |Tipo    |Obligatorio |
|--------------|--------|------------|
| provinceName | String | SI         |

- ##### Ejemplo de Request

> **GET** - https://localhost:8080/flock-demo/get-coordinates?provinceName=Mendoza

- ##### Ejemplo de Response

```json
{
    "data": {
        "provinceName": "Mendoza",
        "latitude": -34.6298873058957,
        "longitude": -68.5831228183798
    },
    "errors": null
}
```

- ##### Response Inválido

```json
{
    "data": null,
    "errors": {
        "statusCode": 404,
        "message": "no search results were found for: Brasilia",
        "trace": null
    }
}
```
