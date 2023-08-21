# LABORATORIO 1 - AREP 
### AUTOR: David Eduardo Valencia  
En este laboratorio se baso en la contruccion de un servidor http de tipo fachada en donde se hacia una conexion por socket con una conexion a un servicio api RES, con el fin de la consulta de peliculas

## Empezando

### Directorios
En este proyecto se encontrara dos directorios principales uno llamado [classwork](/Proyect1/src/main/java/org/example/classwork/) y otro llamado [Server](Proyect1/src/main/java/org/example/Server/), para este laboratorio se requiere nada mas ejecutar el archivo HTTPServer que se encuentra dentro del directorio Server, es decir la carpeta classwork no es necesaria sin embargo al haber sido hecha como trabajo en clase se dejara por temas de estudio.

### Documentacion
La documentación de este proyecto se encuentra en el directorio [doc](Proyect1/doc/)

## En Funcionamiento
### ¿Como funciona?
La manera en que se debe iniciar el proyecto es llendo hacia la clase HTTPServer la cual se encuentra en el directorio Server ya antes mencionado, una vez ahi solo se requiere ejecutar la clase y en su navegador de confianza(en mi caso es FIREFOX) poner lo siguiente: 
`localhost:35000` ya que este es el puerto del socket que se abre.

Una vez ahi tiene dos inputs uno con el metodo GET y uno con el Metodo Post, ahi usted como usuario es libre de elegir, Escibiendo el nombre y dandole submit.

### ¿Cual es la Logica?
La logica detras del funcionamiento es que el servidor fachada que ve el usuario, recibe mensajes en formato json de un servidor que se conecta al api de [OMBapi](https://www.omdbapi.com), aunque solo lo hara en el caso de que en el cache el cual es resistente a la concurrencia no tenga esa busqueda ya guardada.

Una vez hace la consulta al api para mostrar la informacion se usa la libreria de json incluida en Java y que se encuentra en el pom del proytecto. Con esta libreria, se puede mappear el json con el fin de contruir un listado para mostrar la informacion de manera organizada, y asi mostrar en el html de manera facil para el usuario y no como se mostraria un json.

### Posible extensibilidad
Al usar un json convertido en un hashmap los valores que se tienen pueden ser mostrados todos los que se deseen es decir que como funciona solo muestra algunos, pero si se desea se podria mostrar imagen, actores con fotos etc. Es completamente extensible

### Ejemplo de como se podria obtener un proveedor de servicios diferente
Para tener un proveedor de servicios diferentes habria que primero cambiar la direccion del GET/POST haciendo una segunda opcion dentro del html, ya que los metodos que se utilizan serian los mismos ya que cumplen una funcion "Universal" en cuanto a formatos json.
Una vez hecho esto habira que crear una nueva clase que se conecte a otro api y la fachada se pueda conectar a ella. Una vez conectada es solo aprovechar los metodos y ya seria suficiente para usar otro servicio.
## Herramientas Utilizadas

### Dependencias
[Maven](https://maven.apache.org)
### Control de Versiones
[GIT](https://git-scm.com)

## REFERENCIAS
 1.https://stackoverflow.com/questions/21720759/convert-a-json-string-to-a-hashmap

2.https://www.w3schools.com/js/js_json_html.asp

3.Snippets Dados por el Profesor

4.https://www.w3schools.com/css/

5.https://www.geeksforgeeks.org/concurrenthashmap-in-java/

6.https://www.w3schools.com/html/html_lists.asp
