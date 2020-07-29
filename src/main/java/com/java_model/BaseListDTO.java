package com.java_model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:列表数据模型
 * @Date :Create in 9:29 2020/7/9
 */
public class BaseListDTO<T extends BaseDTO> extends BaseDTO {
    /*
        序列id可以不用指定值；指定值的时候在序列化的时候会出现问题
    * */


    /*数据模型列表*/
    private List<T>                                         list;

    public BaseListDTO() {
        super();
        this.list = new ArrayList<>(0);
    }


    public BaseListDTO(List<T> list) {
        this.list = list;
    }


}
