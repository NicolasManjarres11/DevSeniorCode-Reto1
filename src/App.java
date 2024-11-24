
import java.util.Random;
import java.util.Scanner;

public class App {

    //Clases a utilizar
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    //Planetas, detalles y descripción
    public static String[] planets = {"Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};
    public static double[] distances = {91.0, 41.0, 78.0, 628.0, 1275.0, 2723.0, 4351.0};
    public static String[] descriptionPlanet = {
        "El planeta más cercano al Sol, un mundo abrasador durante el día y helado por la noche.",
        "Una joya envuelta en nubes tóxicas, con un calor infernal y volcanes activos.",
        "El planeta rojo, hogar de enormes cañones y montañas; el próximo objetivo para la humanidad.",
        "El gigante gaseoso con tormentas eternas, incluido el icónico Gran Mancha Roja.",
        "Majestuoso con sus anillos helados, un espectáculo visual en el cosmos.",
        "Un mundo azul verdoso que gira de lado, envuelto en misterio y frío extremo.",
        "El reino del viento y las tormentas más rápidas, con un hermoso tono azul profundo."
    };

    //Naves espaciales, detalles y descripción
    public static String[] starships = {"Astra Voyager", "Pioneer Horizon", "Stellar Odyssey", "Cosmos Endeavor",};
    public static double[] speed = {4.0, 5.0, 3.0, 6.0}; //Velocidades en millones de km/h

    public static String[] descriptionStarship = {}; //Pendiente por agregar descripción correspondiente

    //Variables a utilizar
    public static int choosePlanet;
    public static int chooseStarship;
    public static double fuelReserve;
    public static double oxigenReserve;

    //Variables lógicas
    static boolean startSimulation = true;

    public static void main(String[] args) {

        do {
            menu();
        } while (startSimulation);

        sc.close();

    }

    //Menú de opciones
    public static void menu() {

        int option;

        System.out.println("\nSimulador de Viaje interplanetario");
        System.out.println("************************************");
        System.out.println("\nSelecciona una de las siguientes opciones");
        System.out.println("\n1. Seleccionar un planeta de destino.");
        System.out.println("2. Seleccionar una nave espacial.");
        System.out.println("3. Iniciar la simulación de viaje");
        System.out.println("4. Salir del programa.");
        option = sc.nextInt();
        System.out.println("");

        switch (option) {
            case 1:
                choosePlanet();  //Sujeto a cambios para agregar metodos de planetas, por ejemplo, "seleccionarPlaneta()""
                break;
            case 2:
                showStarships(); //Sujeto a cambios para agregar metodos de naves, por ejemplo, "seleccionarNave()""
                break;
            case 3:
                travelSimulation();
                break;
            case 4:
                System.out.println("Saliendo del programa...");
                startSimulation = false;
                break;
            default:
                System.err.println("Opción inválida. Inténtelo de nuevo");
        }

    }

    //Print y métodos de planetas
    public static void showPlanets() {
        System.out.println("Planetas disponibles: ");
        for (int i = 0; i < planets.length; i++) {
            System.out.println((i + 1) + ". " + planets[i] + " | Distancia: " + distances[i] + " millones de kilómetros.");
        }
    }

    public static void choosePlanet() {

        showPlanets();

        int option;

        do {
            System.out.println("Ingresa el número del planeta que deseas elegir: ");
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
            }

        } while (option == 0);

        System.out.println("Planeta " + planets[option - 1] + " seleccionado correctamente.");
        choosePlanet = option - 1;

    }

    //Print y métodos de naves
    public static void showStarships() {
        System.out.println("\nNaves disponibles: ");
        for (int i = 0; i < starships.length; i++) {
            System.out.println((i + 1) + ". Nave: " + starships[i] + " | Velocidad: " + speed[i] + " Mkm/h");
        }
    }

    public static void chooseStarship() {
        showStarships();

        int option;

        do {
            System.out.print("\nIngresa el numero de una nave para elegirla: ");
            option = sc.nextInt();
            System.out.println("Haz elegido la nave: " + starships[option - 1]);
            sc.nextLine();
            System.out.print("Presione Enter para confirmar. ");
            sc.nextLine();
        } while (option < 0 || option > starships.length);

        System.out.println("Nave " + starships[option - 1] + " seleccionada correctamente.");
        chooseStarship = option - 1;
    }

    //Duración del viaje
    public static void travelDuration(double distance, double speed) {

    }

    //Método de simulación de viaje
    public static void travelSimulation() {

    }

    //Método de llamado de eventos aleatorios
    public static void randomEvents(int num) {

        //Se puede llamar al método co este parámetro, para que de un numero
        // random de 1 a 5, de la siguiente manera
        //randomEvents(rnd.nextInt(5)+1);
        switch (num) {
            case 1:
                cosmicRadiationStorm(fuelReserve, oxigenReserve);
                break;
            case 2:
                gravitationalInterference(fuelReserve, oxigenReserve);
                break;
            case 3:
                unknownAlienTech(fuelReserve, oxigenReserve);
                break;
            case 4:
                systemsFailures(fuelReserve, oxigenReserve);
                break;
            case 5:
                collision(fuelReserve, oxigenReserve);
                break;
            default:
                System.err.println("Sin evento aleatorio");
        }

    }

