package com.kuang.array;

public class ArrayDemo05 {
    public static void main(String[] args) {
        //[4][2]
        /*
        1,2
        2,3
        3,4
        4,5
         */
        int[][] array = {{1,2},{2,3},{3,4},{4,5}};

        //System.out.println(array[0]);

        for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }



    }
}
