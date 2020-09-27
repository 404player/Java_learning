package com.oop.demo10;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Outer {

    private int id = 10;
    public void out(){
        System.out.println("这是外部类的方法");
    }

    public class Inner{
        public void in(){
            System.out.println("这是内部类的方法");
        }


        //获得外部类的私有属性
        public  void getID(){
            System.out.println(id);
        }

        //要是设置为静态内部类，则无法访问外部类的属性和方法
    }

    //局部内部类

    public void method(){
        class Inner{
            public void in(){

            }
        }
    }
}

//一个java类中可以有多个class类，但是只能有一个public class类

class A{
     void hello(){
        System.out.println("hey!");
    }
}


