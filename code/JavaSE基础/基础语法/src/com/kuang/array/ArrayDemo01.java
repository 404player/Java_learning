package com.kuang.array;

public class ArrayDemo01 {
    public static void main(String[] args) {
        int[] nums;//定义
        int nums2[]; //次选，方便让C/C++程序员掌握Java

        nums = new int[10];//这里面可以存放10个int类型的数

        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        nums[5] = 6;
        nums[6] = 7;
        nums[7] = 8;
        nums[8] = 9;
        nums[9] = 10;
        System.out.println(nums[0]);
        int sum =0;
        for(int i =0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        System.out.println("总和为："+sum);
    }
}
