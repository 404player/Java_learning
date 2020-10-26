## JavaSE基础语法

### Java注释

- 单行注释  

```java
public class HelloWorld {
    public static void main(String[] args) {
        //单行注释
        //输出一个Hello,World!
        System.out.println("Hello,World!");
    }
}
```

- 多行注释  

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello,World!");        
        /* 
        我是多行注释
        我能实现注释一段文本
        Hello World
        */
    }
}
```

- JavaDoc(文档注释)  

```java
/**
 * @Description HelloWorld
 * @Author 狂神说Java
 */
```

### 标识符  

> Java所有的组成部分都需要名字。类名、变量名以及方法名都被称为标识符。

- 所有标识符应该以字母，美元符（$)，或者下划线开始
- 不能使用关键字作为变量名或方法名
- 标识符是大小写敏感的  

### 数据类型

1. 强类型语言（Java是一种强类型语言）

   ​	要求变量必须先定义后才能使用

2. Java数据类型分为两大类  

- 基本类型
  - 整数类型
  - 浮点类型
  - boolean类型
- 引用类型
  - 类
  - 接口
  - 数组

### 数据类型拓展

1. 进制  

   - 八进制 010
   - 二进制0b10
   - 十六进制0x10

2. 浮点数是一个接近但不等于的值，最好不用浮点数进行比较

   ```jav
           float f = 0.1f;
           double d = 1.0/10;
   
           System.out.println(f==d); //false
           System.out.println(f);
           System.out.println(d);
   
           float d1 = 23131312312312313f;
           float d2 = d1+1;
   
           System.out.println(d1==d2);//true
           
           //要表示银行业务等功能时，需要使用Java的数学工具类BigDecimal
   ```

3. 字符可以强制转化成数字

   ```java
           char c1 = 'a';
           char c2 = '中';
   
           System.out.println(c1);
           System.out.println((int)c1);//97
           System.out.println(c2);
           System.out.println((int)c2);//20013
   
           //所有的字符本质还是数字
           //编码 Unicode 2字节    
   ```

### 类型转换

1. 类型优先度

   > byte,short,char -> int -> long -> float -> double

2. 优先度高转低的时候需要强制转换，低转高时自动转换
```java
public class Demo05 {
    public static void main(String[] args) {
        int i =128;
        byte b = (byte)i;//内存溢出

        //强制转换  （类型）变量名  高---低
        //自动转换  低--高
        System.out.println(i);
        System.out.println(b);

        double c = i;
        System.out.println(c);


        /*
        注意点：
        1.不能对布尔值进行转换
        2.不能把对象类型转换为不相干的类型
        3.在把高容量转换到低容量的时候，强制转换
        4.转换的时候可能存在内存溢出，或者精度问题
         */


        System.out.println("=======================");
        System.out.println((int)23.7); //23
        System.out.println((int)-45.89); //-45

        System.out.println("=======================");
        char e = 'a';
        int d = e + 1; //98
        System.out.println(d);
    }
}


```




3. 一定要注意数据的溢出问题

    ```java
   public class Demo06 {
       public static void main(String[] args) {
           //操作比较大的数的时候，注意溢出问题
           //JDK7新特性，数字之间可以用下划线分割
           int money = 10_0000_0000;
           System.out.println(money);
           int year = 20;
           long total = money*year;
           System.out.println(total); //long没有用，还是会出现溢出问题，计算的两个数都是int,所以计算结果都是int,后才转换成long
   
           long total2 = money*((long)year);  
           System.out.println(total2);
       }
   }
   ```

   

### 变量与常量

Java变量是程序中最基本的存储单元，其要素包括变量名，变量类型和作用域。

其他的其他语言都学得比较深刻，重点说说作用域。

- 类变量

- 实例变量

- 局部变量

  ```java
  public class Demo08 {
      //属性：变量
  
      //实例变量： 从属于对象,如果不进行初始化，这个类型的默认值 0 0.0 u0000 false
      //除了基本类型其余都是null
      String name;
      int age;
  
      //类变量 static
      static double salary = 2500;
  
      //main方法
      public static void main(String[] args) {
  
          //局部变量：必须声明和初始话值
          int i = 10;
  
          Demo08 demo08 = new Demo08();
          System.out.println(demo08.age);
          System.out.println(demo08.name);
          System.out.println(salary);
  
          //类变量 static
      }
  
      //其他方法
      public void add() {
  
      }
  }
  ```

  

所谓常量就是一种特殊的变量，它的值被设定以后，在程序运行过程中不允许改变。

- 常量前面加`final`

- 一般常量名用大写字母表示

  ```java
  public class Demo09 {
      
      //修饰符，不存在先后顺序
      static final double PI = 3.14;
  
      public static void main(String[] args) {
          System.out.println(PI);
      }
  }
  ```

变量的命名规范

- 所有变量、方法、类名：见名知意
- 类成员变量： 首字母小写和驼峰原则：`monthSalary`     除了第一个单词以外，后面的单词首字母大写
- 局部变量：首字母小写和驼峰原则
- 常量：大写字母和下划线  `MAX_VALUE`
- 类名：首字母大写和驼峰原则：`GoodMan`
- 方法名：首字母小写和驼峰原则



### 包机制

为了更好地组织类，`Java`提供了包机制，用于区别类名的命名空间。

包机制的语法格式为:

```java
package pkg1.pkg2.pkg3
```

一般利用公司域名倒置作为包名

为了能够使用另一个包的成员，我们需要在Java程序中导入该包，语法为：

```java
import pkg1.pkg2.pkg3
```

两个不同的包要是成员名一样，导入会报错，所以尽量不要使用相同的名字。  

```java
//导入这个包下所有的类

