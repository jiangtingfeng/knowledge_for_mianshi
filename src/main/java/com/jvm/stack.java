package com.jvm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: jiangtingfeng
 * @Description:
 * @Date :Create in 14:20 2020/4/28
 */
public class stack {


    public static void main(String[] args) throws JsonProcessingException {
        Dept dept = new Dept();
        dept.setName("jndx");
        Emp e1 = new Emp();
        Emp e2 = new Emp();
        e1.setName("zx");
        e2.setName("hxw");
        e1.setDept(dept);
        e2.setDept(dept);
        dept.setEmp(Arrays.asList(e1,e2));
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(dept);
        System.out.println(s);
    }



}
class Dept {
    private String name;
    private List<Emp> emp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmp() {
        return emp;
    }

    public void setEmp(List<Emp> emp) {
        this.emp = emp;
    }


}

class Emp {
    private String name;
    @JsonIgnore
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}