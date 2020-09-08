package com.annotation;

import lombok.Data;

/**
 * @author guozhongdong
 * @Description:
 * @date 2020/9/3
 */
@Data
@DefinitionClass("学生基本信息")
public class Student {

    @Column("0021")
    private String code ;


    @Column("张三")
    private String name;


    @MethodAnnotation("读书")
    public void action(){
        System.out.println("在读书");
    }

}
