package company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TraverseFile {
    String file="clientList.txt";
    BuildRecipient buildRecipient=new BuildRecipient();

    public TraverseFile(ArrayList<Recipient> recipientList) {
        String ln = "";
        try {

            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            while (true) {
                try {
                    ln = bufferedReader.readLine();

                } catch (IOException e) {
                    e.printStackTrace();

                }

                if (ln == null)
                    break;

                String[] finalizedLine = ln.split("[:,]");
                recipientList.add(buildRecipient.make(finalizedLine));


            }
            try {
                bufferedReader.close();
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("");

        }

    }
}
