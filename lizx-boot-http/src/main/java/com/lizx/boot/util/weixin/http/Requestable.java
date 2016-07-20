package com.lizx.boot.util.weixin.http;

import java.util.Map;

/**
 * Created by art on 2016/7/20.
 */
public interface Requestable {
    void get(String url);

    void post(String url, Map<String, Object> params);
}
