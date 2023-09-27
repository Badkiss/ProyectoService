import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;

public class Redireccion {
    public static void main(String[] args) {
        ProcessBuilder pb=new ProcessBuilder(new String[]{
                "ls","-la", "/home/agrueiror"
        });
        //otra forma
        String pwd="/home/agrueiror";
//        pb.directory(new File(pwd));
//        pb.redirectOutput(new File("ls.txt"));
        //concatenar con el fichero
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("ls.txt")));
        try{
          Process pbs= pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
