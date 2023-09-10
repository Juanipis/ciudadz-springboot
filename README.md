# ciudadz-springboot
Trabajo de implementación e interación de hardware

# Configuraciones para correr
## Configuración de la base de datos para desarollo
1. en la carpeta java/database/dev crear un .env con las siguientes variables
```
POSTGRES_USER=
POSTGRES_PASSWORD=
POSTGRES_DB=
DB_HOST_PORT=
PGADMIN_DEFAULT_EMAIL=
PGADMIN_DEFAULT_PASSWORD=
PGADMIN_HOST_PORT=
```
2. En vscode correr la tarea "Run database dev container and pgadmin"
3. Listo, ya tienes la base de datos corriendo en el puerto 5432 y pgadmin en el puerto 5050
4. El host de la base de datos para poner en pgadmin es "pg_container_ciudadz", el usuario y contraseña son los que pusiste en el .env

## Configuración de srpingboot application.properties
1. en la carpeta java/backend/src/main/resources crear un application.properties con las siguientes variables
```
server.port
spring.datasource.url=jdbc:postgresql://localhost:5432/test_db
spring.datasource.username=
spring.datasource.password=
springdoc.api-docs.enabled=
springdoc.swagger-ui.enabled=
springdoc.swagger-ui.path=
spring.jpa.properties.hibernate.dialect=
spring.jpa.hibernate.ddl-auto=
spring.jpa.show-sql=
```
2. Listo, ya puedes correr springbooy
