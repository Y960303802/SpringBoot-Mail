package com.xizi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09AsynApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test
    void contextLoads() {
        //一个简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("戏子你好啊~");
        simpleMailMessage.setText("未来可期");
        simpleMailMessage.setTo("960303802@qq.com");
        simpleMailMessage.setFrom("960303802@qq.com");

        javaMailSender.send(simpleMailMessage);
    }

    @Test
    void contextLoad2() throws MessagingException {
        //一个复杂的邮件

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);

        helper.setSubject("戏子测试邮件发送");
        helper.setText("<p style='color:red'>SpringBoot,未来可期~</p>",true);

        //附件
        helper.addAttachment("698363.png",new File("D:\\Documents\\Desktop\\常用快捷文档\\6666.jpg"));
        helper.setTo("960303802@qq.com");
        helper.setFrom("960303802@qq.com");

        javaMailSender.send(mimeMailMessage);

    }


    /**
     *
     * @param html  多文本发送
     * @param subject 标题
     * @param text  内容
     * @throws MessagingException
     */
        public void sendMail(Boolean html,String subject,String text) throws MessagingException {
        //一个复杂的邮件

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,html);

        helper.setSubject(subject);
        helper.setText(text,true);

        //附件
        helper.addAttachment("698363.png",new File("D:\\Documents\\Desktop\\picture\\698363.png"));
        helper.setTo("960303802@qq.com");
        helper.setFrom("960303802@qq.com");

        javaMailSender.send(mimeMailMessage);

    }


}
