import java.util.Arrays;
import java.io.IOException;

public class Programa1 {
    public static void main(String[] args){
        if(args.length <= 0) {
            //Pregunto si hay algún argumento
            System.out.println("Debemos indicar algun argumento");
            System.exit(1);
        }

        //Hay algún comando.
        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();
        try{
            Process p = pb.start();
            int codigoReturn = p.waitFor();
            //Devolvemos el resultado
            System.out.println("La ejecucion de "+ Arrays.toString(args)+" devuelve "+codigoReturn);
        } catch (IOException  e) {
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e){
            System.err.println("Proceso interrumpido");
            System.exit(3);
        }
    }
}