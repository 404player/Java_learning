package com.collection.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Demo01Collections {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //public static<T> boolean addALL<Collection<T> c,T....elements)
        Collections.addAll(list,"a","b","c","d");
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }

}
