import java.io.IOException;
import java.io.File;
import java.io.IOException;
public class RedigirEntrada {
    public static void main(String[] args) {


        ProcessBuilder pb = new ProcessBuilder(new String[]{
                "grep", "localhost"
        });
        //otra forma
        String pwd = "/home/agrueiror";
//        pb.directory(new File(pwd));
        pb.redirectInput(new File("/etc/hosts"));
        pb.redirectOutput(new File("salida.txt"));
        pb.redirectError(new File("error.log"));
        try {
            Process pbs = pb.start();
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }


    }
}