import java.util.Random;
import java.util.Scanner;

public class App {
    
    public static String[] planets = {"Mercurio", "Venus", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};
    public static double[] distances = {91.0, 41.0, 78.0, 628.0, 1275.0, 2723.0, 4351.0};
    
    public static String[] starships = {"Astra Voyager","Pioneer Horizon","Stellar Odyssey","Cosmos Endeavor",};
    public static double[] speed = {4.0, 17.0, 35.0 ,55.0}; //Velocidades en millones de km/h

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) throws Exception {
        chooseStarship();
    }

    
    public static void showStarships(){
        System.out.println("Naves disponibles: ");
        for (int i = 0; i < starships.length; i++) {
            System.out.println((i+1) + ". Nave: " + starships[i] + " | Velocidad: " + speed[i] + " Mkm/h");
        }
    }

    public static int chooseStarship(){
        showStarships();

        int option;

        do {
            System.out.print("\nIngresa el numero de una nave para elegirla: ");
            option = sc.nextInt();
            System.out.println("Haz elegido la nave: " + starships[option-1]);
            sc.nextLine();
            System.out.print("Presione Enter para confirmar. ");
            sc.nextLine();
        } while (option < 0 || option > starships.length);

        System.out.println("Nave " + starships[option-1] + " seleccionada correctamente.");
        return option-1;
    }    
}
