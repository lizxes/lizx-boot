package com.lizx.boot.util.weixin.pay.protocol;

/**
 * Created by art on 2016/7/20.
 */
public class MchPay {
    private String mch_appid;
    private String mchid;

    public String getMch_appid() {
        return mch_appid;
    }

    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }
}
