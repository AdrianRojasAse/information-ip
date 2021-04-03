# Challenge IP

### Aplicación:
La presente aplicación provee información sobre una dirección IP y cuenta con una BlackList para la validación de IPs prohibidas.

### Tecnologias :
- Java 11 
- Maven 3.6.3
- Docker 20.10

### Pasos para instalar:
1) Clonar el repo en local: `git clone https://github.com/AdrianRojasAse/information-ip.git` y ubicarse en ruta principal del proyecto.

- Para generar el jar y ejecuatarlo con la JVM se debe realizar el siguientes comandos:


  `mvn clean install`

- una vez se compile correctamente el proyecto ingresamos en la carpeta target y ejecutamos el siguente comando

  `java -jar ejercicio_IP-0.0.1-java.jar`

* Para la ejecución de la aplicación en contenedor docker se debera realizar los siguientes comandos:

	- generación del ejecutable
  `mvn clean install`

	- creación de la imagen
  `docker build -t ejecicio-ip:latest .`

	- creación del contenedor
  `docker run --name ejecicio-ip -p 8080:8080 -d ejecicio-ip`
    


### Consumo API:
> Método y endpoint de la api para la consulta de información ip
- `GET http://localhost:8080/api/ip/country/{ip}

Ejemplo:
- `GET` http://localhost:8080/api/ip/country/198.10.1.5

## Pruebas

### la evidencia de la ejecución de encuentra en el directorio Screenshots
- http://localhost:8080/api/ip/country/5.6.7.8
		response json:
			{
	"status": "succcess",
	"error": false,
	"message": "",
	"body": {
		"countryName": "Germany",
		"isoCode": "DEU",
		"currencyName": "Germany",
		"currencyValue": 1.0
	}
}

### Lista de IP's para la blacklist
-'186.84.91.68'
-'186.84.91.69'
-'186.84.91.70'
-'186.84.91.71'
-'186.84.91.59'
-'186.84.91.61'
-'186.84.91.62'
-'186.84.91.63'
-'186.84.91.64'
-'186.84.91.65'
-'186.84.91.66'
-'186.84.91.67'
-'186.84.91.72'
-'186.84.91.73'
-'186.84.91.74'
-'186.84.91.75'

### Nota
- Realizar el registro en http://data.fixer.io/api/ para obtener la key para el uso  del servicio de consulta de información de las monedas.
