package company;

import java.util.ArrayList;

public class BirthdayFinding {
    public void birthdayPrinting(String givenDateLast, ArrayList<Recipient> recipientList){

        for (Recipient recipient :recipientList){
            if (! recipient.getBirthday().equals("N")){
                String birthDateLast=recipient.getBirthday().substring(4);

               if (givenDateLast.equals(birthDateLast))
                {
                    System.out.println(recipient.getName());
                }
        }
    }}

  public void sendBirthdayWish(String currentDate,ArrayList<Recipient> recipientList,ArrayList<Email> emailList){
        String subject ="Birthday Wish";
      String currentDateLast=currentDate.substring(4);
        SendingEmail sendingEmail=new SendingEmail();
        for (Recipient recipient: recipientList){
            if (recipient instanceof PersonalFriend){
                String content = "Hugs and love on your birthday.Dushan";
                PersonalFriend personalFriend = (PersonalFriend) recipient;
                String birthdateLast= personalFriend.getBirthday().substring(4);
                if (currentDateLast.equals(birthdateLast)){
                    Email email = new Email(personalFriend.getEmail(),subject,content,currentDate);
                    emailList.add(email);
                    sendingEmail.send(personalFriend.getEmail(),subject,content);


                }
            }

            else if (recipient instanceof OfficialFriend){
                String content = "Wish you a Happy Birthday..Dushan";
                OfficialFriend officialFriend = (OfficialFriend) recipient;
                String birthdateLast= officialFriend.getBirthday().substring(4);
                if (currentDateLast.equals(birthdateLast)){
                    Email email = new Email(officialFriend.getEmail(),subject,content,currentDate);
                    emailList.add(email);
                    sendingEmail.send(officialFriend.getEmail(),subject,content);


                }
            }
        }
    }
}
