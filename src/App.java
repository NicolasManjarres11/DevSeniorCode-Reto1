import java.util.Random;
import java.util.Scanner;

public class App {

    //Clases a utilizar

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    //Planetas, detalles y descripción
    
    public static String[] planets = {"Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};
    public static double[] distances = {91.0, 41.0, 78.0, 628.0, 1275.0, 2723.0, 4351.0};
    public static String[] descriptionPlanet = {}; //Pendiente por agregar descripción correspondiente

    //Naves espaciales, detalles y descripción

    public static String[] starships = {"Nave 1","Nave 2","Nave 3","Nave 4",}; //Pendiente por definir nombres
    public static double[] speed = {4.0, 17.0, 35.0 ,55.0}; //Velocidades en millones de km/h (Sujeto a cambios)

    public static String[] descriptionStarship = {}; //Pendiente por agregar descripción correspondiente

    //Variables a utilizar

    public static int choosePlanet;
    public static int chooseStarship;
    public static double fuelReserve;
    public static double oxigenReserve;


    
    public static void main(String[] args){

        int option;

        do { 
            showMenu();
            option = sc.nextInt();
            
            switch (option) {
                case 1:
                    showPlanets();  //Sujeto a cambios para agregar metodos de planetas, por ejemplo, "seleccionarPlaneta()""
                    break;
                case 2:
                    showStarships(); //Sujeto a cambios para agregar metodos de naves, por ejemplo, "seleccionarNave()""
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

        sc.close();

    }


    //Menú de opciones

    public static void showMenu(){

        System.out.println("Simulador de Viaje interplanetario");
        System.out.println("************************************");
        System.out.println("\nSelecciona una de las siguientes opciones");
        System.out.println("\n1. Seleccionar un planeta de destino.");
        System.out.println("2. Seleccionar una nave espacial.");
        System.out.println("3. Iniciar la simulación de viaje");
        System.out.println("4. Salir del programa.");

    }

    //Print y métodos de planetas

    public static void showPlanets() {
        
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
