# api-clima
Para ejecutar seguir los siguiente pasos
1- Descargar el proyecto
2- Compilar el proyecto
3- Luego de que se descargen las librerias necesarias correr el proyecto
4- Para probar se puede usar el navegador, postman o simular. el microservicio creado es de tipo GET la url es http://localhost:8080/apiClima/18578 donde 18578 es el codigo de la ciudad en este caso santiago. la api que consulta es http://api.tiempo.com/ esta se puede configurar desde el properties.


El proyecto se realizo utilizando Spring Boot, las peticiones son recibidas por ClimaApi la cual valida los datos de entrada y controla las excepciones de estos, lo logra utilizando un archivo xml donde podemos crear las excepciones que necesitemos otorgandoles severidad, alias, http-status y un mensaje de error personalizado a cada una de ellas.
Luego de validad los parametros se llama a ClimaService que actua como un intermediario entra la capa anterior que es la fachada de nuestros servicios y los datos que pueden ser obtenido desde el DAO, pero para este ejercicio se extrayeron de una api externa.
ClimaIntegracion es la clase que trabaja con esta api externa, esta realiza la llamada y luego rescata los datos y les da el formato necesario que se requiere. si todo es exitoso el flujo recore este camino devuelta para mostrar los datos requeridos en formato JSON.
Tambien se tienen clases de utilidad que principalmente se usan para poder trabajar las excepciones con el archivo xml.
