package com.shanjupay.paymentagent.service;

import com.shanjupay.paymentagent.api.PayChannelAgentService;
import com.shanjupay.paymentagent.api.conf.AliConfigParam;
import com.shanjupay.paymentagent.api.conf.WXConfigParam;
import com.shanjupay.paymentagent.api.dto.PaymentResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sqx
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPayChannelAgentService {

    @Autowired
    PayChannelAgentService payChannelAgentService;

    @Test
    public void testqueryPayOrderByAli(){
        //应用id
        String APP_ID = "2016101900725017";
        //应用私钥
        String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCfhDR7AsN3M5bygO2TXFQTv/TCvxBdSP+J0evuWhUkgwrJ7MBP9TOaNyPq0sapnRGPhqHjeDLxXhFZ/mUUAaMq16pOHfDaK1+2OgM3Af9IpBgNQlZy8AClUuTbETxg6C5KK/SlitZxJ/+L17vPt5KwZhJPySCSEB+PnNTJNCUAwx0AM5QHh6MJt8Jc10Rq2Swa7FlWkrnn1WZSMNhCMl8yyvhwsHrpuVAa5di5rHFFO4YMq3u50fl9eEowL+Y3tSrJXx33MFX9i4FkLbqboBl7CNlbkbkfhXQsrZocv5ViLXNnZE31cG2BoBhMVv0jBMFNuJdRhfrVotTUHQiKpNbTAgMBAAECggEALF/DlaCcLXG9gPJapI6fmOriNLaf38NpyrYJ0sFedky52Jgym0uTske6hx1hRFe8Rdfm+vc5/Kj1XLqG9bzK3iUmbBqqIJbGRlP3BvtYP6XeRvn4QHsBQvw/S62MxUxxbBK0OMTZiJre3NEDnvHrLYUHfQhvNhKkJPg0vU/zJzWvJlgPErjONLZNBFtbu7nYR53ROOvsKDVcaLp0AYCDxzhq7HecvrGrQouq7WW/rsbnyOPUCfnyLYa552nL43UrVEJpa8Y/T+eYN4gWx7gqVPBgbFe/sO5bBiKgXZk/5SCVzRxopjN6RKKYeGr6v1I+MjVrLZ8nACPEp47082S5+QKBgQDVlNri3k/fJB5KvdsN7Fj56StFXlWTeyei91YeshQ3dOm4CC4jgWOc9+cRAQbhu97T4hsEFOH8JK4Xbeh0gdl9k7cQFGxaE0wXCsezc9iWgL8bSdU3KtWK+ZhEF0gVtLG2BKQpusxv4ux1YH2fhywgJ0P/fJkcOE0cgHhlr9VSDwKBgQC/MoP2sz0PYSXnwFgBF1cJ8YZQfpOpb0iGiaTymi25UatbN0/72Wxg1VuiJNhSSr2QXrjIcd3qV2MRUqnN5ITYAO6tEECXeGkP9X/VMlNekLXRmw0CkjW3yvd5xOgxao1n2JaUnOBy9BQ+duo2uOKewbkya3N3telf7XqWUwdi/QKBgDJSRRQozubDKsPvYXoxUnFnR4OrizwZSyhxYAARcwPx7tMmUkCZTrAAFJgEBuwOiJyhbD4U8X2n4sCwa5Fvup+Eux/1v+WlIEtZhd25ELG9GcnDJpI97Fw3HHIGjjxW+3voMgmG8n32GEI7fr2kangU6Ed8wtJMTZbGihdjSz5vAoGBAJZB7NOEKQhdIJzw3Dh/TzfRR+0ajJErk6OnqKm/4Q8yz6fv4Dvcsv+mrUzQB/EkK7W5ux5L3kq8Qm7qt+fHH19h3DDGBP0E9AxGsx+pXTuEHl+Lqr3KiczXBYX86T1sr5Rc8nn4j6vHheFRMt+ujOqW9CRbrXL202FAEIby2WtBAoGBALxcZLzHSvLKjPqnwqjL3m5WttIUr5td/lvJyVuK6Fnqizr9BIMTSc6AwYg/IKdHjA3g+VehvBSjdXBqtFQ/dFvP9Y0KbomkOCkUijpzqAt60Z8ELNWVU46VYly4vtcFVks5UThVDTNF9B+tz9XzbumpQJSFHekPmC1jGYgyxrTz";
        //支付宝公钥
        String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuUqtu66MHk3d7wKHwXXlkIIVulU+Hcd+SN+q3waPy3G83yJO55zHEPBhcAKCKRMRJFlnbQjBCvh+tkG0QgraPJ2DgwzTt5EseHH3Q4W1PbaBpC7aUbl3pW3tqs083Rbvxkac4a9H4V9eNeWzAjUlJnuliUKUyjmxb1mty7Ihz3UCM1ebj98vU9dgsrOntQ1XiHcjUC1yrEC/f2RMChIiBwMwBy3mcAhmYlfL6HtEqwLtllKnSRAmUvuc/H4xbv8OaajgXbYb9EG54yAOQd7q9JkmMiB8SIp5y95Yo8IFQAXYqkHfHu6Gyw5+HZlqJriVKvlH2Q6WmxosEU58oRJIZQIDAQAB";
        String CHARSET = "utf-8";
        String serverUrl = "https://openapi.alipaydev.com/gateway.do";
        AliConfigParam aliConfigParam = new AliConfigParam();
        aliConfigParam.setUrl(serverUrl);
        aliConfigParam.setCharest(CHARSET);
        aliConfigParam.setAlipayPublicKey(ALIPAY_PUBLIC_KEY);
        aliConfigParam.setRsaPrivateKey(APP_PRIVATE_KEY);
        aliConfigParam.setAppId(APP_ID);
        aliConfigParam.setFormat("json");
        aliConfigParam.setSigntype("RSA2");

        //AliConfigParam aliConfigParam,String outTradeNo
        PaymentResponseDTO paymentResponseDTO = payChannelAgentService.queryPayOrderByAli(aliConfigParam, "SJ1217987323129917440");
        System.out.println(paymentResponseDTO);
    }

    @Test
    public void testQueryPayOrderByWeChat(){
        String appID = "wxd2bf2dba2e86a8c7";
        String mchID = "1502570431";
        String appSecret = "cec1a9185ad435abe1bced4b93f7ef2e";
        String key = "95fe355daca50f1ae82f0865c2ce87c8";
        WXConfigParam wxConfigParam = new WXConfigParam();
        wxConfigParam.setKey(key);
        wxConfigParam.setAppSecret(appSecret);
        wxConfigParam.setAppId(appID);
        wxConfigParam.setMchId(mchID);

        //WXConfigParam wxConfigParam,String outTradeNo
        PaymentResponseDTO paymentResponseDTO = payChannelAgentService.queryPayOrderByWeChat(wxConfigParam, "SJ1218090459880816640");
        System.out.println(paymentResponseDTO);
    }
}
