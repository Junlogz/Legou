package com.zjl.legou.pay.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayUtils {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117625924";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCTwHr1D5Co30f/kXE2M/DR88FabI/a3TcV3D5lJKiY+TuWLR1PzXfLo8cLnZNeHmHuZM8pFZzKVBlsxIMmrjPMGCM9Oih28MRbvCJCvmCiGDe3vFgrulwnI4ArHYMc641aDlWB8vtvQvftacarrzl9aD10SmTw3Y0ZfFGIaJTqZJDq7fBvqVumqB2sDxV20f3DeffI45o4ddk4FF/a1xpz1jf5fcJdRf8t2BeXl5OVApm+s5BLI3goBAB8Wvdnphk33TT4DEixQVg9kruV4FWmesgTuSlFGZSwTXpbWZ3TZP6/VMgLjldAWEaAFixPW8ZwOhHVFqPBk3TuG1hG0lU9AgMBAAECggEAY74iw2C4lWf2IM88kAzMW8+kDbkP+/4ue7Fs5bazomFOGnlmOkNIxc5QRsUfgQAduGORffi7GdNgPo8CwpADI5p/34ttWa37wLnmnwwKDCMxKfYZx5tNLpbGpVSM+G8Dw3G9w7YWiuu4lys7FRd7Re+i3OiD8B6AbF4CZIXFUd13f5MIq0C5LWaT4J3nz9KZwrWJNpFXmNwzdinsiDzEBWUBaUVdpMjt9CkSwn25huvc0H4AZXgrRSjod2eZse/3zmHEfcACVH8p79pTpP9drn4S1VtcVNZJEo3/IO2931LwotHzqvu8siyGtbhuoB8F/FCwe3ruPaV/0f99cTnCAQKBgQD4cy2QKtyT00FO3+u+qlO9Z2sKQranj0O6Xe1gsXs+x2G1NslE2tng2uQsWVIAI/ei/GTjzyv6Ws/eYZYpOf9Griwb62bTTCiNNbTjUBW/v1lU9zA/Se9nC46Stqys0YySPsDR3wr2hYZehrLCukXLYvn8YUTk7Jvtz3Rn6k0SfQKBgQCYPetm6OqFG755rFZlOFBSW/JX+x1Yz+VnM+EPDMoz0nQ3gGl7ctqNdko5D4nR9CFnqQ0KLhRBxCcawQuN+b/+ms9vu1hZX9t6dKMR5aal+mmHRkDaPbdDA3NcKd9Y+GW6Fk1mY5pOJP4V7ZDkJVGRZY7L+e1k7oVdtylMFSUJwQKBgQCTFx2SjM2qdxfjKo7Xgt+w8tlcacLZ0Oe4HoO7C1h8Am7GankeWrNDfFQ6LWduzdx+kg7pEG5o+fq3He9Y2Q1ZOyTCIsvtrNkVQQamzXMS4qZwtyfJUGx8BUuTcLMqXaVrr9tYZUSITuUOcZDD2KQZla+Ky8uN/McUNA4mt4CJwQKBgHLUgXIlzH6J5qmvq5q9VxhH8gsahZAvf0DQiLjpVLqxyqbyXJ2Yi/CXgHR5m+KY2XlusT80cmMIqNYtNaHo9z/7VOtZy9Hd05YR0830Aja/Ikm+W7xBQLFzMNgbXTOmaFRr7gWEqya2EFBJ2De9TkD08Tg5Uy4GGuIM/UE90aoBAoGBANwsdxuDC28kG6UWHl6C83lhTzL4H3FpJegnKBpFTCXCd6yn+lKpiPoE+Na2+FWBpYTnsBQlvlBeo4zcnl61OLGdRH2RgMSdGPjradfoWj7d8xIw7cT9iJZoGF86KVq5cqAj3tRHzVqc9eGimD1t5VR+D4qmcw8Od0au1GuxVLWj";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmUCsqYhYsEPdYzDkBzROxTpV19y03j6lRlDH3x/H1+tqLCh6HNiHYkpV8IjYIiRqNBBdzw1XOaPM9jDw6g8nHWVTswKmvgPSzEk4sPlPPLpoANZxYL2NMaFnnMBNughC5uCneQBPtFbIpGGYURH5VV1jg+C2FE94f6hChNbU+860uu4INsBPEynm/99hJQS6mfD6z6DH1x/+QQYiqnxY1rMgmDrT7ZRtM8NqV77m1VDDFRpklBi9TUbypZcgtWlVs1s7DW6uMAeDxMIyaWHfR8+MgHl1/7/A6rlfX97bRdbt22i5vkjFbjq18No7noZDxdyZcM+Gc99GnF+amJOFuQIDAQAB";

    // 服务器异步通知页面路径
    //需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://md2p7c.natappfree.cc/getnotify";

    // 页面跳转同步通知页面路径
    //需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://md2p7c.natappfree.cc/getreturn";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关,注意这些使用的是沙箱的支付宝网关，与正常网关的区别是多了dev
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
