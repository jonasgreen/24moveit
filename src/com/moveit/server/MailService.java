package com.moveit.server;

import com.moveit.client.ApplicationException;
import com.moveit.client.SystemException;
import com.moveit.client.language.Language;
import com.moveit.client.language.LEmailPassword;
import com.moveit.client.model.User;
import com.moveit.server.mail.MailTemplate;
import com.moveit.server.mail.UserCreatedMail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 *
 */
public class MailService {

    private static String FROM_ADDRESS = "jonasgreen12345@gmail.com";
    private static String FROM_NAME = "24moveit";


    public void accountCreated(User user, int language) throws ApplicationException {
        UserCreatedMail mail = new UserCreatedMail(user);

        MailTemplate mt = new MailTemplate(Language.getLanguage(user), mail.getTitle());
        sendMail(user, mail.getTitle(), mt.createMail(mail.getEmailContent(), true), language);
    }



    





    public void sendMail(User to, String subject, String msgBody, int language) throws ApplicationException {
        sendMail(to.getEmail(), to.getName(), subject, msgBody, language);
    }

    public void sendMail(String email,String name, String subject, String msgBody, int language) throws ApplicationException {
        Properties props = new Properties();
        props.setProperty("mail.mime.charset", "UTF-8");
        Session session = Session.getDefaultInstance(props, null);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(FROM_ADDRESS, FROM_NAME));
            InternetAddress toAddress = new InternetAddress(email, name);
            msg.addRecipient(Message.RecipientType.TO, toAddress);
            msg.setSubject(MimeUtility.encodeText(subject, "UTF-8", null));
            msg.setContent(msgBody, "text/html");

            Transport.send(msg);
        }
        catch (AddressException e) {
            throw new ApplicationException(LEmailPassword.EMAIL_NOT_VALID.get(language));
        }
        catch (MessagingException e) {
            throw new SystemException(e.getMessage());
        }
        catch (UnsupportedEncodingException e) {
            throw new SystemException(e.getMessage());
        }
    }

}
