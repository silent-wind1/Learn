package com;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@SpringBootTest
class Springboot08TestApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
//        一个简单的邮件
        int i = 0;
        while (i < 1) {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("未来的我你好呀~");
            simpleMailMessage.setText("未来的我，你在未来过得还好吗，有没有拿到Python一等奖？专升本成功了吗？是不是能在公司敲代码？我真心快点独立生活有一份工作，不想在花父母的钱。");
            simpleMailMessage.setTo("1797719651@qq.com");
            simpleMailMessage.setFrom("1797719651@qq.com");
            mailSender.send(simpleMailMessage);
            i++;
        }

    }

    @Test
    void contextLoads2() {
//      复杂的邮件
        boolean flag = isMailUtils(
                true,
                "过去的我你好呀~",
                "我过得很好，你问的问题我都实现了，感谢过去的你的努力，不让我也不会成功。任何困难都不要怕，不要畏惧，我们很强大，都会解决的。",
                "2951575706@qq.com",
                "1797719651@qq.com"
        );
        if (flag == true) {
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
    }

    /**
     * @param html
     * @param title
     * @param text
     * @param mailTo
     * @param MailForm
     * @throws MessagingException
     * @Author 叶枫
     */
    public Boolean isMailUtils(boolean html, String title, String text, String mailTo, String MailForm) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, html);
            mimeMessageHelper.setSubject(title);
            mimeMessageHelper.setText(text);
            mimeMessageHelper.setTo(mailTo);
            mimeMessageHelper.setFrom(MailForm);
            mailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
