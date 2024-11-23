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

    public static String[] starships = {"Astra Voyager","Pioneer Horizon","Stellar Odyssey","Cosmos Endeavor",}; 
    public static double[] speed = {4.0, 5.0, 3.0 ,6.0}; //Velocidades en millones de km/h

    public static String[] descriptionStarship = {}; //Pendiente por agregar descripción correspondiente

    //Variables a utilizar

    public static int choosePlanet;
    public static int chooseStarship;
    public static double fuelReserve;
    public static double oxigenReserve;

    //Variables lógicas

    static boolean startSimulation = true;
    
    public static void main(String[] args){


        do { 
            menu(); 
        } while (startSimulation);

        sc.close();

    }


    //Menú de opciones

    public static void menu(){

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
            System.out.println((i+1)+". "+planets[i] + " | Distancia: "+distances[i]+" millones de kilómetros.");
        }
    }

    public static void choosePlanet(){

        showPlanets();

        int option;


        do { 
            System.out.println("Ingresa el número del planeta que deseas elegir: ");
            option = sc.nextInt();

            if(!(option <= planets.length)){
                option = 0;
                System.out.println("Opción inválida. inténtelo de nuevo.");
                System.out.println();
                showPlanets();
                
            } else{
                
                System.out.println("\nHaz seleccionado el planeta: "+planets[option-1]);
                System.out.println(descriptionPlanet[option-1]);
                sc.nextLine();
                System.out.println("Presione Enter para confirmar.");
                sc.nextLine();
            }

            
            
        } while (option == 0);

        System.out.println("Planeta "+planets[option-1]+" seleccionado correctamente.");
        choosePlanet = option-1;

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

    public static void travelDuration(double distance, double speed){

        
    }

    //Método de simulación de viaje

    public static void travelSimulation(){
        
    }

    //Método de eventos aleatorios

    public static void randomEvents(){

    }

    


}
