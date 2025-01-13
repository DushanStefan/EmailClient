package company;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class EmailFinding {
    public void printPastEmails(String givenDate2, ArrayList<Email> emailList){
        for (Email email : emailList){
            if(email.getDate().equals(givenDate2)){
                System.out.println("Email: "+email.getEmailAddress());
                System.out.println("Subject: "+email.getSubject());
                System.out.println();
            }

        }
    }
}
