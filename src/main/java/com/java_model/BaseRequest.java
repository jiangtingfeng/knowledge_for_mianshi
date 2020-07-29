package com.java_model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Author: jiangtingfeng
 * @Description:  前端入参基类
 * @Date :Create in 10:14 2020/7/9
 */
public class BaseRequest implements Serializable {

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this,object);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
