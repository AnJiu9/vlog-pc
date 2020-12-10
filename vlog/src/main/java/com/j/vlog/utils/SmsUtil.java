package com.j.vlog.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;
import sun.net.idn.Punycode;

import javax.annotation.Resource;
import java.security.PublicKey;

/**
 * @ClassName sendSms
 * @Description 发送短信工具类
 * @Author orange
 * @Date 2020-12-06 12:40
 **/

@Component
public class SmsUtil {
    /**
     * 注入读取阿里云资源的类，从而避免直接将账号密码写死在代码里上传而泄密
     */
    @Resource
    public AliyunResource aliyunResource;

    public boolean sendSms(String mobile, String code) {
        System.out.println(aliyunResource.getAccessKeyId());
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",
                aliyunResource.getAccessKeyId(),
                aliyunResource.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "uni小程序");
        request.putQueryParameter("TemplateCode", "SMS_206551095");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");

        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            String resData = response.getData();
            //将返回的JSON字符串转成JSON对象
            JSONObject jsonObject = JSON.parseObject(resData);
            //发送成功
            if ("OK".equals(jsonObject.get("Code"))) {
                return true;
            }
        } catch (ClientException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}