import com.kuang.base.*;
```

### JavaDoc

JavaDoc命令用来生成自己的API文档

### 参数信息



- @author 作者名
- @version 版本号
- @since 指明需要最早使用的jdk版本
- @param 参数名
- @return 返回值情况
- @throws 异常抛出情况

用命令行生成文档：

```shell
javadoc -encoding UTF-8 -charset UTF-8 Doc.java
```

[使用IDEA生成javadoc文档](https://www.jianshu.com/p/0ddb0864e499)





## Java流程控制



### 用户交互Scanner

- next()

  - 一定要读取到有效字符后才可以结束输入
  - 对输入有效字符之前遇到的空白，next()方法会自动将其去掉
  - 只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符
  - next()不能得到带有空格的字符串

  ```java
  public class Demo01 {
  
      public static void main(String[] args) {
  
          //创建一个扫描器对象，用于接收键盘数据
  
          Scanner scanner = new Scanner(System.in);
  
          System.out.println("使用next方式接收： ");
  
          //判断用户有没有输入字符串
  
          if (scanner.hasNext()){
              String str = scanner.next();
              System.out.println("输入的内容为： "+str);
  
          }
  
          //凡是属于IO流的类如果不关闭会一直占用资源，要养成好习惯用完就关掉
          scanner.close();
  
  
  
      }
  }
  ```

- nextLine()

  - 以Enter为结束符，也就是说nextLine()方法返回的是输入回车之前的所有字符
  - 可以获得空白

  ```java
  package com.kuang.scanner;
  
  import java.util.Scanner;
  
  public class Demo02 {
      public static void main(String[] args) {
  
          Scanner scanner = new  Scanner(System.in);
  
          System.out.println("使用nextLine方式接收： ");
  
          if(scanner.hasNextLine()){
              String str = scanner.nextLine();
              System.out.println("输出的内容为： "+str);
  
          }
  
          scanner.close();
      }
  }
  ```

- 传统写法

  ```java
  package com.kuang.scanner;
  
  import java.util.Scanner;
  
  public class Demo03 {
  
      public static void main(String[] args) {
  
          Scanner scanner = new Scanner(System.in);
  
          System.out.println("请输入数据： ");
  
          String str = scanner.nextLine();
  
          System.out.println("输入的内容为： "+str);
  
          scanner.close();
      }
  }
  ```


### 顺序结构

基本结构，顺序往下执行



### 选择结构

- if但选择结构

```java
if(布尔表达式){
    //如果布尔表达式为真则执行
}
```

- if双选择结构

```java
if(布尔表达式){
    //如果布尔表达式的值为真
}else{
    //如果布尔表达式的值为flase
}
```

- if多选择结构

```java
if(布尔表达式1){
    //1的值为true执行代码
}else if(布尔表达式2){
    //2的值为true执行代码
}else if(布尔表达式3){
    //3的值为true执行代码
}else{
    //如果以上布尔表达式不为true执行代码
}
```

- switch多选择结构

```java
switch(expression){
    case value:
        //语句
        break;
       
    case value:
        //语句
        break;
        
    default://可选
        //语句
     
}
```

没写一个`case`，要把`break`加上，防止`break`穿透现象。  

 ### 循环结构

#### while循环

```java
while(布尔表达式){
    //循环内容
}
```

#### do....while 循环

`do while`循环至少会执行一次

```java
do{
    //代码语句
}while(布尔表达式);
```

#### for循环

```java
for(初始化;布尔表达式;更新){
    //代码语句
}
```

for循环语句是支持迭代的一中通用结构，是最有效、最灵活的循环结构。  

​      

#### 增强for循环

```java
for(声明语句:表达式){
    //代码句子
}
```

```java
package com.kuang.struct;

public class ForDemo05 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50}; //定义一个数组

        for (int x : numbers) {
            System.out.println(x);
        }

    }
}
```

#### break && continue

`break`在任何循环语句的主体部分，用于强行退出循环，不执行循环中剩余的语句。  

 ```java
package com.kuang.struct;

public class BreakDemo01 {
    public static void main(String[] args) {
        int i =0;
        while(i<100){
            i++;
            System.out.println(i);
            if(i==30){
                break;
            }
        }
    }
}
 ```

`continue`语句用在循环语句中，用于终止某次循环，即跳过循环体中尚未执行的语句，接着进行是否执行下一次循环的判定。  

```java
package com.kuang.struct;

public class ContinueDemo01 {
    public static void main(String[] args) {
        int i = 0;
        while(i<100){
            i++;
            if(i%10==0){
                System.out.println();
                continue;
            }
            System.out.print(i+"\t");
        }
    }
}
```

### 

## 方法

Java方法是语句的集合，他们在一起执行一个功能。  

命名规则：首字母小写，后面驼峰

- 方法是解决一类问题的步骤的有序组合
- 方法包含于类或对象中国
- 方法在程序中被创建，在其他地方被引用

> 设计方法的原则：一个方法只完成一个功能，有利于我们后期拓展

  

### 方法的定义

```java
修饰符 返回值类型  方法名(参数类型 参数名){
    ...
    方法体
    ...
    return 返回值;
}
```

```java
//实例代码

package com.kuang.method;

public class Demo02 {
    public static void main(String[] args) {
        int max = max(10,10);
        System.out.println(max);
    }

    //比大小
    public static int max(int num1,int num2){

        int result = 0;

        if(num1 == num2){
            System.out.println("num1==num2");
            return num1; //终止方法
        }



        if(num1 > num2){
            result = num1;
        }else{
            result = num2;
        }
        return result;
    }
}

```

### 方法的重载

重载就是在一个类中，有相同的函数名称，但形参不同的函数。

- 方法名称必须相同
- 参数列表必须不同



### 可变参数

- 在方法声明中，在指定参数类型后加一个省略号
- 一个方法只能指定一个可变参数，且必须是方法的最后一个参数，任何普通的参数必须在它之前声明

```java
//示例代码

package com.kuang.method;

