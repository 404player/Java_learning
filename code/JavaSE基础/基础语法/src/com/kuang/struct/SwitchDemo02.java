package com.kuang.struct;

public class SwitchDemo02 {
    public static void main(String[] args) {
        String name = "zzb";

        //反编译  java----class（
        switch (name){
            case "zqm":
                System.out.println("zqm");
                break;
            case "zzb":
                System.out.println("zzb");
                break;
            default:
                System.out.println("fuck you");
        }
    }
}
