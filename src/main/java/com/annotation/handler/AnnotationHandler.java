package com.annotation.handler;


import com.annotation.Column;
import com.annotation.DefinitionClass;
import com.annotation.MethodAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/8
 * 自定义注解处理器
 *
 */
public class AnnotationHandler {


    public static void getStudentValue(Class<?> clazz){

        String code = "学生编号：";
        String name = "学生行为：";
        String action = "学生行为：";

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)){
                if (field.getName().equals("code")){
                    System.out.println(code + " " + field.getAnnotation(Column.class).value());
                }
                if (field.getName().equals("name")){
                    System.out.println(name + " " + field.getAnnotation(Column.class).value());
                }

            }
        }
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodAnnotation.class)){
                System.out.println(action+" "+method.getAnnotation(MethodAnnotation.class).value());
            }
        }
        System.out.println(clazz.isAnnotationPresent(DefinitionClass.class));
        if (clazz.isAnnotationPresent(DefinitionClass.class)){
            System.out.println(clazz.getAnnotation(DefinitionClass.class).value());
        }

    }

}
