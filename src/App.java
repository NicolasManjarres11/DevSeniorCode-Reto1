
import java.util.Random;
import java.util.Scanner;

public class App {

    // Clases a utilizar
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    // Planetas, detalles y descripción
    public static String[] planets = { "Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno" };
    public static double[] distances = { 91.0, 41.0, 78.0, 628.0, 1275.0, 2723.0, 4351.0 };
    public static String[] descriptionPlanet = {
            "El planeta más cercano al Sol, un mundo abrasador durante el día y helado por la noche.",
            "Una joya envuelta en nubes tóxicas, con un calor infernal y volcanes activos.",
            "El planeta rojo, hogar de enormes cañones y montañas; el próximo objetivo para la humanidad.",
            "El gigante gaseoso con tormentas eternas, incluido el icónico Gran Mancha Roja.",
            "Majestuoso con sus anillos helados, un espectáculo visual en el cosmos.",
            "Un mundo azul verdoso que gira de lado, envuelto en misterio y frío extremo.",
            "El reino del viento y las tormentas más rápidas, con un hermoso tono azul profundo."
    };

    // Naves espaciales y detalles
    public static String[] starships = { "Astra Voyager", "Pioneer Horizon", "Stellar Odyssey", "Cosmos Endeavor", };
    public static double[] speed = { 4.0, 5.0, 3.0, 6.0 }; // Velocidades en millones de km/h
    public static int[] maxPassengers = { 20, 25, 40, 10 }; // Capacidad maxima de pasajeros

    // Variables a utilizar
    public static int chosenPlanet;
    public static int chosenStarship;
    public static double fuelReserve;
    public static double oxigenReserve;
    public static int passengers;

    // Variables logicas (booleanas)
    static boolean confirmChosenStarship;
    static boolean confirmChosenPlanet;


    public static void main(String[] args) {
        menu();
    }


