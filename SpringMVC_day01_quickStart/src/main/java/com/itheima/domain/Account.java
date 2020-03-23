package com.itheima.domain;

import java.util.List;
import java.util.Map;

/**
 * @author zhengjd
 * @date 2020/3/19 21:43
 */
public class Account {
    private String name;
    private Integer password;
    private Double money;
    private User user;
    private List<User> list;
    private Map<String,User> map;

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", password=" + password +
                ", money=" + money +
                ", user=" + user +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }
}
