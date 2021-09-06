package com.tensquare.sms.listener;

import com.tensquare.sms.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 短信监听类
 */
@Component
@RabbitListener(queues = "sms")
@PropertySource(value = "classpath:txcloud.properties",encoding = "UTF-8")
public class SmsListener {
    @Autowired
    private SmsUtil smsUtil;
    @Value("${sms.templateId}")
    private String templateId;
    @Value("${sms.sign}")
    private String sign;

    /**
     * 发送短信
     *
     * @param message
     */
    @RabbitHandler
    public void sendSms(Map<String, String> message) {
        System.out.println("手机号：" + message.get("mobile"));
        System.out.println("验证码：" + message.get("code"));
        String[] mobiles = new String[1];
        mobiles[0] = message.get("mobile");
        String[] params = new String[2];
        params[0] = message.get("code");
        params[1] = message.get("validTime");
        smsUtil.sendSms(mobiles, templateId, sign, params);
    }
}