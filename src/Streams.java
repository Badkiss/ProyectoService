import java.io.*;
import java.util.Arrays;

public class Streams {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder(new String[]{
                "ls","-la"
        });


        try {
            Process p = pb.start();
            try (InputStream is = p.getInputStream(); InputStreamReader isr = new
                    InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
                int codRet = p.waitFor();
                System.out.println("La ejecución de" + Arrays.toString(args) + "devuelve"
                +codRet + ""+(codRet == 0 ? "(ejecución correcta)": "(ERROR)"));
                System.out.println("Salida del proceso");
                System.out.println("------------------");
                String linea = null;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
                System.out.println("------------------");
            }
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("-------------------- - ");
            e.printStackTrace();
            System.err.println("-------------------- - ");
            System.exit(2);
        } catch (InterruptedException ex) {
            System.err.println("Proceso interrumpido");
            System.exit(3);
        }
    }
}

