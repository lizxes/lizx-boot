package com.lizx.boot.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by art on 2016/7/20.
 */
public class XmlUtils {
    private static final String PREFIX_CDATA = "<![CDATA[";
    private static final String SUFFIX_CDATA = "]]>";

    // 解决XStream出现双下划线的bug
    private static final XStream xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));

    // 解决XStream出现双下划线的bug以及加cdata
    private static final XStream xStreamCDATA = new XStream(new DomDriver("UTF-8", new NoNameCoder()){
        public HierarchicalStreamWriter createWriter(Writer writer) {
            return new PrettyPrintWriter(writer){
                @SuppressWarnings("rawtypes")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                };

                public String encodeNode(String name) {
                    return name;
                };

                protected void writeText(QuickWriter writer, String text) {
                    writer.write(PREFIX_CDATA);
                    writer.write(text);
                    writer.write(SUFFIX_CDATA);
                };

            };
        };
    });

    private XmlUtils(){}

    public static String toXml(Object object) {
        return xStream.toXML(object);
    }

    public static String toXml(String alias, Object object) {
        xStream.alias(alias, object.getClass());
        return xStream.toXML(object);
    }

    public static String toXmlCDATA(Object object) {
        return xStreamCDATA.toXML(object);
    }

    public static String toXmlCDATA(String alias, Object object) {
        xStreamCDATA.alias(alias, object.getClass());
        return xStreamCDATA.toXML(object);
    }

    public static Object fromXml(InputStream input){
        return xStream.fromXML(input);
    }

    public static Object fromXml(InputStream input, String alias, Class<?> clazz){
        xStream.alias(alias, clazz);
        return xStream.fromXML(input);
    }

}
