package online.niuma.blog.utils;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@Setter
@Component
public class MyEmail {

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Resource
    private JavaMailSenderImpl mailSender;

    @Async
    public void sendMail(String emailTitle, String emailContent, String toEmail) {
        log.info("发生邮件给:{}", toEmail);
        System.out.println("this.emailTitle = " + emailTitle);
        System.out.println("emailTitle = " + emailTitle);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(emailTitle);
        message.setText(emailContent);
        message.setTo(toEmail);
        message.setFrom(fromEmail);
        mailSender.send(message);
    }
}
