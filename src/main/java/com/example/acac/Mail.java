package com.example.acac;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public static void generateRegistrationMessage(String firstname, String email) throws AddressException, MessagingException {

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        //additional address - generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
        generateMailMessage.setSubject("Välkommen till ACAC!");
        String emailBody = "Hej " + firstname + "!" + "<br><br>" + "Tack för din registrering" + "</a>" + "<br><br> Med vänliga hälsningar, <br>ACAC";
        generateMailMessage.setContent(emailBody, "text/html; charset=utf-8");

        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "no.reply.acac@gmail.com", "acac2018");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

    public static void generateClaimMessage(String firstname, String email) throws AddressException, MessagingException {

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        //additional address - generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
        generateMailMessage.setSubject("ACAC tackar för din anmälan!");
        String emailBody = "Hej " + firstname + "," + "<br><br>" + "Vi har mottagit din anmälan. " + "</a>" +
                "Så snart motparten skickat in sin anmälan kommer vi matcha ihop dessa och skicka till båda era försäkringsbolag." + "</a>"
                + "<br><br> Med vänliga hälsningar, <br>ACAC";
        generateMailMessage.setContent(emailBody, "text/html; charset=utf-8");

        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "no.reply.acac@gmail.com", "acac2018");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

    public static void generateInsuranceCompanyClaimMessage(String firstname, String email, String body) throws AddressException, MessagingException {

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        //additional address - generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
        generateMailMessage.setSubject("En av dina kunderhar råkat ut för en olycka");

        generateMailMessage.setContent(body, "text/html; charset=utf-8");

        Transport transport = getMailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "no.reply.acac@gmail.com", "acac2018");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}
