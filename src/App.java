import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner lector = new Scanner(System.in);
        int option=0;
        do{
            System.out.println("---------------------------------");
            System.out.println();
            System.out.println("    Bienvenido a Teoría de Colas    ");
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
                    System.out.println("---------------------------------");
                    System.out.println();
                    System.out.println("    Modelo M/M/1/k"   );
                    System.out.println();
                    System.out.println("Ingrese la tasa de llegada (λ): ");
                    double lambda = lector.nextDouble();
                    System.out.println("Ingrese la tasa de servicio (μ): ");
                    double miu = lector.nextDouble();
                    System.out.println("Ingrese la capacidad del sistema (k): ");
                    int k = lector.nextInt();
                    System.out.println();
                    double p=lambda/miu;
                    System.out.println("Ocupación del sistema (ρ): "+p);
                    double Po = (1 - p) / (1 - Math.pow(p, k + 1));
                    System.out.println("Probabilidad de que no haya clientes en el sistema (Po): "+Po);
                    double Pk = (Math.pow(p,k)*Po);
                    System.out.println("Probabilidad de que el sistema esté lleno (Pk): "+Pk);
                    double λe = lambda * (1 - Pk);
                    System.out.println("Tasa efectiva de llegada (λe): "+λe);
                    double L = (p * (1 - (k + 1) * Math.pow(p, k) + k * Math.pow(p, k + 1))) / ((1 - p) * (1 - Math.pow(p, k + 1)));
                    System.out.println("Número promedio de clientes en el sistema (L): "+L+" clientes");
                    double W = L / (lambda * (1 - Po));
                    System.out.println("Tiempo promedio en el sistema (W): "+W+ " hrs"+" o "+ W*60+" minutos");
                    

                } 
                break;
                case 3:{
                    System.out.println("---------------------------------");
                    System.out.println();
                    System.out.println("    Modelo M/M/c"   );
                    System.out.println();
                    System.out.println("Ingrese la tasa de llegada (λ): ");
                    double lambda = lector.nextDouble();
                    System.out.println("Ingrese la tasa de servicio (μ): ");
                    double miu = lector.nextDouble();
                    System.out.println("Ingrese el número de servidores (c): ");
                    int c = lector.nextInt();
                    System.out.println();
                    double p=lambda/(c*miu);
                    System.out.println("Ocupación del sistema (ρ): "+p);
                    double a = lambda / miu;
                    double sum=0;
                    double Po= 0;
                    for(int n=0; n<c; n++){
                        sum += (Math.pow(a, n)) / factorial(n);
                    }
                    Po = 1 / (sum + (Math.pow(a, c) / (factorial(c) * (1 - (a / c)))));
                    System.out.println("Probabilidad de que no haya clientes en el sistema (Po): "+Po);
                    double Pespera = (Math.pow(a, c) / (factorial(c)*(1 - p))*(Po));
                    System.out.println("Probabilidad de espera (Pespera): "+Pespera);
                    double Lq = (Pespera * p) / (1 - p);
                    System.out.println("Número promedio de clientes en la cola (Lq): "+Lq+" clientes");
                    double L = Lq + a;
                    System.out.println("Número promedio de clientes en el sistema (L): "+L+" clientes");
                    double Wq = Lq / lambda;
                    System.out.println("Tiempo promedio en la cola (Wq): "+Wq+ " hrs"+" o "+ Wq*60+" minutos");
                    double W = Wq + (1/miu);
                    System.out.println("Tiempo promedio en el sistema (W): "+W+ " hrs"+" o "+ W*60+" minutos");
                }
                break;
 
            }

        }while(option != 4);
        lector.close();



    }

   public static double factorial(double number){
    double fact = 1;
    for(int i=1; i<=number; i++){
        fact = fact * i;
    }
    return fact;
   }

}
