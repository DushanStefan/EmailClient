package company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Deserialization {
    public void deserialize(ArrayList<Email> emailList) {
        try {
            FileInputStream file = new FileInputStream("emailDetails.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            while (true) {
                try {
                    Email email = (Email) in.readObject();
                    emailList.add(email);


                } catch (IOException e) {
                    break;
                }
            }
            in.close();
            file.close();
        }
        catch (FileNotFoundException f){
                System.out.println("");
            }

        catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}