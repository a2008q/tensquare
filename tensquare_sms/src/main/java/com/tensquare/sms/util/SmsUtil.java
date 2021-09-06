package com.tensquare.sms.util;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:txcloud.properties",encoding = "UTF-8")
public class SmsUtil {


    @Autowired
    private Environment env;
    @Value("${sms.appId}")
    private String appId;


    /**
     * @param mobiles
     * @param templateID
     * @param sign
     * @param params
     * @return
     */
    public SendSmsResponse sendSms(String[] mobiles, String templateID, String sign, String[] params) {
        String secretId = env.getProperty("sms.secretId");
        String secretKey = env.getProperty("sms.secretKey");
        SendSmsResponse res = new SendSmsResponse();
        try {
            Credential cred = new Credential(secretId, secretKey);
            SmsClient client = new SmsClient(cred, "");
            SendSmsRequest req = new SendSmsRequest();
            req.setSmsSdkAppid(appId);
            req.setSign(sign);
            req.setTemplateID(templateID);
            req.setPhoneNumberSet(mobiles);
            req.setTemplateParamSet(params);
            res = client.SendSms(req);
            return res;
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return res;
    }


}
