package com.java_model;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 10:25 2020/7/9
 */
public class BaseQueryRequest extends BaseRequest {

    public static final Integer SEARCH_FLAG             = 1;

    //搜索标记
    private Integer             flag            =  SEARCH_FLAG;

    //搜索值
    private String              search;


    //当前第几页
    private Integer             current = 1;


    //当前第几页
    private Integer             pageSize = 10;

    public void setSearch(String search) {
        if (search == null) {
            this.search = StringUtils.EMPTY;
        } else {
            this.search = search;
        }
    }

    public String getSearch() {
        if (search == null) {
            return StringUtils.EMPTY;
        }
        return this.search;
    }

    public  void setCurrent(Integer current) {
        this.current = current == null || current == 0 ? 1 :current;
    }

    public Integer getPageSize() {
        return pageSize == null || pageSize == 0 ? 10 : pageSize;
    }

}
