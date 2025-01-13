package company;
//import com.sun.jdi.connect.Transport;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendingEmail {
    final String sender="stefanfernando77@gmail.com";
    final String senderPassword="aohnsujsoiutenxo";
    private String receiver;
    private String subject;
    private String content;




    public void send(String receiver,String subject,String body) {



            final String username = "stefanfernando77@gmail.com";
            final String password = "aohnsujsoiutenxo";

            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS

            Session session = Session.getInstance(prop,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("stefanfernando77@gmail.com"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(receiver)
                );
                message.setSubject(subject);
                message.setText(body);

                Transport.send(message);

                //System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

    }






