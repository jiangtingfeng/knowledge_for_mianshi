package com.java_model;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:10 2020/7/9
 */
public class BooleanDTO extends BaseDTO {

    private Boolean     expression;

    public BooleanDTO (Boolean expression) {
        this.expression = expression;
    }

    public BooleanDTO() {
        super();
    }

}
