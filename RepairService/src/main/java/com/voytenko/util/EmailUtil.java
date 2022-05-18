package com.voytenko.util;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class EmailUtil {

    private final JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerConfigurer freemarkerConfigurer;

    @Value("${spring.mail.username}")
    private String from;

    public void sendEmail(String to, String templateName, String subject, Map<String, String> userData) {
        Template freemarkerTemplate = null;
        try {
            freemarkerTemplate = freemarkerConfigurer.getConfiguration().getTemplate(templateName);
            String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerTemplate, prepareData(userData));

            MimeMessagePreparator messagePreparator = mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setSubject(subject);
                messageHelper.setFrom(from);
                messageHelper.setTo(to);
                messageHelper.setText(htmlBody, true);

            };
            javaMailSender.send(messagePreparator);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> prepareData(Map<String, String> userData) {
        Map<String, Object> data = new HashMap<>();
        data.put("userDetails", userData);
        return data;
    }


}

