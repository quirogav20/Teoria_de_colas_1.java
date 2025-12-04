import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner lector = new Scanner(System.in);
        int option=0;
        do{
            System.out.println("Bienvenido a Teoría de Colas: ");
            System.out.println("------Menú------" );
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Modelo M/M/1");
            System.out.println("2. Modelo M/M/3");
            System.out.println("3. Modelo M/M/c");
            System.out.println("4. Salir");

            option = lector.nextInt();
            switch(option){
                case 1:{

                }
                break;
                case 2:{

                } 
                break;
                case 3:{

                }
                break;
                case 4:{

                }
                break;

                default:
                System.out.println("Opción no invalida");
            }

        }while(option != 4);
        lector.close();



    }
}
