package com.java_model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 9:31 2020/7/9
 */
public abstract class BaseDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5949245981562562782L;

    //重新实现equal
    @Override
    public boolean equals (Object object) {
        return EqualsBuilder.reflectionEquals(this,object);
    }

    //重新实现hashCode
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    //重新实现toString
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
