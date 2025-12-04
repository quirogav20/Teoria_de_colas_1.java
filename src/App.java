import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner lector = new Scanner(System.in);
        int option=0;
        do{
            System.out.println("---------------------------------");
            System.out.println();
            System.out.println("Bienvenido a Teoría de Colas: ");
            System.out.println("------Menú------" );
            System.out.println("Selecciona una opción: ");
            System.out.println("1. Modelo M/M/1");
            System.out.println("2. Modelo M/M/1/k");
            System.out.println("3. Modelo M/M/c");
            System.out.println("4. Salir");

            option = lector.nextInt();
            switch(option){
                case 1:{
                    System.out.println("---------------------------------");
                    System.out.println();
                    System.out.println("    Modelo M/M/1"   );
                    System.out.println();
                    System.out.println();
                    System.out.println("Ingrese la tasa de llegada (λ): ");
                    double lambda = lector.nextDouble();
                    System.out.println("Ingrese la tasa de servicio (μ): ");
                    double miu = lector.nextDouble();
                    System.out.println();
                    double p=lambda/miu;                
                    System.out.println("Ocupación del sistema (ρ): "+p);
                    double Lq = (Math.pow(lambda, 2)) / (miu * (miu - lambda));
                    System.out.println("Número promedio de clientes en el cola (Lq): "+Lq+" clientes");
                    double L = lambda/(miu - lambda);
                    System.out.println("Número promedio de clientes en el sistema (L): "+L+" clientes");
                    double Wq = Lq / lambda;
                    System.out.println("Tiempo promedio en el sistema (Wq): "+Wq+ " hrs"+" o "+ Wq*60+" minutos");
                    double W = Wq + (1/miu);
                    System.out.println("Tiempo promedio en la cola (W): "+W+ " hrs"+" o "+ W*60+" minutos");
                }
                break;
                case 2:{

                } 
                break;
                case 3:{

                }
                break;


                
                default:
                System.out.println("Opción no invalida");
            }

        }while(option != 4);
        lector.close();



    }
}
