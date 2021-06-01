# proyecto-magneto-mutante
proyecto para validar adn mutante-challenge Meli

## Consumir servicio expuesto en GCP App Engine

Para la prueba el microservicio lo desplegue en google cloud platform en un servicio app engine.
para probarlo se puede consumir mediante Postman la siguiente URL:
```
POST:

https://gcp-sergio-315502.uc.r.appspot.com/mutant

Request:
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}

Response:
true
```

```
GET:

https://gcp-sergio-315502.uc.r.appspot.com/stats

Response:
{
    "count_mutant_dna": 7,
    "count_human_dna": 9,
    "ratio": 0.7777777777777778
}
```

## Ejecutar proyecto local

Ubicarnos en una ruta donde queramos clonar el proyecto y ejecutar el siguiente comando:
```
git clone https://github.com/sforerop/proyecto-magneto.git  
```

Luego de clonar el proyecto debemos ubicar el archivo datastore.json que es la llave para conectarnos a la base de datos, este archivo se encuentra en la carpeta resources del proyecto.

```
proyecto-magneto/src/main/resources/datastore.json
```

una vez ubicado el archivo datastore.json debemos conseguir la ruta completa donde se encuentra el archivo y copiar la ruta completa en el application.properties en la propiedad spring.cloud.gcp.credentials.location de la siguiente manera:

(No olvidar descomentarar la linea si se encuentra comentada)
```
spring.cloud.gcp.credentials.location=file:/home/sforero/IdeaProjects/proyecto-magneto/src/main/resources/datastore.json
```

* Esta configuracion se debe a que la base de datos utilizada para el ejercicio es un cloud Datastore de google, y para la conexion se debe asignar en la propiedad la ruta donde se encuentra la llave para conectarse a la base de datos.

Una vez realizado los pasos anteriores ya podemos correr el propyecto.

Nos ubicamos en la ruta /proyecto-magneto del proyecto clonado y ejecutamos el siguiente comando:
```
mvn clean install

mvn exec:java -Dexec.mainClass="com.magneto.project.MagnetoApplication"
```

Para probar el servicio, este queda expuesto por el puerto 8080, probar de la siguiente manera:
```
POST:
http://localhost:8080/mutant

GET:
http://localhost:8080/stats
```

## Test
Los test de cobertura se pueden encontrar una vez compilado el proyecto con (mvn clean install) en la ruta, estos son generados con la libreria JaCoCo
```
proyecto-magneto/target/site/jacoco/index.html
```