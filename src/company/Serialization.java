package company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization {
    public void serialize(ArrayList<Email> emailList){
        try{
            FileOutputStream file = new FileOutputStream("emailDetails.ser");
            ObjectOutputStream out=new ObjectOutputStream(file);
            for (Email email:emailList)
                out.writeObject(email);
            out.close();
            file.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