    // Menú de opciones
    public static void menu() {

        do {
            int option;

            
            System.out.println("""

                |========================================|
                |   Simulador de Viaje interplanetario   |
                |========================================|
                """);
            System.out.println("Selecciona una de las siguientes opciones:");
            System.out.println("\n1. Seleccionar un planeta de destino.");
            System.out.println("2. Seleccionar una nave espacial.");
            System.out.println("3. Iniciar la simulación de viaje.");
            System.out.println("4. Salir del programa.");
            System.out.print("\nIngrese el número de la opción deseada: ");
            option = sc.nextInt();
            System.out.println("");

            switch (option) {
                case 1:
                    choosePlanet();
                    break;
                case 2:
                    chooseStarship();
                    break;
                case 3:
                    travelSimulation();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0); // Cierra el programa
                    break;
                default:
                    System.err.println("Opción inválida. Inténtelo de nuevo");
            }
        } while (true);
    }

    // Metodo de impresion de planetas
    public static void showPlanets() {
        System.out.println("Planetas disponibles: ");
        for (int i = 0; i < planets.length; i++) {
            System.out.println((i + 1) + ". " + planets[i] + " | Distancia: " + distances[i] + " millones de kilómetros.");
        }
    }

    // Metodo de selección de planeta
    public static void choosePlanet() {

        showPlanets();

        int option;

        do {
            System.out.print("Ingresa el número del planeta que deseas elegir: ");
            option = sc.nextInt();

            if (!(option <= planets.length)) {
                option = 0;
                System.out.println("Opción inválida. inténtelo de nuevo.");
                System.out.println();
                showPlanets();

            } else {
                System.out.println("\nHaz seleccionado el planeta: " + planets[option - 1]);
                System.out.println(descriptionPlanet[option - 1]);
                sc.nextLine();
                System.out.println("Presione Enter para confirmar.");
                sc.nextLine();
                confirmChosenPlanet = true;
            }

        } while (option == 0);

        System.out.println("Planeta " + planets[option - 1] + " seleccionado correctamente.");
        chosenPlanet = option - 1;

    }

    // Metodo de impresion de naves
    public static void showStarships() {
        System.out.println("\nNaves disponibles: ");
        for (int i = 0; i < starships.length; i++) {
            System.out.println((i + 1) + ". Nave: " + starships[i] + " | Velocidad: " + speed[i] + " Mkm/h | Capacidad: "
                            + maxPassengers[i] + " pasajeros.");
        }
    }

    // Metodo de seleccion de nave
    public static void chooseStarship() {
        
        showStarships();

        int option;

        do {
            System.out.print("\nIngresa el numero de una nave para elegirla: ");
            option = sc.nextInt();

            if (option < 0 || option > starships.length) {
                System.out.println("Opción inválida. Inténtelo de nuevo.");
                showStarships();
            } else {
                System.out.println("Haz elegido la nave: " + starships[option - 1]);
                sc.nextLine();
                System.out.print("Presione Enter para confirmar. ");
                sc.nextLine();
                confirmChosenStarship = true;
            }

        } while (option < 0 || option > starships.length);

        System.out.println("Nave " + starships[option - 1] + " seleccionada correctamente.");
        chosenStarship = option - 1;

        // Ingreso de pasajeros
        do {
            System.out.print("Ingresa la cantidad de pasajeros que viajaran: ");
            passengers = sc.nextInt();
            if (passengers <= 0) {
                System.out.println("Cantidad inválida. Inténtelo de nuevo.");
            } else {
                System.out.println("Feliz viaje!");
            }

        } while (passengers <= 0);
    }

    // Método de simulacion de viaje
    public static void travelSimulation() {

        // Verificacion de seleccion de planeta y nave
        if (confirmChosenPlanet == false || confirmChosenStarship == false) {
            System.err.println("Error: Debes seleccionar un planeta y una nave para iniciar el viaje.");
            return;
        }

        System.out.println("Iniciando simulación de viaje...");

        // Se incluye bloque try/catch para manejar la excepción de interrupción del hilo tal como se indico en clase
        try {

            Thread.sleep(3000); // Se simula un tiempo de espera de 3 segundos

            chooseReserves(); 

            System.out.println("\nIniciando viaje a " + planets[chosenPlanet] + " con la nave " + starships[chosenStarship]);
            System.out.println("Distancia: " + distances[chosenPlanet] + " millones de kilómetros.");
            System.out.println("Velocidad: " + speed[chosenStarship] + " Mkm/h");
            System.out.println("Pasajeros a bordo: " + passengers);
            var travelTime = travelTime(distances[chosenPlanet], speed[chosenStarship]);
            System.out.printf("El viaje durará aproximadamente %.2f días.\n", travelTime);

            Thread.sleep(2000);// Se simula un tiempo de espera de 2 segundos

            // Variables necesarias para los calculos del viaje
            var kilometersPerPercent = distances[chosenPlanet] / 100;
            var fuelPerPercent = kilometersPerPercent * 5;
            var oxigenPerPercent = kilometersPerPercent * 2;
            var timePerPercent = travelTime / 100;

            // Simulacion de viaje
            for (int i = 0; i <= 100; i++) {

                // Etapas del viaje
                if (i == 0) {
                    System.out.println("\n------Inicio del viaje------\n");
                } else if (i == 50) {
                    System.out.println("\n------Mitad del viaje------\n");
                } else if (i == 100) {
                    System.out.println("\n------Llegada al destino------\n");
                    System.out.println("Se ha recorrido el " + i + "% del trayecto.");
                    System.out.println("Llegada a " + planets[chosenPlanet] + " completada.");
                    System.out.printf("Combustible restante: %.2f galones | Oxigeno restante: %.2f litros\n\n",
                            fuelReserve, oxigenReserve);
                    break;
                }

                // Calculos de viaje
                var travelledKilometers = kilometersPerPercent * i;
                System.out.println("Se ha recorrido el " + i + "% del trayecto.");
                System.out.println("Recorriendo " + travelledKilometers + " millones de kilómetros...");

                if (rnd.nextInt(30) == rnd.nextInt(30)) {
                    randomEvents(rnd.nextInt(5) + 1);
                    Thread.sleep(3000);
                }

                System.out.printf("Tiempo para llegar a destino: %.2f dias.\n", travelTime);
                travelTime -= timePerPercent;

                System.out.printf("Combustible restante: %.2f galones | Oxigeno restante: %.2f litros\n\n", fuelReserve,
                        oxigenReserve);
                fuelReserve -= fuelPerPercent;
                oxigenReserve -= oxigenPerPercent;

                // Verificacion de combustible y oxigeno
                if (fuelReserve <= 0) {
                    System.out.println("La nave se ha quedado sin combustible, viaje fallido.");
                    break;
                } else if (oxigenReserve <= 0) {
                    System.out.println("La nave se ha quedado sin oxigeno, viaje fallido.");
                    break;
                }

                Thread.sleep(1000); // Se simula un tiempo de espera de 1 segundo

            }

        } catch (InterruptedException e) { // Manejo de la excepcion si el hilo es interrumpido
            System.err.println("El hilo fue interrumpido: " + e.getMessage());
        }
    }

    // Métodos de calculos de tiempo de viaje y recursos
    public static double travelTime(double distance, double speed) {
        var speedPerDay = speed * 24;
        return distance / speedPerDay;
    }

    public static double recomendedFuel(double distance) {
        var necessaryFuel = distance * 5;
        return necessaryFuel + (necessaryFuel * 0.2);
    }

    public static double recomendedOxigen(double distance) {
        var necessaryOxigen = distance * 2;
        return necessaryOxigen + (necessaryOxigen * 0.2);
    }

    // Método de eleccion de recursos
    public static void chooseReserves() {

        System.out.println("\n------Preparacion de viaje------\n");
        System.out.println("Para este destino se recomienda llevar: ");
        System.out.println(recomendedFuel(distances[chosenPlanet]) + " galones de combustible interplanetario.");
        System.out.println(recomendedOxigen(distances[chosenPlanet]) + " litros de oxigeno interplanetario.");
        System.out.print("¿Deseas llevar la cantidad recomendada? (S/N) : ");
        sc.nextLine();
        var option = sc.nextLine().toUpperCase();

        if (option.equals("S")) {
            fuelReserve = recomendedFuel(distances[chosenPlanet]);
            oxigenReserve = recomendedOxigen(distances[chosenPlanet]);
        } else {
            do {
                System.out.print("Ingresa la cantidad de combustible interplanetario que deseas llevar: ");
                fuelReserve = sc.nextDouble();
                System.out.print("Ingresa la cantidad de oxigeno interplanetario que deseas llevar: ");
                oxigenReserve = sc.nextDouble();

                if (fuelReserve <= 0 || oxigenReserve <= 0) {
                    System.out.println("Cantidad de recursos invalida. Intentelo de nuevo.");
                } else {
                    System.out.println("Recursos cargados exitosamente.");
                }

            } while (fuelReserve <= 0 || oxigenReserve <= 0);
        }
    }

    // Método de llamado de eventos aleatorios
    public static void randomEvents(int num) {

        switch (num) {
            case 1:
                cosmicRadiationStorm();
                break;
            case 2:
                gravitationalInterference();
                break;
            case 3:
                unknownAlienTech();
                break;
            case 4:
                systemsFailures();
                break;
            case 5:
                collision();
                break;
            default:
                System.err.println("Sin evento aleatorio");
        }

    }

    // Eventos aleatorios
    public static void cosmicRadiationStorm() {

        double oxygen = recomendedOxigen(distances[chosenPlanet]) * 0.07;
        double fuel = recomendedFuel(distances[chosenPlanet]) * 0.07;
        var startEvent = true;
        int option;

        System.out.println("\nTormenta de radiacion cosmica ");
        System.out.printf("""

                Estas pasando cerca de una tormenta de radiacion cosmica con un estallido
                inesperado de radiacion gamma que podria deshabilitar sistemas eletronicos
                y poner en peligro la tripulacion. ¿Que deseas hacer?

                1. Habilitar campo eletromagnetico que se encuentra en el exterior de la nave.
                    (Se perdera (%.2f) litros de oxigeno). -> Te quedan %.2f litros de oxigeno.

                2. Contrarestar efectos con las turbinas de la nave
                    (Se perdera (%.2f) galones de combustible). -> Te quedan %.2f galones de combustible.

                """, oxygen, oxigenReserve, fuel, fuelReserve);

        do {

            System.out.print("Ingresa el numero de la accion que deseas realizar: ");
            option = sc.nextInt();

            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Has habilitado el campo electromagnetico de la nave.");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f litros de oxigeno.", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Has utilizado las turbinas a su maximo rendimiento.");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f galones de combustible.", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opcion inválida. Intentelo de nuevo.");
                    break;
            }

        } while (startEvent);

    }

    public static void gravitationalInterference() {

        double oxygen = recomendedOxigen(distances[chosenPlanet]) * 0.17;
        double fuel = recomendedFuel(distances[chosenPlanet]) * 0.17;
        var startEvent = true;
        int option;

        System.out.println("\nInterferencia gravitacional ");
        System.out.printf("""

                La nave se esta acercando a un area donde hay un agujero negro, esto podria
                alterar el curso debido a su fuerte influencia gravitacional, dañando asi los
                sistemas de navegacion. ¿Que deseas hacer?:

                1. Reguasdarse en la camara de seguridad para evitar afecciones por la intensidad gravitacional.
                    (Se perdera (%.2f) litros de oxigeno). -> Te quedan %.2f litros de oxigeno.

                2. Activar propulsores de emergencia
                    (Se perdera (%.2f) galones de combustible). -> Te quedan %.2f galones de combustible.

                """, oxygen, oxigenReserve, fuel, fuelReserve);

        do {
            System.out.println("Ingresa el numero de la accion que deseas realizar: ");
            option = sc.nextInt();

            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Has ingresado a la camara de seguridad durante la emergencia.");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f litros de oxigeno.", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Se activaron los propulsores durante la emergencia.");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f galones de combustible.", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opcion invalida. Intentelo de nuevo.");
                    break;
            }

        } while (startEvent);

    }

    public static void unknownAlienTech() {

        double oxygen = recomendedOxigen(distances[chosenPlanet]) * 0.04;
        double fuel = recomendedFuel(distances[chosenPlanet]) * 0.04;
        var startEvent = true;
        int option;

        System.out.println("\nEncuentro con tecnologia alienígena desconocida");
        System.out.printf("""

                La nave ha detectado una señal de estructuras artificiales desconocidas
                en el camino y el sistema alerta una amenaza grande. ¿Que deseas hacer?:

                1. Prestar guardia en cada una de las naves, incluyendo las que estan inactivas.
                    (Se perdera (%.2f) litros de oxigeno). -> Te quedan %.2f litros de oxigeno.

                2. Activar sistemas avanzados de defensa durante el trayecto.
                    (Se perdera (%.2f) galones de combustible). -> Te quedan %.2f galones de combustible.

                """, oxygen, oxigenReserve, fuel, fuelReserve);

        do {
            System.out.println("Ingresa el numero de la accion que deseas realizar: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Se esta vigilando todas las areas de las naves.");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f litros de oxigeno.", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Se han activado los sistemas avanzados de defensa de la nave.");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f galones de combustible.", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opcion invalida. Intentelo de nuevo.");
                    break;
            }

        } while (startEvent);

    }

    public static void systemsFailures() {

        double oxygen = recomendedOxigen(distances[chosenPlanet]) * 0.09;
        double fuel = recomendedFuel(distances[chosenPlanet]) * 0.09;
        var startEvent = true;
        int option;

        System.out.println("\nFallos en los sistemas de soporte vital");
        System.out.printf("""

                Se ha detectado un mal funcionamiento en sistemas criticos como el
                reclicado de aire, administracion de combustible y otras fallas
                mas. ¿Que deseas hacer?:

                1. Desactivar los mecanismos y activar los mecanismos de respaldo.
                    (Se perdera (%.2f) litros de oxigeno).-> Te quedan %.2f litros de oxigeno.

                2. Utilizar uno de los modulos inteligentes de la nave para suplir esos sistemas.
                    (Se perdera (%.2f) galones de combustible). -> Te quedan %.2f galones de combustible.

                """, oxygen, oxigenReserve, fuel, fuelReserve);

        do {
            System.out.println("Ingresa el numero de la accion que deseas realizar: ");
            option = sc.nextInt();

            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Se activaron mecanismos de respaldo.");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f litros de oxigeno.", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Se han activado un modulo inteligente de la nave.");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f galones de combustible.", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opcion invalida. Intentelo de nuevo.");
                    break;
            }

        } while (startEvent);
    }

    public static void collision() {

        double oxygen = recomendedOxigen(distances[chosenPlanet]) * 0.2;
        double fuel = recomendedFuel(distances[chosenPlanet]) * 0.2;
        var startEvent = true;
        int option;

        System.out.println("\nColision con meteoritos y/o basura espacial");
        System.out.printf(
                """

                        A pesar de los escudos, la nave ha recibido un impacto con un objeto
                        a alta velocidad, lo cual ha perforado el casco y se requieren reparaciones inmediatas. ¿Que deseas hacer?:

                        1. Detener el trayecto, revisar el impacto y repararlo.
                            (Se perdera (%.2f) litros de oxigeno). -> Te quedan %.2f litros de oxigeno.

                        2. Se desprenderá módulo afectado de la nave, se requiere utilizar combustible para hacerlo.
                            (Se perdera (%.2f) galones de combustible). -> Te quedan %.2f galones de combustible.

                        """,
                oxygen, oxigenReserve, fuel, fuelReserve);

        do {
            System.out.println("Ingresa el numero de la accion que deseas realizar: ");
            option = sc.nextInt();

            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Se realizo la reparación del area afectada.");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f litros de oxigeno.", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Se ha retirado modulo afectado.");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f galones de combustible.", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opcion invalida. Intentelo de nuevo.");
                    break;
            }

        } while (startEvent);

    }

}
