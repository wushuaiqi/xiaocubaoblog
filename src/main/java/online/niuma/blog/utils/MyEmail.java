package online.niuma.blog.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
@Slf4j
public class MyEmail {

    private String emailTitle;
    private String emailContent;
    private String fromEmail;
    private String toEmail;

    public void saveEmail() {
        log.info("发生邮件给:{}", this.toEmail);
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(this.emailTitle);
        simpleMailMessage.setText(this.emailContent);
        simpleMailMessage.setTo(this.toEmail);
        simpleMailMessage.setFrom(this.fromEmail);
        mailSender.send(simpleMailMessage);
    }
}
