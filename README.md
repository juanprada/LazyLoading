# LazyLoading

Requisitos:
JRE 1.8.+

Instrucciones:
- Instalar ElasticSearch 2.4.6
https://www.elastic.co/downloads/past-releases/elasticsearch-2-4-6

- Configuracion elasticsearch:
Vamos al archivo: 
[ruta elasticsearch]/config/elasticsearch.yml

Y adicionamos la siguiente linea:
cluster.name: lazyloadingcluster

Iniciamos el elasticsearch:
[ruta elasticsearch]/bin/elasticsearch.bat

Iniciamos la aplicacion:
java -jar [nombre_jar.jar]
