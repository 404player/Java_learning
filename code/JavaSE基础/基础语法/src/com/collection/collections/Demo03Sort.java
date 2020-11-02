package com.collection.collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*

    Comparator和Comparable的区别
    Comparable:自己要和别人比较，自己需要实现Comparable接口，重写比较的规则compareto方法
    Comparator:相当于找一个第三方的裁判来比较两个人

 */
public class Demo03Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(3);
        list01.add(2);
        System.out.println(list01);

        Collections.sort(list01, new Comparator<Integer>() {
            //重写比较的规则
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;//升序
                //return o2-o1
            }
        });
        System.out.println(list01);

        ArrayList<Student> list02 = new ArrayList<>();
        list02.add(new Student("a",18));
        list02.add(new Student("b",20));
        list02.add(new Student("c",17));
        list02.add(new Student("d",18));
        System.out.println(list02);

        Collections.sort(list02, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result =  o1.getAge()-o2.getAge();
                //如果两个人年龄相同。在使用姓名的第一个字比较
                if(result==0){
                    result = o1.getName().charAt(0)-o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(list02);
    }
}
