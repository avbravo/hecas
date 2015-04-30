/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruta.hecas.email;

import com.cruta.hecas.generales.JSFUtil;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author avbravo
 */
@Named
@RequestScoped
public class EnviarEmail {

    /**
     * Creates a new instance of EnviarEmail
     */
    public EnviarEmail() {
    }

    public String enviar() {
        try {
           
            final String username = "hecas@gmail.com";
            final String password = "azuero2015nasa";

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

      

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("avbravo@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("avbravo@gmail.com"));
                message.setSubject("Alert");
                message.setText("Existe una plaga,"
                        + "\n\n No spam to my email, please!");

                Transport.send(message);

                System.out.println("Done");

           
        } catch (Exception ex) {
JSFUtil.infoDialog("error", ex.getLocalizedMessage());
            System.out.println("error "+ex.getLocalizedMessage());
        }
        return null;
    }
}
