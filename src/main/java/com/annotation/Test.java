package com.annotation;

import com.annotation.handler.AnnotationHandler;

import java.util.HashMap;
import java.util.Map;


/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/3
 *
 * https://blog.csdn.net/johnson_moon/article/details/79099285
 */
public class Test {

    public static final String KINIT_COMMAND = "zookeeper.kinit";
    public static final String JGSS_NATIVE = "sun.security.jgss.native";
    private final Map<String, String> properties = new HashMap<String, String>();



    public static void main(String[] args) {
        Test test = new Test();
        test.handleBackwardCompatibility();
        //AnnotationHandler.getStudentValue(Student.class);
        System.out.println(System.getProperty("zookeeper.kinit"));
    }


    protected void handleBackwardCompatibility() {

        properties.put(KINIT_COMMAND, System.getProperty(KINIT_COMMAND));
        properties.put(JGSS_NATIVE, System.getProperty(JGSS_NATIVE));


    }
}
