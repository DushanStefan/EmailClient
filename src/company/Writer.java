package company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public void writing(String details){
        try{
            FileWriter writerr = new FileWriter("clientList.txt",true);
            BufferedWriter bufferedWriter= new BufferedWriter(writerr);
            bufferedWriter.write(details);
            bufferedWriter.newLine();
            bufferedWriter.close();
            writerr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
}}
