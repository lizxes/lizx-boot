package com.lizx.boot.util.weixin.http;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by art on 2016/7/20.
 */
public abstract class Request implements Requestable{
    protected String defaultCharset = "UTF-8";

    public static void closeQuietly(Closeable close){
        if (close != null){
            try {
                close.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }

    public static void close(Closeable close) throws IOException {
        if (close != null){
            close.close();
        }
    }
}