    // Eventos aleatorios
    public static void cosmicRadiationStorm(double fuelReserve, double oxigenReserve) {

        double oxygen = 4000;
        double fuel = 4000;
        var startEvent = true;
        int option;

        System.out.println("Tormenta de radiación cósmica ");
        System.out.printf("""
    
                    Estás pasando cerca de una tormenta de radiación cósmica con un estallido
                    inesperado de radiación gamma que podría deshabilitar sistemas eletrónicos
                    y poner en peligro la tripulación. ¿Qué deseas hacer?
    
                    1. Habilitar campo eletromagnético que se encuentra en el exterior de la nave.
                       (Se perderá (%.2f) litros de oxigeno).
    
                    2. Contrarestar efectos con las turbinas de la nave
                        (Se perderá (%.2f) litros de combustible).

                    Ingresa el número de la acción que deseas realizar:
                    """, oxygen, fuel);

        do {

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Has habilitado el campo electromagnético de la nave.");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f de oxigeno", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Has utilizado las turbinas a su máximo rendimiento.");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f de oxigeno", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo");
                    break;
            }

        } while (startEvent);

    }

    public static void gravitationalInterference(double fuelReserve, double oxigenReserve) {

        double oxygen = 6750;
        double fuel = 8400;
        var startEvent = true;
        int option;

        System.out.println("Interferencia gravitacional ");
        System.out.printf("""
    
                    La nave se está acercando a un área donde hay un agujero negro, esto podría 
                    alterar el curso debido a su fuerte influencia gravitacional, dañando así los
                    sistemas de navegación. ¿Qué deseas hacer?:
    
                    1. Reguasdarse en la cámara de seguridad para evitar afecciones por la intensidad gravitacional.
                        (Se perderá (%.2f) litros de oxigeno).
    
                    2. Activar propulsores de emergencia
                        (Se perderá (%.2f) litros de combustible).

                    Ingresa el número de la acción que deseas realizar:
                    """, oxygen, fuel);

        do {

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Has ingresado a la cámara de seguridad durante la emergencia.");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f de oxigeno", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Se activaron los propulsores durante la emergencia.");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f de oxigeno", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo");
                    break;
            }

        } while (startEvent);

    }

    public static void unknownAlienTech(double fuelReserve, double oxigenReserve) {

        double oxygen = 4200;
        double fuel = 5400;
        var startEvent = true;
        int option;

        System.out.println("Encuentro con tecnología alienígena desconocida");
        System.out.printf("""
    
                    La nave ha detectado una señal de estructuras artificiales desconocidas
                    en el camino y el sistema alerta una amenaza grande. ¿Qué deseas hacer?:
    
                    1. Prestar guardia en cada una de las naves, incluyendo las que están inactivas.
                        (Se perderá (%.2f) litros de oxigeno).
    
                    2. Activar sistemas avanzados de defensa durante el trayecto.
                        (Se perderá (%.2f) litros de combustible).

                    Ingresa el número de la acción que deseas realizar:
                    """, oxygen, fuel);

        do {

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Se está vigilando todas las áreas de las naves");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f de oxigeno", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Se han activado los sistemas avanzados de defensa de la nave");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f de oxigeno", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo");
                    break;
            }

        } while (startEvent);

    }

    public static void systemsFailures(double fuelReserve, double oxigenReserve) {

        double oxygen = 10000;
        double fuel = 10000;
        var startEvent = true;
        int option;

        System.out.println("Fallos en los sistemas de soporte vital");
        System.out.printf("""
    
                    Se ha detectado un mal funcionamiento en sistemas críticos como el
                    reclicado de aire, administración de combustible y otras fallas
                    más. ¿Qué deseas hacer?:
    
                    1. Desactivar los mecanismos y activar los mecanismos de respaldo.
                        (Se perderá (%.2f) litros de oxigeno).
    
                    2. Utilizar uno de los módulos inteligentes de la nave para suplir esos sistemas.
                        (Se perderá (%.2f) litros de combustible).

                    Ingresa el número de la acción que deseas realizar:
                    """, oxygen, fuel);

        do {

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Se activaron mecanismos de respaldos");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f de oxigeno", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Se han activado un módulo inteligente de la nave");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f de oxigeno", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo");
                    break;
            }

        } while (startEvent);
    }

    public static void collision(double fuelReserve, double oxigenReserve) {

        double oxygen = 28000;
        double fuel = 28000;
        var startEvent = true;
        int option;

        System.out.println("Colisión con meteoritos y/o basura espacial");
        System.out.printf("""
    
                    A pesar de los escudos, la nave ha recibido un impacto con un objeto
                    a alta velocidad, lo cual ha perforado el casco y se requieren reparaciones inmediatas. ¿Qué deseas hacer?:
    
                    1. Detener el trayecto, revisar el impacto y repararlo.
                        (Se perderá (%.2f) litros de oxigeno).
    
                    2. Se desprenderá módulo afectado de la nave, se requiere utilizar combustible para hacerlo.
                        (Se perderá (%.2f) litros de combustible).

                    Ingresa el número de la acción que deseas realizar:
                    """, oxygen, fuel);

        do {

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Se realizó la reparación del área afectada.");
                    oxigenReserve -= oxygen;
                    System.out.printf("Te queda %.2f de oxigeno", oxigenReserve);
                    startEvent = false;
                    break;
                case 2:
                    System.out.println("Se ha retirado módulo afectado");
                    fuelReserve -= fuel;
                    System.out.printf("Te queda %.2f de oxigeno", fuelReserve);
                    startEvent = false;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo");
                    break;
            }

        } while (startEvent);

    }

}
