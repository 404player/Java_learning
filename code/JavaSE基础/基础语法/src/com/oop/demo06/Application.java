package com.oop.demo06;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import sun.util.resources.cldr.en.TimeZoneNames_en_ZA;

public class Application {
    public static void main(String[] args) {

        Student student = new Student();
        student.eat();
        Person person = student;
        //person.eat();并不能调用
        //子类转换为父类，可能会丢失自己本来的一些方法


    }


}
