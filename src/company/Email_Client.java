package company;
// 200163E
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;



public class Email_Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application");




        Serialization serialization=new Serialization();


        ArrayList<Recipient> recipientList = new ArrayList<>(); // to maintain objects of recipients
        ArrayList<Email> emailList = new ArrayList<>(); // to maintain the objects of emails those we sent

        Deserialization deserialization =new Deserialization();

        //if there exist a .SER file ,deserialize this file and add its objects in to emailList
        deserialization.deserialize(emailList);


        TraverseFile traverseFile=new TraverseFile(recipientList); // filling recipientList with objects in File



        LocalDate Date= LocalDate.now();
        DateTimeFormatter DTformatter= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String currentDate =Date.format(DTformatter);

        System.out.println("wait,checking and sending birthday wishes");

        BirthdayFinding birthdayFinding=new BirthdayFinding();
        birthdayFinding.sendBirthdayWish(currentDate,recipientList,emailList); //send today birthday wishes

        System.out.println("Today Birthday wishes were sent,now you can select one option");

        int option = scanner.nextInt();
        String trash = scanner.nextLine();



        switch(option){
            case 1:
                // input format - Official: nimal,nimal@gmail.com,ceo
                String details= scanner.nextLine().strip();

                // Use a single input to get all the details of a recipient
                String[] dataList =details.split("[,:]");

                // code to create objects for each recipient in clientList.txt
                // code to add a new recipient
                BuildRecipient Buildrecipient  = new BuildRecipient();
                Recipient recipient=Buildrecipient.make(dataList);
                recipientList.add(recipient);

                // store details in clientList.txt file
                Writer writer=new Writer(); //initialize the writer class
                writer.writing(details); //call the writing method in writer class to write a new recipient's details to file

                break;
            case 2:

                // input format - email, subject, content
                String mail = scanner.nextLine().strip();
                String[] mailData= mail.split("[,:]");

                System.out.println("please wait,still sending the email");

                // send an email
                SendingEmail sendingEmail = new SendingEmail();
                sendingEmail.send(mailData[0],mailData[1],mailData[2]);

                System.out.println("successfully sent");

                //create Email object and add the email that sent ,to the emailList
                Email email = new Email(mailData[0],mailData[1],mailData[2],currentDate);
                emailList.add(email);

                break;
            case 3:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                String givenDate = scanner.nextLine().strip();
                String givenDateLast = givenDate.substring(4);

                // print recipients who have birthdays on the given date
                birthdayFinding.birthdayPrinting(givenDateLast,recipientList);
                break;
            case 4:
                // input format - yyyy/MM/dd (ex: 2018/09/17)
                String givenDate2 = scanner.nextLine().strip();

                // print the details of all the emails sent on the input date
                EmailFinding emailFinding =new EmailFinding();
                emailFinding.printPastEmails(givenDate2,emailList);
                break;
            case 5:
                // print the number of recipient objects in the application
                System.out.println(BuildRecipient.recipientCount);

                break;

        }

        System.out.println();
        serialization.serialize(emailList);  //serialize every objects in emailList to  a .SER file



    }
}

