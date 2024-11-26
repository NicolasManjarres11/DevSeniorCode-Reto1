# Simulación de un Viaje Interplanetario 🧑‍🚀 🚀
## Descripción
Este programa simula un viaje interplanetario a los planetas de nuestro sistema solar, permitiendo al usuario explorar distancias, tiempos de viaje y consumo de recursos según el destino seleccionado y las características de la nave espacial.

## Características
* Selección de planetas como destino. 🌍
* Cálculo del tiempo de viaje según la velocidad de la nave. 🚀
* Estimación del consumo de combustible y oxigeno basado en la distancia. ⛽ 
* Visualización de los resultados a través de la consola. 💻
* Encuentro con eventos aleatorios que afectan el transcurso del viaje. ⛓️‍💥

## Requisitos del Sistema
Lenguaje de programación: Java (versión 21).
Entorno de ejecución: JDK (Java Development Kit).
Dependencias: Ninguna.

## Instrucciones de Instalación 👩‍💻
### Clonar el repositorio:
`git clone <https://github.com/NicolasManjarres11/DevSeniorCode-Reto1.git>`

### Ejecutar el programa: 
En la terminal, navega a la carpeta del proyecto y ejecuta:
`java App.java`

## Uso 🎮
Al ejecutar el programa, se presentará un menú con cuatro opciones:
* Seleccionar un planeta de destino.
* Seleccionar una nave espacial.
* Iniciar la simulación de viaje.
* Salir del programa.
  
Para dar inicio, el usuario bajo la opción 1 deberá elegir el planeta de destino. Allí podrá encontrar la lista de los diferentes planetas de 
nuestro planeta solar, cada uno con sus respectivas características básicas como distancia desde la tierra y descripción (si el usuario elige una opción por fuera del rango deberá intentarlo de nuevo).

Luego, el usuario podrá elegir una de las cuatro naves para realizar su viaje, cada nave cuenta con una velocidad constante
y la capacidad pasajeros (si el usuario elige una opción por fuera del rango deberá intentarlo de nuevo).

Si el usuario ya ha elegido el planeta destino y la nave con la que viajará, podrá iniciar la simulación del viaje bajo la opción número 3. 
Esta solicitará el cargue de los recursos para el viaje, el usuario podrá decidir entre cargar las cantidades automáticamente según lo recomendado
 o elegirlas manualmente. Una vez hecho, se dará inicio al viaje mostrando en consola las características básicas de este, como la nave elegida, el planeta, la distancia, la velocidad y la duración estimada del viaje. En casa paso (porcentaje) el 
programa indicará la cantidad de recursos restantes, la distancia recorrida y el tiempo restante de viaje. 

El programa mostrará las etapas clave del viaje como el inicio, la mitad de este o la llegada a destino. Además, se arrojarán eventos aleatorios durante la simulación que necesitarán la intervención 
del usuario para tomar decisiones que afecten los recursos disponibles.

Ya sea que el viaje haya finalizado con éxito o la nave se haya quedado sin recursos, el programa indicará la terminación de la simulación y su estado dependiendo del caso.

Finalmente, el usuario podrá iniciar la simulación de otro viaje o seleccionar la opción número 4 para cerrar el programa.

### Estructura de Carpetas 📂
El espacio de trabajo contiene dos carpetas por defecto, donde:

📁 src: la carpeta para mantener los archivos fuente.

📁 lib: la carpeta para mantener las dependencias.

Mientras tanto, los archivos compilados se generarán en la carpeta bin por defecto.


