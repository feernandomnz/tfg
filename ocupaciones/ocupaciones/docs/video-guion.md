# Guion de video de demostracion

Duracion sugerida: 2 a 3 minutos

## Escena 1. Arranque

1. Abrir terminal en la raiz del proyecto
2. Ejecutar `./mvnw spring-boot:run`
3. Explicar que la aplicacion levanta sin `application.properties` local

## Escena 2. Crear usuario

1. En Postman o Thunder Client hacer `POST /usuarios`
2. Body:

```json
{
  "email": "demo@ocupaciones.com",
  "password": "123456"
}
```

3. Mostrar respuesta `201 Created`

## Escena 3. Ver listado

1. Hacer `GET /usuarios`
2. Explicar que aparece el usuario creado
3. Resaltar que la password no se guarda en texto plano

## Escena 4. Evidencia de BCrypt

1. Mostrar la tabla `usuario` en H2 o en la base elegida
2. Enseñar que la clave empieza por `$2`

## Escena 5. CRUD del resto

1. Hacer `GET /propiedades`
2. Hacer `GET /incidencias`
3. Explicar que tambien tienen alta, consulta por id y borrado

## Cierre

- Recordar: compilacion correcta, arquitectura controller + service, CRUD funcional, seguridad basica y relaciones JPA
