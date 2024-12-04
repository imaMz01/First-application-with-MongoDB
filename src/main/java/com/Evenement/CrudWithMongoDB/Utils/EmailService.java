package com.Evenement.CrudWithMongoDB.Utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;


    public void sendEmail(String to, Context context, String subject, String template) throws MessagingException {
        try{
            String content = templateEngine.process(template, context);
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper email = new MimeMessageHelper(message,true);
            email.setTo(to);
            email.setSubject(subject);
            email.setText(content,true);
            mailSender.send(message);
            log.info("email sent successfully");
        } catch (Exception e) {
        System.err.println("Failed to send email : " + e.getMessage());
    }

    }
}
