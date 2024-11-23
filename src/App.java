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
        
    }; //Pendiente por agregar descripción correspondiente

    //Naves espaciales, detalles y descripción

    public static String[] starships = {"Nave 1","Nave 2","Nave 3","Nave 4",}; //Pendiente por definir nombres
    public static double[] speed = {4.0, 17.0, 35.0 ,55.0}; //Velocidades en millones de km/h (Sujeto a cambios)

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
                sc.nextLine();
                System.out.println("Presione Enter para confirmar.");
                sc.nextLine();
            }

            
            
        } while (option == 0);

        System.out.println("Planeta "+planets[option-1]+" seleccionado correctamente.");
        choosePlanet = option-1;

    }

    //Print y métodos de naves

    public static void showStarships(){
        
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
