package com.collection.map;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
    斗地主综合案例：有序版本
    1.准备牌
    2.洗牌
    3.发牌
    4.排序
    5.看牌
 */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //创建一个Map集合，存储牌的索引和组装好的牌
        HashMap<Integer,String> poker = new HashMap<>();
        //创建一个List集合，存储牌的索引
        ArrayList<Integer> pokerIndex = new ArrayList<>();
        //定义两个集合，存储花色和拍的序号

        ArrayList<String> colors = new ArrayList<>();
        Collections.addAll(colors,"♠","♥","♣","♦");
        ArrayList<String> numbers = new ArrayList<>();
        Collections.addAll(numbers,"2","A","K","Q","J","10","9","8","7","6","5","4","3");

        //把大王小王存储到集合中
        //定义一个牌的索引
        int index = 0;
        poker.put(index,"大王");
        pokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        pokerIndex.add(index);
        index++;

        //循环把52张牌存入集合中
        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color+number);
                pokerIndex.add(index);
                index++;
            }
        }
//        System.out.println(poker);
//        System.out.println(pokerIndex);

         /*
            洗牌： shuffle
          */

        Collections.shuffle(pokerIndex);

        //定义四个集合，存储玩家牌的索引
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();

        //比哪里存储牌索引的List集合，获取每一个牌的索引
        for (int i = 0; i < pokerIndex.size(); i++) {
            Integer in = pokerIndex.get(i);
            if (i>=51){
                diPai.add(in);
            }else if (i%3==0){
                player01.add(in);
            }else if(i%3==1){
                player02.add(in);
            }else{
                player03.add(in);
            }
        }
        /*
            排序：使用sort方法

         */
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(diPai);

        lookPoker("player01",poker,player01);
        lookPoker("player02",poker,player02);
        lookPoker("player03",poker,player03);
        lookPoker("diPai",poker,diPai);

    }

    /*
        定义看牌的方法，提高代码的复用性
        参数：
            String name:玩家名称
            HashMap<Integer,String> poker:存储牌的poker集合
            ArrayList<Integer> list: 存储玩家和底牌的List集合
     */

    public static void lookPoker(String name,HashMap<Integer,String> poker,ArrayList<Integer> list){
        System.out.print(name+":");
        for(Integer key: list){
            String value = poker.get(key);
            System.out.print(value+" ");
        }
        System.out.println();
    }
}