public class Demo04 {
    public static void main(String[] args) {
        Demo04 demo04 = new Demo04();
        demo04.test(1,2);
    }

    public void test(int... i){//本质是个数组
        System.out.println(i[0]);
        System.out.println(i[1]);
    }
}
```

### 递归  

递归就是自己调用自己。  

递归结构包括两个部分：

- 递归头：什么时候不调用自身方法，如果没有头，将陷入死循环。  
- 递归体：什么时候需要调用自身方法  

```java
//示例代码
package com.kuang.method;
//容易造成栈溢出，能不用尽量不用
public class Demo06 {
    public static void main(String[] args) {
        System.out.println(f(6));
    }

    public  static  int f(int n){
        if(n==1 || n==0){
            return 1;
        }else{
            return n*f(n-1);
        }
    }
}
```

## 作业（总结一下前面的内容）

### 需求

1. 传入两个参数
2. 传入一种计算方法
3. 用`switch`选择计算方法实现计算器功能

```java
package com.kuang.method;

import java.util.Scanner;

public class HomeworkCalculator {
    public static void main(String[] args) {
        while(true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter an number: ");
            double sa = scanner.nextDouble();
            System.out.println("Please enter another number: ");
            double sb = scanner.nextDouble();

            System.out.println("Please enter the method ");
            String sc = scanner. next();

            switch (sc){
                case "+":
                    System.out.println(add(sa,sb));
                    break;
                case "-":
                    System.out.println(sub(sa,sb));
                    break;
                case "*":
                    System.out.println(ride(sa,sb));
                    break;
                case "/":
                    System.out.println(div(sa,sb));
                    break;
            }
        }

    }

    public static double add(double a,double b){
        return a+b;
    }

    public static double sub(double a,double b){
        return a-b;
    }

