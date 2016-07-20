package com.lizx.boot.util.weixin.util;

import com.lizx.boot.util.ClassUtils;
import com.lizx.boot.util.weixin.pay.protocol.MchPay;

import java.util.Map;

/**
 * Created by art on 2016/7/20.
 */
public class WxUtils {
    private WxUtils(){}

    public static void main(String[] args){
        MchPay mch = new MchPay();
        mch.setMch_appid("dfdsfsdf");
        mch.setMchid("app_1234444");

        Map<String, Object> map = ClassUtils.toMap(mch);
        System.out.println(map.get("mchid"));
    }

}
