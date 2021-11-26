import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    //La constante de tiempo
    public static int max_Tiempo = 1;

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();

        /*
        if(args.length <= 0) {
            //Pregunto si hay algún argumento
            System.out.println("Debemos indicar algun argumento");
        }
        */

        try{
            Process p = pb.start();
            if (!p.waitFor(max_Tiempo, TimeUnit.NANOSECONDS)){
                p.destroy();
                System.out.printf("Este comando ha sido interrumpido en %d",max_Tiempo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            System.err.println("Proceso interrumpido");
        }
    }
}
