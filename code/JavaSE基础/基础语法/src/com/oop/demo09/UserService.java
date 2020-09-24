package com.oop.demo09;

// 抽象的思维
// interface 定义的关键字,接口都需要有实现类
public interface UserService {
    //接口中所有的定义其实都是抽象的 public abstract

    //public static final  int age = 99;

    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);
}
