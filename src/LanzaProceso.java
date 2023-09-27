import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
public class LanzaProceso {
    public static void main(String[] args) {
        String[]comand=new String[]{"./bucle.sh"};
        ProcessBuilder pb = new ProcessBuilder(comand);

        Map<String,String> environment=pb.environment();
        for (String key: environment.keySet()){
            System.out.println(key+"->"+environment.get(key));
        }
        pb.inheritIO();
        try {
            Process p = pb.start();
            for (int i=1;i<=4;i++){
                Thread.sleep(3000);
                if (p.isAlive()){
                    System.out.println("Todo va bien");
                }else{
                    System.out.println("Todo va mal");
                }
            }

            int codRet = p.waitFor();
            System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + codRet + " " + (codRet == 0 ? "(ejecución correcta)": "(ERROR)"));
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            System.exit(3);
        }
    }
}