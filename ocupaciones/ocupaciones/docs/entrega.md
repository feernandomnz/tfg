# Entrega del proyecto Ocupaciones

## Estado actual

- El proyecto compila con `./mvnw clean install`
- La arquitectura separa `controller` y `service`
- `Usuario` usa `BCrypt` para cifrar contraseñas
- `Usuario`, `Propiedad` e `Incidencia` exponen CRUD basico
- Las relaciones se modelan con `@ManyToOne`
- `application.properties` se elimino del repositorio

## Endpoints principales

### Usuarios

- `GET /usuarios`
- `GET /usuarios/{id}`
- `POST /usuarios`
- `DELETE /usuarios/{id}`

Ejemplo de alta:

```json
{
  "email": "demo@ocupaciones.com",
  "password": "123456"
}
```

### Propiedades

- `GET /propiedades`
- `GET /propiedades/{id}`
- `POST /propiedades`
- `DELETE /propiedades/{id}`

### Incidencias

- `GET /incidencias`
- `GET /incidencias/{id}`
- `POST /incidencias`
- `DELETE /incidencias/{id}`

## Prueba automatica incluida

El test de integracion valida:

- Creacion de usuario por `POST`
- Consulta por `GET`
- Borrado por `DELETE`
- Password guardada cifrada con prefijo BCrypt `$2`
