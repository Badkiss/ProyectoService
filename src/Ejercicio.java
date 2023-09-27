import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder(args);

            if (Files.exists(Path.of(args[2]))&& Files.isDirectory(Path.of(args[2]))) {
                pb.redirectOutput(new File("ls.txt"));
                try {
                    Process p=pb.start();
                    String linea="";
                    int cont=1;
                    try(InputStream is=p.getInputStream(); InputStreamReader isr=new InputStreamReader(is);BufferedReader br=new BufferedReader(isr)) {
                    while ((linea=br.readLine())!=null){
                        System.out.println(cont+" "+linea);
                        cont++;
                    }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                System.out.println("no existe el directiorio"+" "+ args[2]);
            }
        }
    }