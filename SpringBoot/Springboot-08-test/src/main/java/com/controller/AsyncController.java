package com.controller;

import com.model.Message;
import com.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "hello";
    }
    @PostMapping("/sendMessageQQEmail")
    public String sendMessageQQEmail(@RequestBody Message message) {
        return isMailUtils(message) ? "success" : "fail";
    }


    private Boolean isMailUtils(Message message) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, message.getHtml());
            mimeMessageHelper.setSubject(message.getTitle());
            mimeMessageHelper.setText(message.getText());
            mimeMessageHelper.setTo(message.getMailTo());
            mimeMessageHelper.setFrom(message.getMailForm());
            mailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            log.error("邮件发送失败", e);
        }
        return false;
    }
}
