import java.util.Random;
import java.util.Scanner;

public class App {

    // Clases a utilizar

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    // Planetas, detalles y descripción

    public static String[] planets = { "Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno" };
    public static double[] distances = { 91.0, 41.0, 78.0, 628.0, 1275.0, 2723.0, 4351.0 };
    public static String[] descriptionPlanet = {}; // Pendiente por agregar descripción correspondiente

    // Naves espaciales, detalles y descripción

    public static String[] starships = { "Astra Voyager", "Pioneer Horizon", "Stellar Odyssey", "Cosmos Endeavor", };
    public static double[] speed = { 4.0, 5.0, 3.0, 6.0 }; // Velocidades en millones de km/h
    public static String[] descriptionStarship = {}; // Pendiente por agregar descripción correspondiente

    // Variables a utilizar

    public static int choosePlanet;
    public static int chooseStarship;
    public static double fuelReserve;
    public static double oxigenReserve;

    public static void main(String[] args) {
        menu();
        sc.close();
    }

    // Menú de opciones

    public static void menu() {

        int option;

        do {
            System.out.println("Simulador de Viaje interplanetario");
            System.out.println("************************************");
            System.out.println("\nSelecciona una de las siguientes opciones");
            System.out.println("\n1. Seleccionar un planeta de destino.");
            System.out.println("2. Seleccionar una nave espacial.");
            System.out.println("3. Iniciar la simulación de viaje");
            System.out.println("4. Salir del programa.");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    showPlanets(); // Sujeto a cambios para agregar metodos de planetas, por ejemplo,
                                   // "seleccionarPlaneta()""
                    break;
                case 2:
                    chooseStarship(); // Sujeto a cambios para agregar metodos de naves, por ejemplo,
                                      // "seleccionarNave()""
                    break;
                case 3:
                    travelSimulation();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.err.println("Opción inválida. Inténtelo de nuevo");
            }
        } while (option != 4);

    }

    // Print y métodos de planetas

    public static void showPlanets() {

    }

    // Print y métodos de naves

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

    // Duración del viaje

    public static void travelDuration(double distance, double speed) {

    }

    // Método de simulación de viaje

    public static void travelSimulation() {

    }

    // Método de eventos aleatorios

    public static void randomEvents() {

    }

}
