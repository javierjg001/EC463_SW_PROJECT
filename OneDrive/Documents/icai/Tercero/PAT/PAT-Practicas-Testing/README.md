# Practica 6: Testing de una aplicacion de Spring Boot

## Objetivo de la práctica

Dado un desarrollo de Spring Boot, es necesario anhadir tests a las siguientes clases:

- DNI & Telefono (Unit Tests) (Cada clase tiene un metodo y varias casuisticas para probar)
- ProcessController (E2E Tests) (2 endpoints)

```
mvn clean spring-boot:run

curl -v -X POST http://localhost:8080/api/v1/process-step1-legacy \
   -H "Content-Type: application/x-www-form-urlencoded" \
   -d "fullName=Juan%20Antonio%20Brena%20Moral&dni=12345678Z&telefono=%2B34%20600903434"

curl -v -X POST http://localhost:8080/api/v1/process-step1 \
   -H 'Content-Type: application/json' \
   -d '{"fullName":"Juan Antonio Brena Moral","dni":"12345678Z", "telefono":"+34 600903434"}'
```

## Entrega

Sube la practica solucionada a un repositorio de Github.
y crea un documento en formato Markdown, explicando las casuisticas que se van a probar.

## Criterios de evaluación

- 0 -> 5
    - Entregar en fecha
    - Subir ejemplo a Github
    - Ejemplo funcional
    - Aparentemente funciona
    - Con README
- 5 -> 9
    - La práctica entregada hace lo que se pide
- 9 -> 10
    - El alumno explora la materia y añade elementos adicionales

**Nota:** Si el alumno no entrega a tiempo la practica, la calificacion maxima
sera de un 5 si el retraso es de una semana y no presentado si el retraso es major.

## References

- https://docs.spring.io/spring-boot/docs/1.5.16.RELEASE/reference/html/boot-features-testing.html
- https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/web/client/TestRestTemplate.html
- https://www.urlencoder.org/