package MCM;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class BaseCheck {

    public static void main(String[] args) {
        try{
            Path path = Paths.get("F:\\Python\\DynamicProgramming\\MCM\\encode.txt");
            byte[] array = Files.readAllBytes(path);
            byte[] decodeXls = Base64.getDecoder().decode(array);
            try(OutputStream stream = new FileOutputStream("F:\\Python\\DynamicProgramming\\MCM\\output.xlsx")){
                stream.write(decodeXls);
            }
            System.out.println("Success");
            }
            catch(Exception e){
                System.out.print(e);
            }
    }

}