    public static double ride(double a,double b){
        return a*b;
    }
    public static double div(double a,double b){
        return a/b;
    }
}
```

## 数组

数组是相同类型数据的有序集合。

数组描述的是相同类型的若干数组，按照一定的先后次序排列组合而成。  

### 声明与创建

1. 首先必须声明数组变量，才能在程序中使用数组。  

```java
dataType[] arrayRefVar; // 首选的方法
dataType arrayRefVar[]; //效果相同，但不是首选方法
```

2. Java语言中使用`new`来创建数组  

```java
dataType[] arrayRefVar = new dataType[arraySize];
```

### Java内存分析

- 堆
  - 存放`new`的对象和数组
  - 可以被所有的线程共享，不会存放别的对象引用
- 栈
  - 存放基本变量类型（会包含这个基本类型的具体数值）
  - 引用对象的变量（会存放这个引用在堆里面的具体地址）

#### 数组的三种初始化

- 静态初始化

```java
int[] a = {1,2,3};
Man[] mans = {new Man(1,1),new Man(2,2)};
```

- 动态初始化

```java
int[] a = new int[2];
a[0] = 1;
a[1] = 2;
```

- 数组的默认初始化
  - 数组是引用类型，它的元素相当于类的实例变量，因此数字一经分配空间，其中的每个元素也被按照实例变量同样的方式被隐式初始化。

### 数组使用

#### For-Each循环

```java
//示例代码
for(int array:arrays){
           System.out.println(array);
}
```

### 数组作为参数传入 && 数组作为结果传出

```java
//示例代码
 //反转数组
    public static  int[] reverse(int[] arrays){
        int[] result = new int[arrays.length];
        for (int i = 0,j = arrays.length-1; i < arrays.length; i++,j--) {
            result[j] = arrays[i];
        }
```

### 多维数组

多维数组可以看成是数组的数组。

```java
int a[][] = new int[2][5];
```

```java
//遍历多维数组
for(int i = 0;i<array.length;i++){
            for(int j = 0;j<array[i].length;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.print("\n");
        }
```

### Arrays类

```java
//示例代码
		System.out.println(Arrays.toString(a));
        Arrays.sort(a);//升序排序
        System.out.println(Arrays.toString(a));

        Arrays.fill(a,2,4,0);
        System.out.println(Arrays.toString(a));
```

### 冒泡排序

1.比较数组中，两个相邻的元素，如果第一个比第二个数大，就交换他们的位置。

2.每一次比较，都会产生出一个最大，或者最小的数字

3.下一轮则，可以少一次排序。  

 ```java
package com.kuang.array;

import java.util.Arrays;

public class ArrayDemo07 {
    public static void main(String[] args) {
        int[] a = {1,4,6,3,7,4,8};
        int[] sort = sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static int[] sort(int[] array){
        //临时变量
        int temp =0;

        //外层循环，判断我们这个要走几次
        for(int i=0; i<array.length-1; i++){

            boolean flag = false;//通过flag标志位减少没有意义的比较


            //内层循环，比较判断两个数，如果第一个数，比第二个大，则交换位置
            for(int j=0; j<array.length-1-i; j++){
                if(array[j+1] < array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if(flag==false){
                break;
            }

        }
        return array;
    }
}
 ```

### 稀疏数组

当一个数组中大部分元素为0，或者为同一值的数组时，可以使用稀疏数组来保存该数组。  

稀疏数组的处理方式是:

- 记录数组一共有几行几列，有多少个不同值
- 把具有不同值的元素和行列及值记录在一个小规模的数组中，从而缩小程序的规模

```java
//示例代码
package com.kuang.array;

public class ArrayDemo08 {
    public static void main(String[] args) {
        //1、创建一个二位数组11*11  0:没有棋子  1.黑棋 2.白棋
        int[][] array1 = new int[11][11];
        array1[1][2] = 1;
        array1[2][3] = 2;
        //输出原始的数组
        System.out.println("输出原始的数组： ");

        for(int[] ints : array1){
            for(int anInt : ints){
                System.out.print(anInt+"\t");
            }
            System.out.print("\n");
        }

        //转换为稀疏数组保存
        //获取有效值的个数

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(array1[i][j]!=0){
                    sum++;
                }
            }

        }
        System.out.println("有效值的个数："+sum);

        //2.创建一个稀疏数组
        int[][] array2 = new int[sum+1][3];
        array2[0][0] = 11;
        array2[0][1] = 11;
        array2[0][2] = sum;

        //遍历二维数组，将非零的值存放到稀疏数组中
        int count = 0;
        for(int i = 0; i < array1.length; i++){
            for(int j = 0; j < array1[i].length; j++){
                if(array1[i][j]!=0){
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = j;
                    array2[count][2] = array1[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println("稀疏数组： ");
        for(int i = 0; i < array2.length ; i++){
            System.out.println(array2[i][0]+"\t"
                    +array2[i][1]+"\t"
                    +array2[i][2]+"\t");
        }

        System.out.println("======================");
        System.out.println("还原稀疏数组");
        //1.读取稀疏数组

        int[][] array3 = new int[array2[0][0]][array2[0][1]];

        //给其中的元素还原值

        for (int i = 1; i < array2.length; i++){
            array3[array2[i][0]][array2[i][1]] = array2[i][2];
        }

        //打印
        for(int[] ints : array3){
            for(int anInt : ints){
                System.out.print(anInt+"\t");
            }
            System.out.print("\n");
        }

    }
}

```

## 面向对象编程

- 面向对象思想
  - 物以类聚，分类的思维方式，思考问题首先会想解决问题需要哪些分类，然后对这些分类进行单独思考。最后，才对某个分类下的细节进行面向过程的思索。
  - 面向对象适合处理复杂的问题，适合处理需要多人协作的问题

- 对于描述复杂的事物，为了从宏观上把握、从整体上合理分析，我们需要使用面向对象的思路来分析整个系统。但是，具体到微观操作，仍然需要面向过程的思路去处理。  

### 什么是面向对象

- 面向对象的本质：以类的方式组织代码，以对象来组织（封装）数据
- 抽象
- 三大特性：
  - 封装
  - 继承
  - 多态

### 方法回顾

```java
package com.oop.demo01;

public class Demo02 {
    public static void main(String[] args) {

        //静态方法 static
//        Student.say();

        //非静态方法
        //实例化这个类 new
        //对象类型   对象名 = 对象值
        Student student = new Student();
        student.say();
    }


    // 有static的方法和类一起加载
    public  void   a(){
        b();
    }

    //类实例化后 才存在
    public void b(){

    }
}
```

两个普通方法，都为静态或者都不为静态的时候才能互相调用，因为有`static`的方法跟类一起加载，而非静态的方法只有**类实例化**后才存在，存在的方法无法调用不存在的方法。

```java
package com.oop.demo01;

//值传递
public class Demo04 {
    public static void main(String[] args) {
        int a =1;
        System.out.println(a);
        change(a);
        System.out.println(a);
    }

    //返回值为空
    public static void change(int a){
        a = 10;
    }
}
```

```java
package com.oop.demo01;

//引用传递： 对象，本质还是值传递
public class Demo05 {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.name);//null

        change(person);
        System.out.println(person.name);
    }

    public static void change(Person person){
        //person是一个对象，这是一个具体的人，可以改变属性
        person.name = "404player";
    }
}

//定义了一个Person类，有一个属性：name
class  Person{
    String name;
}
```

值传递和引用传递要分清楚，**实例1**中只是将`a`的值传递给了方法，所以调用方法后`a`的值并不会发生变化。  

而**实例2**传递的是一个实例对象，所以调用方法后属性的值可以被改变。    

### 类与对象的创建

类是一种抽象的数据类型，它是对某一类事物整体描述/定义，但是并不能代表某一个具体的事物。  

- 创建类

```java
package com.oop.demo02;
//学生类
public class Student {
    //属性：字段
    String name;//null
    int age;//0


    //方法
    public void study(){
        System.out.println(this.name+"在学习");
    }
}
```

- 实例化对象

```java
    public static void main(String[] args) {

        //类：抽象的，需要实例化为对象
        //类实例化之后会返回一个具体的对象
        //student对象就是一个Student类的具体实例

        Student xiaoming = new Student();
        Student xiaohong = new Student();

        xiaoming.name = "xiaoming";
        xiaoming.age = 3;
        System.out.println(xiaoming.name);

        System.out.println(xiaohong.name);
        System.out.println(xiaohong.age);
    }
}
```

### 构造器的使用

类中的构造器也称为构造方法，是在进行创建对象的时候必须调用的。并且构造器有一下两个特点：

- 必须和类的名字相同
- 必须没有返回值类型

构造器的作用：

- new 本质在调用构造器
- 初始化对象的值
- 定义有参构造后，想要使用无参构造，显示的定义一个无参构造

```java
// 生成构造器
package com.oop.demo02;

public class Person {

    //一个类即使什么都不写，他也会存在一个方法
    //显式的定义构造器
    String name;

    //实例化初始值
    // 1.使用new关键字，必须要有构造器
    // 2.用来初始化值
//    public Person(){
//        this.name = "404player";
//    }


    public  Person(){

    }

    //有参构造:一旦定义了有参构造，无参就必须显示定义
    public Person(String name){
        this.name = name;
    }


    //alt+insert 生成构造器
}
```

### 封装

- 该露的露，改藏的藏  
  
  - 程序追求"高内聚，低耦合"。高内聚就是类的内部数据操作细节自己完成，不允许外部干涉；低耦合，仅暴露少量的方法给外部使用
- 封装
  
  - 通常，应禁止直接访问一个对象中数据的实际表示，而应通过操作接口来访问。这称为信息隐藏。
- 一句话，属性私有，get/set

  

```java
//封装类
package com.oop.demo04;

public class Student {

    private String name;//名字
    private int id;//学号
    private char sex;//性别
    private int age;//年龄

    //提供一些可以操作这些属性的方法
    //提供一些public 的get、set方法

    //get 获得这个数据
    public String getName(){
        return this.name;
    }

    //set 给这个数据设置值
    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>120 || age<0) {
            this.age = 3;
        }else{
            this.age = age;
        }
    }


    //学习（）
    //睡觉（）
}
```

```java
#//get set
package com.oop.demo04;

/*
1.提高程序的安全性，保护数据
2.隐藏代码的实现细节
3.统一接口
4.系统可维护性增加了
 */

public class Application {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("404player");
        String name = s1.getName();

        System.out.println(name);

        s1.setAge(999);
        System.out.println(s1.getAge());

    }
}

```

### 继承

- 继承的本质是对某一批类的抽象。
- 继承是类与类之间的一种关系，除此之外，类与类之间的关系还有依赖、组合、聚合
- 继承关系的两个类，一个为子类（派生类），一个为父类（基类）。子类继承父类，使用关键字`extends`来表示。
- 子类和父类之间，从意义上将应该具有`is a `的关系

- 在`Java`中所有的类，都默认直接或间接继承`Object`类

- `Java`中只有单继承，没有多继承

#### 注意的点：

- `super`调用父类的构造方法，必须在构造方法的第一个

- 子类有一句隐藏代码`super()`，默认调用父类的无参构造
- 要是父类没有无参构造，子类也无法写无参构造
- 调用父类的构造器，必须要在子类构造器的第一行
- 子类里要不调用子类`this()`，要不调用父类`super()`  

#### 示例代码

```java
//Person
package com.oop.demo05;

//Person  人
public class Person {

    //private
    //default 默认的
    //protected  受保护的
    //public
    //私有的东西无法继承




    protected  String name = "404player";

    public  void print(){
        System.out.println("Person");
    }

    }

```

```java
//Student
package com.oop.demo05;


//学生   is   人
public class Student extends Person {
    //Ctrl + H  查看类的树结构
    //要么调用父类super()，要么调用子类this()
    //隐藏代码，调用父类的无参构造
    super(); //调用父类的构造器，必须要在子类构造器的第一行
    public Student() {
        System.out.println("Student无参构造执行了");
    }

    private String name = "404player";

    public void print(){
        System.out.println("Student");
    }

    public void test(String name){
        System.out.println(name);
        System.out.println(this.name);//调用本类方法
        System.out.println(super.name);//调用父类方法
    }

    public void test1(){
        print();
        this.print();
        super.print();
    }

}
```

#### 方法重写

- 前提：需要有继承关系，子类重写父类的方法
- 方法名必须相同
- 参数列表必须相同
- 修饰符：范围可以扩大  public>protected>default>priva
- 抛出异常：范围，可以被缩小，但是不能被扩大   	ClassNotException  -->Exception

为什么需要重写：

- 父类的功能子类不一定需要或者不一定满足
- Alt +Insert (Overload)

```java
//父类
package com.oop.demo05;

//重写都是方法的重写，与属性无关
public class B {

    public void test(){
        System.out.println("B=>test()");
    }
}
```

```java
//子类
package com.oop.demo05;

public class A  extends  B{

    @Override
    public void test() {
        System.out.println("A=>test()");
    }
}
```

```java
//印证重写
package com.oop.demo05;

public class Application {
    //静态方法和非静态的方法区别很大
        //静态方法：只和左边有关
        //非静态：才能选择重写
    public static void main(String[] args) {

        //方法的调用只和左边，定义的数据类型有关
        A a = new A();
        a.test();

        //父类的引用指向子类
        B b = new A();//子类重写了父类的方法，只和非静态有关
        b.test();

    }
}
```

**如果两个类都写成静态`static`，就不能重写。方法的定义只跟左边定义的数据类型有关**  

## 多态

- 动态编译
- 即同一方法可以根据发送对象的不同而采用不同的行为方式
- 一个对象的实际类型是确定的，但可以指向对象的引用的类型有很多

### 多态存在的条件

- 有继承关系
- 子类重写父类方法
- 父类引用指向子类对象  

```java
//父类
package com.oop.demo06;

public class Person {

    public void run(){
        System.out.println("run");
    }
}
```

```java
//子类
package com.oop.demo06;

public class Student extends Person {

    @Override
    public void run() {
        System.out.println("son");
    }

    public void eat(){
        System.out.println("eat");
    }
}
```

```java
//主程序
package com.oop.demo06;

public class Application {

    public static void main(String[] args) {
        //一个对象的实际类型是确定的
        //new Student
        //new Person

        //可以指向的引用类型就不确定了

        //父类的引用指向子类
        //Student 能调用的方法都是自己的或者继承父类的
        //Person 可以指向子类，但是不能调用子类独有的
        Student s1 = new Student();
        Person s2 = new Student();
        Object s3 = new Student();


        //对象能执行哪些方法，主要看对象左边的类型，和右边关系不大
        s1.run();//子类重写了父类的方法，执行子类的方法  son
        s2.run();//执行子类的方法  son
        s1.eat();//s2没法调用eat()
        ((Student)s2).eat();//类型强制转换
    }
}
```

### 多态注意事项

1. 多态是方法的多态，属性没有多态
2.  有父子类关系才能进行类型转换 
3. ClassCastException为类型转换异常
4. 存在条件：继承关系；方法需要重写；父类引用指向子类对象   father f1 = new Son()；
5.  `static`,`final`，`private`方法不能被重写

### `instanceof` 和类型转换    

### `instanceof`

  ```java
System.out.println(X instanceof Y); 

//能不能编译通过取决于X的类型与Y的类型是否存在关系
//Flase还是True取决于X指向的类型与Y的类型是否存在关系
  ```

```java
//示例代码
public class Application {
    public static void main(String[] args) {

        //Object > String
        //Object > Person > Teacher
        //Object > Person > Student
        Object object = new Student();
        System.out.println(object instanceof Student);
        System.out.println(object instanceof Person);
        System.out.println(object instanceof Teacher);
        System.out.println(object instanceof  Object);
        System.out.println(object instanceof String);

        System.out.println("===================================");

        Person person = new Student();
        System.out.println(person instanceof Student);
        System.out.println(person instanceof Person);
        System.out.println(person instanceof  Object);
        System.out.println(person instanceof Teacher);
        //System.out.println(person instanceof String);//编译报错！
        //要两个对象有所联系才能一起比较

        System.out.println("==================================");

        Student student = new Student();
        System.out.println(student instanceof Student);
        System.out.println(student instanceof Person);
        System.out.println(student instanceof  Object);
        //System.out.println(student instanceof Teacher);

    }


}
```

### 类型转换

在基本类型中，高转低需要强制转换，低转高不需要强制，类比对象的类型转换。  

在对象的类型转换中，父类转子类需要强制转换，子类转父类不需要。  

```java
//实例：父类转子类
public class Application {
    public static void main(String[] args) {

        //基本类型的转化    高---->低   类比    父---->子
        Person student = new Student();

        //将这个对象转化为Student类型，我们就可以使用Student类型的方法了
        ((Student)student).eat();

    }
```

```java
//实例： 子类转换成父类
public class Application {
    public static void main(String[] args) {

        Student student = new Student();
        student.eat();
        Person person = student;
        //person.eat();并不能调用
        //子类转换为父类，可能会丢失自己本来的一些方法
        

    }
```

### `static`关键字

- 静态方法，静态对象跟着类一起加载，可在类中直接被调用，非静态要实例化后才存在
- 可静态导入包，这样不用每次使用方法的时候都写一长串
- 一个类要是被定义为`final`，就无法被继承

## 抽象类

加了`abstract`关键字的类，就是抽象类  

```java
//示例代码

package com.oop.demo08;

//abstract 抽象类   类  extends  单继承      （接口可以多继承）
public abstract class Action {

    //约束~有人帮我们实现~
    //abstract 抽象方法,只有方法名字，没有方法的实现

    public abstract void doSomething();

    //1. 不能new这个抽象类，只能靠子类去实现它：约束！
    //2. 抽象类可以写普通方法，抽象方法必须在抽象类中
    //抽象的抽象

}
```

- 抽象意思就是等待实现，只有名字，还没有实现
- 抽象类不能`new`创建，只能通过子类去实现它，相当于一个约束
- 抽象类可以写普通方法，抽象方法必须在抽象类中
- 抽象类的方法，继承他的子类，必须有实现它的方法（重写），除非子类也是抽象的
- 抽象类用于提供一个可拓展性的类，提高开发效率

## 接口

接口就是一种规范，本质是契约，类比法律  

### 接口的作用

1. 约束
2. 定义一些方法，让不同的人实现
3. 定义的方法都是`public abstract`
4. 定义的属性都是`public static final`
5. 接口不能被实例化，接口中没有构造方法
6. 可以实现多继承
7. 要实现接口必须重写里面的方法

```java
//示例代码
//接口代码
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
```

```java
//示例代码
//实现类代码
package com.oop.demo09;

import java.sql.Time;

//类 可以实现接口 implements  接口
//实现接口的类，就需要重写接口中的方法
//多继承
public class UserServiceImpl implements UserService,TimeService {
    @Override
    public void add(String name) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void update(String name) {

    }

    @Override
    public void query(String name) {

    }

    @Override
    public void timer() {

    }
}
```



## 内部类

内部类就是在一个类的内部再定义一个类。  

```java
//示例代码
package com.oop.demo10;


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

}
```

- 非静态的内部类可以调用外部类的方法和属性
- 方法里也可以定义内部类，称为局部内部类
- 一个`Java`类中可以有很多个class类，但是只能有一个`public class`类

```java
//实例代码
package com.oop.demo10;

public class Test {
    public static void main(String[] args) {
        //没有名字初始化类，不用将实例保持到变量中

        new Apple().eat();

        new UserSevice(){
            @Override
            public void hello() {

            }
        };
    }
}

class Apple{
    public  void eat(){
        System.out.println("1");
    }
}

interface UserSevice{
    void hello();
}
```

- 没有名字也能实例化对象，不用将实例保持到变量中
- 也可以用匿名的方式实现接口
- 不建议这么写程序，只是介绍一种方法  

## 异常机制

英文名为`Exception`，意思为例外  

异常指程序运行中出现的不期而至的各种状况，如：文件找不到、网络连接失败、非法参数等

异常发生在程序运行期间，它影响了正常的程序执行流程。  

### 异常分类

- 检查性异常：最具代表性的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。例如要打开一个不存在的文件时，一个异常就发生了。
- 运行时异常：运行时异常是可能被程序员避免的异常。例如，两个相互调用的函数
- 错误`ERROR`：错误不是异常，而是脱离程序员控制的问题，如栈溢出

### 异常体系结构

`Java`把对象当作对象来处理，并定义一个基类`java.lang.Throwable`作为所有异常的超类。  

在`Java API`中一定定义了很多异常类，这些异常类分为两大类，错误`Error`和异常`Exception`

#### Error

`Error`类对象由Java虚拟机生成并抛出。大多数错误与代码编写者所执行的操作无关。  

#### Exception

在`Exception`分支中有一个重要的子类`RuntimeException`（运行时异常）

一般由程序逻辑错误引起，是不检查异常，程序中可以选择捕获处理，也可以不处理

### 异常处理机制

- 抛出异常
- 捕获异常
- 异常处理五个关键字：`try`、`catch`、`finally`、`throw`、`throws`

```java
//示例代码
public static void main(String[] args) {

        int a = 1;
        int b = 0;

        try{
            //try监控区域
            System.out.println(a/b);
        }catch (ArithmeticException e){//catch 捕获异常
            System.out.println("程序出现异常，变量b不能为0");
        }finally {//处理善后工作
            System.out.println("finally");
        }

        //finally 可以不要finally，假设IO,资源关闭
        
    }
```

- `try`用于监控异常，相当于一个监控区域，出现在这个区域的异常都能被监控到
- `catch`用于异常捕获，匹配相应的异常。最大的范围为`throwable`，包括所有的异常和错误
- `finally`是用于处理善后工作的，比如说IO流错误，可以用于资源的关闭与释放。这个代码块里的代码无论是否进行异常捕获，都会执行

```java
//示例代码
package com.exception;

public class Test {
    public static void main(String[] args) {

        int a = 1;
        int b = 0;

        try{
            //try监控区域
           new Test().a();
        }catch (Error e){//catch 捕获异常
            System.out.println("Error");
        }catch (Exception e){
            System.out.println("Exception");
        }catch (Throwable t){
            System.out.println("Throwable");
        } finally {//处理善后工作
            System.out.println("finally");
        }

        //finally 可以不要finally，假设IO,资源关闭

    }

    public void a(){
        b();
    }

    public void b(){
        a();
    }
}
```

捕获多个异常的时候要遵循从小到大的原则进行捕获，否则程序报错

选中相应语句，按下`Ctrl+Alt+t`，可以自动生成捕获异常语句

```java
//示例代码
package com.exception;

import sun.text.resources.th.CollationData_th;

public class Test {
    public static void main(String[] args) {

        int a = 1;
        int b = 0;
        try {
            new Test().test(a,b);
        } catch (ArithmeticException e){
            e.printStackTrace();
        }


    }

    //假设这个方法中，处理不了这个异常，方法上抛出异常
    public void test(int a,int b) throws ArithmeticException{
        if(b==0){//throw  throws
            throw new ArithmeticException();//主动抛出异常,一般在方法中使用
        }
        System.out.println(a/b);
    }

}
```

### 自定义异常

使用Java内置的异常类可以描述在编程时出现的大部分异常情况。除此之外，用户还可以自定义异常。  

用户自定义异常类，只需要继承`Exception`类即可。  

 ```java
//异常类
package com.exception.demo02;

//自定义的异常类
public class MyException extends Exception {

    //传递数字>10
    private  int detail;

    public MyException(int a) {
        this.detail = a;
    }

    //toString:异常的打印信息


    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
 ```

```java
//调用异常类
package com.exception.demo02;

public class Test {

    //可能会存在异常的方法
    static  void test(int a) throws MyException{


        System.out.println("传递的参数为"+a);
        if(a>10){
            throw  new MyException(a);
        }

        System.out.println("OK");

    }

    public static void main(String[] args) {
        try {
            test(11);
        }catch (MyException e){
            //增加一些处理异常的代码块
            System.out.println("MyException=>"+e);
        }
    }
}
```

- 处理运行时异常时，采用逻辑去合理规避同时辅助`try-catch`处理
- 在多重`catch`块后面，可以加一个`catch`(`Exception`)来处理可能会被遗漏的异常
- 对于不确定的代码，也可以加上`try-catch`，处理潜在的异常（`Alt+Enter`可以看到报错提示）
- 尽量去处理异常，切忌只是简单地调用`printStackTrace()`去打印输出
- 具体如何处理异常，要根据不同地业务需求和异常类型去决定
- 尽量添加`finally`语句块去释放占用的资源

## 集合

`Collection`接口

- 定义的是所有单列集合中共性的方法
- 所有的单列集合都可以使用的共性的方法

`List`接口

- 有序的集合（存储和取出元素顺序相同）
- 允许存储重复的元素
- 有索引，可以使用普通的`for`循环遍历

`Set`接口

- 不允许存储重复元素
- 没有索引（不能使用普通的for循环）

集合框架的学习方式：

- 学习顶层：学习顶层接口/抽象类中共性的方法，所有的子类都可以使用
- 使用底层：底层不是接口就是抽象类，无法创建对象使用，需要使用底层的子类创建对象使用

### Collection常用功能

`Collection`是所用单列集合的父接口，定义了一些通用方法。这些方法可以用于操作所有的单列集合。

- `public boolean add(E e)`: 把给定的对象添加到当前集合中
- `public void clear()`: 清空集合中所有的元素
- `public boolean remove(E e)`: 把给定的对象在当前集合中删除
- `public boolean contains(E e)`: 判断当前集合是否为空
- `public boolean isEmpty():` 判断当前集合是否为空
- `public int size()`: 返回集合中元素的个数
- `public Object[] toArray():` 把集合中的元素，存储到数组中

```java
//示例代码
package com.collection.total;

import java.util.ArrayList;
import java.util.Collection;

public class Demo01 {
    public static void main(String[] args) {
        //创建集合，可以使用多态
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);//重写了toString方法


        /*
        boolean返回值一般不用接收
         */
        boolean b1 = coll.add("张三");
        System.out.println(b1);
        System.out.println(coll);
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        coll.add("田七");
        System.out.println(coll);

        /*
        public boolean remove()，集合中存在元素，删除元素，返回true
        集合中不存在元素，删除失败，返回false
         */
        boolean b2 = coll.remove("赵六");
        System.out.println("b2: "+b2);
        boolean b3 = coll.remove("赵四");
        System.out.println("b3: "+b3);

        boolean b4 = coll.contains("李四");
        System.out.println(b4);

        boolean b5 = coll.isEmpty();
        System.out.println(b5);//集合不为空返回false

        int size = coll.size();
        System.out.println("size: "+size);

        //public Object[] toArray
        //集合元素是多种多样的，变为数组要变成Object[]
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        //public void clear():清空集合中所有元素，但是不删除集合，集合还存在
        coll.clear();
        System.out.println(coll);
        System.out.println(coll.isEmpty());
    }
}
```



### Iterator迭代器

在程序开发中，经常需要遍历集合中的所有元素。`Iterator`主要用于迭代访问`Collection`中的元素，因此`Iterator`对象也被称为迭代器。

- 迭代的概念：`Collection`集合元素的通用获取方式。在取元素之前先要判断集合中有没有元素，如果有，就把这个元素取出来，继续做判断，如果还有就再取出来。一直把集合中的元素全部取出。这种取出方式专业术语称为迭代

- 常用方法
  - `hasNext()`：如果仍有元素可以迭代，则返回true
  - `next()`:返回迭代的下一个元素
  - `remove()`:从迭代器指向的`collection`中移除迭代器返回的最后一个元素

- 使用步骤

  1. 使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口来接收(多态)
  2. 使用Iterator接口中的方法`hasNext`判断还有没有写一个元素
  3. 使用Iterator接口中的方法`next`取出集合中的下一个元素

  ```java
  //示例代码
  package com.collection.iterator;
  
  import java.util.ArrayList;
  import java.util.Collection;
  import java.util.concurrent.Phaser;
  
  /*
      java.util.iterator迭代器：遍历集合中的元素
      Iterator迭代器，是一个接口。我们无法直接使用，需要使用Iterator接口的实现类，获取实现类的方式比较特殊
      Collection接口中有一个方法，叫iterator()，返回的就是迭代器的实现类对象
   */
  public class Iterator {
      public static void main(String[] args) {
          //创建一个集合对象
          Collection<String> coll = new ArrayList<>();
          //往集合中添加元素
          coll.add("姚明");
          coll.add("科比");
          coll.add("麦迪");
          coll.add("詹姆斯");
          coll.add("艾弗森");
  
          /*
          Iterator<E>接口也是有泛型的，迭代器的泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型
           */
          java.util.Iterator<String> it = coll.iterator();
          boolean b = it.hasNext();
          System.out.println(b);
          while(it.hasNext()) {
              String s = it.next();
              System.out.print(s + "\t");
          }
              System.out.println("\n"+"----------------------");
              for(java.util.Iterator<String> it2 = coll.iterator();it2.hasNext();){
                  String e = it2.next();
                  System.out.println(e);
              }
          }
  
      }
  ```

- 迭代器的实现

  1. 获取迭代器的实现类对象，并且把指针指向集合的-1索引
  2. 判断集合中是否有下一个元素
  3. `it.next()`做了两件事情
     1. 取出下一个元素
     2. 会把指针向后移动一位

  

### 泛型

在前面的学习中，我们都知道集合中是可以存放任意对象的。只要把对象存储集合后，那么这时他们都会被提升为`Object`类型。当我们再取出每一个对象，并且进行相应的操作，这时必须采用类型转换。

- 泛型： 可以看作一种未知的数据类型，当我们不知道使用什么数据类型，可以使用泛型

泛型也可以看成是一个变量，用来接收数据类型

- `E e`:Element元素
- `T t`:Type元素

`ArrayList`集合在定义的时候，不知道集合中都会存储什么类型的数据，所以类型使用泛型

```java
public class ArrayList<E>{
    public boolean add(E e){}
    public E get(int index){}
}
```

创建集合对象的时候，就会确定泛型的数据类型

```java
ArrayList<String> list = new Arrayist<String>();
```

这个时候`String`就会传递给`E`，会把数据类型当作泛型传递

```java
public class ArrayList<String>{
    public boolean add(String e){}
    public String get(int index){}
}
```

> 总结：不确定数据类型的时候可以使用类型，创建对象的时候会赋值数据类型

​                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     

#### 定义含有泛型的类

定义一个含有泛型的类，模拟`ArrayList`集合

创建对象的时候确定泛型的数据类型

```java
//实例代码
package com.collection.generic;

public class GenericClass<E> {

    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
```

#### 定义和使用含有泛型的方法

定义含有泛型的方法： 泛型定义在方法的修饰符和返回值类型之间

```
修饰符 <泛型> 返回值类型 方法名 (参数列表<使用泛型>){
	方法体
}
```

含有泛型的方法，在调用方法的时候确定泛型的数据类型

```java
//定义方法
package com.collection.generic;

public class GenericMethod {


    public <M> void method01(M m){
        System.out.println(m);
    }

    public static <S> void method02(S s){
        System.out.println(s);
    }
}
```

```java
//调用方法
package com.collection.generic;

import sun.net.www.content.text.Generic;

/*
    测试含有泛型的方法
 */
public class Demo03GenericMethod {
    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
        //调用含有泛型的方法
        gm.method01(10);
        gm.method01("abc");
        gm.method01(8.8);
        gm.method02("静态方法，不建议创建对象使用");

        GenericMethod.method02(123);
    }
}
```

#### 定义和使用含有泛型的接口

两种使用方式：

- 定义接口的实现类，实现接口 ，指定接口的泛型

  `Scanner`类实现了`Iterator`接口，并指定接口的泛型为`String`，所以重写的`next`方法泛型默认就是`String`

- 接口使用什么泛型，实现类就使用什么泛型，类跟着接口走，相当于定义了一个含有泛型的类

  

  ```java
  //定义接口
  package com.collection.generic;
  
  public interface GenericInterface<I> {
      public abstract void method(I i);
  }
  ```

  ```java
  //第一种方法定义实现类
  package com.collection.generic;
  
  public class GenericInterfaceImpl1 implements GenericInterface<String> {
      @Override
      public void method(String s) {
          System.out.println(s);
      }
  }
  ```

  ```java
  //第二种方法定义实现类
  package com.collection.generic;
  
  public class GenericInterfaceImpl2<I> implements GenericInterface<I> {
      @Override
      public void method(I i) {
          System.out.println(i);
      }
  }
  ```

  #### 泛型通配符

  

  

