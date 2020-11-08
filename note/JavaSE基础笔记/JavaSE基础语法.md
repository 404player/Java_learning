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

- 定义接口的实现类,实现接口,指定接口的类型

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
//第一种实现方法
package com.collection.generic;

public class GenericInterfaceImpl1 implements GenericInterface<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
```

```java
//第二种实现方法
package com.collection.generic;

public class GenericInterfaceImpl2<I> implements GenericInterface<I> {
    @Override
    public void method(I i) {
        System.out.println(i);
    }
}
```

#### 泛型通配符

当使用泛型类或者接口时，传递的数据中，泛型类型不确定，可以通过通配符`<?>`表示。但是一旦使用泛型的通配符后，只能使用`Object`类中的共性方法，集合中元素自身方法无法使用。

##### 通配符基本使用

**不知道使用什么类型来接收的时候，此时可以使用?，?表示未知通配符**

此时只能接受数据，不能往该集合中存储数据。  

```java
package com.collection.generic;
/*
    泛型的通配符：
        ?:代表任意的数据类型
    使用方式：
        不能创建对象使用
        只能作为方法的参数使用
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Demo05Generic {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(2);

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("a");

        printArray(list01);
        printArray(list02);

    }

    /*
            定义一个方法，能遍历所有类型的Arraylist集合
            这时候我们不知道Arraylist集合使用什么数据类型，可以使用泛型的通配符来接受数据
            注意：
                泛型没有继承概念的
         */

    public static void printArray(ArrayList<?> list){
        //使用迭代器遍历集合
        Iterator<?> it = list.iterator();
        //it.next()方法，取出的元素时Object,可以接受任意的数据类型
        while(it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }
    }
}

```

##### 通配符高级使用

之前设置泛型的时候,实际上时可以任意设置的,只要是类就可以设置,但是在Java的泛型中可以指定一个泛型的上限和下限

泛型的上限:

- 格式: `类型名称 <? extends 类 >  对象名称` 
- 意义: `只能接收该类型及其子类`

泛型的下限:

- 格式: `类型名称 <? super 类> 对象名称`
- 意义: `只能接收该类型及其父类型`

```java
package com.collection.generic;
 
import java.util.ArrayList;
import java.util.Collection;

/*
    泛型的上限： ? extends E 代表使用的泛型只能是E类型的子类或者本身
    泛型的下限： ? super E   代表使用的泛型只能是E类型的父类或者本身
 */
public class Demo06Generic {
    public static void main(String[] args) {
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();

        getElement1(list1);
        getElement1(list2);//报错
        getElement1(list3);
        getElement1(list4);//报错

        getElement2(list1);//报错
        getElement2(list2);//报错
        getElement1(list3);
        getElement2(list4);
        
        /*
            类与类之间是由继承关系的
         */

    }

    public static void getElement1(Collection<? extends Number> coll){}
    public static void getElement2(Collection<? super Number> coll){}
}

```

### 案例介绍

斗地主综合案例:

一: 准备牌 

1. 准备牌: 54张牌存储到一个集合中
2. 特殊牌: 大小王
3. 其他52张牌: 定义一个数组/集合: 存储4种花色。定义一个数组/集合: 存储13个序号
4. 循环嵌套遍历两个数组/集合 , 组装52张牌

二: 洗牌

1. 使用集合工具类Collections的方法
2. `static void shuffle(List<?> list)`使用指定的随机数对指定列表进行替换

三: 发牌

1. 一人17张牌,剩余3张作为底牌 . 一人一张轮流发牌 %3
2. 定义4个集合 ,存储三个玩家的牌和底牌

四. 看牌

1. 直接打印集合,遍历存储玩家和底牌的集合

五: 代码实现

```java
package com.collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
       斗地主综合案例：
       1.准备牌
       2.洗牌
       3.发牌
       4.看牌
    */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //定义一个存储54张牌的ArrayList集合，泛型使用String
        ArrayList<String> poker = new ArrayList<>();

        //定义两个数组，一个数组存储牌的花色，一个数组存储牌的序号
        String[] colors = {"♠","♥","♣","♦"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};

        //先把大王和小王存储到poker集合中
        poker.add("大王");
        poker.add("小王");

        //循环嵌套两个数组，组装52张牌
        for(String number:numbers){
            for (String color : colors) {
                //把组装好的牌存到poker集合中
                poker.add(color+number);
            }
        }
        // System.out.println(poker);

        /*
            2.洗牌
            使用集合的工具类Collections中的方法
            static void shuffle(list<?> list)
         */
        Collections.shuffle(poker);

        /*
            3.发牌
         */
        //定义四个集合，存储玩家的牌和底牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        /*
        遍历poker集合，获取每一张牌
        使用poker集合的索引%3给3个玩家轮流发牌
        剩余3张牌给底牌
         */
        for(int i = 0 ; i < poker.size() ; i++ ){
            //获取每一张牌
            String p = poker.get(i);
            if(i>=51){
                diPai.add(p);
            }else if (i%3==0){
                player01.add(p);
            }else if(i%3==1){
                player02.add(p);
            }else{
                player03.add(p);
            }
        }

        //4.牌
        System.out.println("刘德华"+player01);
        System.out.println("周润发"+player02);
        System.out.println("周星驰"+player03);
        System.out.println("底牌"+diPai);
    }

}

```

## 常见的数据结构

数据存储的常用结构有： 栈、 队列、 数组、 链表和红黑树

栈，队列，数组会了，在这里不多做介绍

### 链表

查询慢： 链表中地址不是连续的，每次查询元素，都必须从头开始查询

增删快： 链表结构，增加/删除一个元素，对链表的整体结构没有影响，所以增删快

链表中每一个元素也称为一个节点，一个节点包含了一个数据源（存储数组），两个指针域

- 单向链表： 链表中只有一条链子，不能保证元素的顺序（存储元素和取出元素的顺序有可能不一致）
- 双向链表： 链表中有两条链子，有一条链子是专门记录元素的顺序，是一个有序的集合

### 红黑树

计算机中的树： 树根、分支、树叶

二叉树： 分支不能超过两个

排序树/查找树： 在二叉树的基础上，元素是有大小顺序的，左子树小，右子树大

红黑树：

- 趋近于平衡树，查询的速度非常快，查询叶子节点最大次数和最小次数不能超过2倍
- 约束条件： 
  - 节点可以是红色或者是黑色的
  - 根节点是黑色的
  - 叶子节点（空节点）是黑色的
  - 每个红色的子节点都是黑色的
  - 任何一个节点到其每一个叶子节点的所有路径上黑色节点数相同

## List集合

`java.util.list`接口继承了`Collection`接口

`List`接口的特点：

- 有序的集合，存储元素和取出元素的顺序是一致的
- 有索引，包含了一些带索引的方法
- 允许存储重复的元素

### LIst特有的方法

- `public void add(int index, E element)` 将指定的元素，添加到该集合中的指定位置
- `public E get(int index)`  返回集合中指定位置的元素
- `public E remove(int index)` 移除列表中指定位置的元素，返回的是被移除的元素
- `public E set(int index, E element)` 用指定元素替换集合中指定位置的元素，返回值是更新前的元素

```java
//实例代码
//简单介绍特有方法
//介绍三种遍历List的方法


package com.collection.list;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


//操作索引的时候一定要注意索引越界异常
//IndexOutOfBoundsException 索引越界异常
//ArrayIndexOutBoundsException 数组索引越界异常

public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合对象，多态
        List<String> list = new ArrayList<>();
        //使用add方法往集合中添加元素
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        //打印集合
        System.out.println(list);//打印[a, b, c, a] 说明重写了toString方法

        //public void add
        list.add(3,"ithema");
        System.out.println(list);

        //public void remove
        String removeE= list.remove(2);
        System.out.println("被移除的元素"+removeE);
        System.out.println(list);

        //public void set
        String setE = list.set(3,"A");
        System.out.println("被替换的元素"+setE);
        System.out.println(list);

        //list集合遍历有三种方式
        //使用普通的for循环
        for (int i = 0; i < list.size(); i++) {
            //public E get(int index)
            String s =  list.get(i);
            System.out.println(s);

        }

        System.out.println("-------------------------");
        //使用迭代器来遍历
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }


        System.out.println("-------------------");
        //使用增强for循环
        for(String s : list){
            System.out.println(s);
        }

    }
}

```

### List的子类

#### ArrayList集合

`java.util.ArrayList`集合数据存储的结构是数组结构。元素增删慢，查找快，由于日常开发中使用最多的功能为查询数据、遍历数据，所以`ArrayList`是最常用的集合。  

底层`add`方法是建立一个新数组`size`加一。再把原数组复制过去，所以不要随便滥用`ArrayList`。

#### LinkedLIst集合

`java.util.LinkedList`集合数据存储的结构是链表结构。方便元素添加、删除的集合。

> LinkedList是一个双向链表

`LinkedList`中找到头和尾非常方便，里面有大量的操作首尾元素的方法

`LinkedList`提供了大量首尾操作的方法

```java


package com.collection.list;
/*
    java.util.LinkedList集合： implements List接口
 */


import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Demo02LinkedList {
    public static void main(String[] args) {
        //show01();
        //show02();
        show03();
    }



    private static void show02(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");

        linked.clear();//清空集合中的元素，在获取集合中的元素时会抛出NoSuchElementException异常

        if(!linked.isEmpty()){
            String first = linked.getFirst();
            System.out.println(first);//a
            String last = linked.getLast();
            System.out.println(last);//c
        }

    }

    private static void show01(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合中添加元素
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);

        //public void addFirst(E e)
        linked.addFirst("www");
        System.out.println(linked);

        //public void push
        linked.push("w3c");
        System.out.println(linked);

        //public void addLast(E e) === public void add(E e)
        linked.addLast("html");
        System.out.println(linked);
    }

    private static void show03(){
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        System.out.println(linked);


        String first =  linked.removeFirst();
        //linked.pop()一样的效果
        System.out.println(first);
        String last =   linked.removeLast();
        System.out.println(last);

        System.out.println(linked);



    }
}
```

#### Vector集合

`Vector`类实现可增长的对象数组，是早期`JDK 1.0`的集合类，所以是单线程的。

而且没法调用迭代器方法。

## Set接口

一个不包含重复元素的`collection`。

### 特点

- 不允许存储重复的元素
- 没有索引，没有带索引的方法，也不能使用普通的`for`循环遍历

### HashSet

特点： 

1. 是一个无序的集合，存储元素和取出元素的顺序有可能不一致
2. 底层是一个哈希表结构，查询的速度非常快。

```java
//实例代码
package com.collection.set;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo01Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        //使用add方法往集合中添加元素
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);
        //使用迭代器遍历Set集合
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            Integer next = it.next();
            System.out.println(next);
        }//输出1 2 3 没按顺序来

        //使用增强for遍历set集合
        System.out.println("------------------------");
        for(Integer i : set){
            System.out.println(i);
        }

    }
}
```

#### 哈希值（HashCode)

哈希值： 是一个十进制的整数， 由系统随机给出（就是对象的地址值，是一个逻辑值，是模拟出来的地址，不是数据实际存储的物理地址）

在`Object`类中有一个方法可以获取对象的哈希值.

`int hashCode()`返回该对象的哈希码值。

`hashCode`方法的源码：

`public native int hashCode();`

`native`： 代表该方法调用的是本地操作系统的方法

```java
//重写一个方法
package com.collection.hashCode;

public class Person {

    //重写hashCode方法

    @Override
    public int hashCode() {
        return 1;
    }
}
```

```java
package com.collection.hashCode;

import java.util.Set;

public class Demo01HashCode {

    public static void main(String[] args) {
        //Person类继承了Object类，所以可以使用Object类的hashCode方法
        Person p1 = new Person();
        int h1 = p1.hashCode();
        System.out.println(h1);//460141958

        Person p2 = new Person();
        int h2 = p2.hashCode();
        System.out.println(h2);//1163157884

        /*
        toString方法:
          return getClass().getName()+"@"+Integer.toHexString(hashCode());
        */

        System.out.println(p1);//com.collection.hashCode.Person@1b6d3586
        System.out.println(p2);//com.collection.hashCode.Person@4554617c

        System.out.println(p1==p2);//flase  重写方法以后，也是flase

        /*
            String类的哈希值
                String类重写Object类的hashCode方法

         */

        String s1 = new String("abc");
        String s2 = new String ("abc");
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354

        System.out.println(s1.hashCode()==s2.hashCode());//true

        System.out.println("重地".hashCode());
        System.out.println("通话".hashCode());//刚好相等

    }
}

```

#### HashSet集合存储数据的结构（哈希表）

`jdk1.8`版本之前： 哈希表=数组+链表

`jdk1.8`版本之后： 哈希表=数组+链表

​								  哈希表= 数组+红黑树（提高查询速度）

**哈希表的特点： 速度快**

数据结构： 把元素进行了分组，（相同哈希值的元素是一组） 链表/红黑树结构把相同哈希值的元素连在一起

如果链表的长度超过八位，那么就会把链表转换为红黑树（提高查询速度）



#### Set集合存储元素不重复的原理

`Set`集合在调用`add`方法的时候，`add`方法调用元素的`hashCode`和`equals`方法，判断元素是否重复

调用`hashCode`看看有没有哈希值的元素，没有加入数组，有的话即为哈希冲突，调用`equals`函数看看两个值相不相同，不同的话就存储。

```java
package com.collection.set;

import java.util.HashSet;
/*
    Set不允许存储重复元素

 */
public class Demo02HashSetSaveString {

    public static void main(String[] args) {
        //创建一个HashSet集合
        HashSet<String> set = new HashSet<>();
        String s1 = new String("abc");
        String s2 = new String("abc");
        set.add(s1);
        set.add(s2);
        set.add("重地");
        set.add("通话");
        set.add("abc");
        System.out.println(set);

    }
}
```



#### HashSet存储自定义类型元素

必须要重写`hashSet`和`equals`方法，否则`equals`默认地比较地址值，而`hashCode`返回的是对象本身的哈希值。

```java
//定义类，重写方法
package com.collection.set;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
```

```java
//示例代码
package com.collection.set;

import java.util.HashSet;

/*
    HashSet存储自定义类型元素

    set集合保证元素唯一：
        存储的元素(String,Integer,....Student,Person...),必须重写hashCode和equal方法

    要求：
        同名同年龄的人，视为同一个人，只能存储一次
 */
public class Demo03HashSetSavePerson {
    public static void main(String[] args) {
        //创建HashSet集合存储Person
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("小美女",18);
        Person p2 = new Person("小美女",18);
        Person p3 = new Person("小美女",19);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        System.out.println(p1==p2);//flase
        System.out.println(p1.equals(p2));//flase 没有重写比较的是两个对象的地址值
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
    }

}
```

#### LinkedHashSet集合

`java.util.LinkedHashSet`集合继承了`HashSet`集合

`LinkedHashSet`集合特点：

1.  底层是一个哈希表+链表（记录元素的存储数据），保证元素有序

```java
package com.collection.set;


import java.util.HashSet;

import java.util.LinkedHashSet;

public class Demo04LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("www");
        set.add("abc");
        set.add("abc");
        set.add("itcast");
        System.out.println(set);//[abc, www, itcast] 无序，不允许重复

        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("www");
        linked.add("abc");
        linked.add("abc");
        linked.add("itcast");
        System.out.println(linked);//有序的集合
    }
}
```

## Collections集合工具类的方法

- `java.utils.Collections`是集合工具类，用来对集合进行操作
- `public static <T> boolean addALL(Collection<T> c,T...elements)`:往集合里面添加一些元素
- `public static void shuffle(List<?> list) `： 打乱集合顺序
- `public static <T> void sort(List<T> list)`：将集合中元素按照默认规则排序
- `public static <T> void sort(List<T> list,Comparator<? super T> )`:将集合中元素按照指定规则排序

```java
//Collections.addALL
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
```

```java
//person实现可比较
package com.collection.collections;

public class Person implements Comparable<Person>{
    private String name;
    private  int age;


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写排序的规则
    @Override
    public int compareTo(Person o) {
        //return 0;//认为元素都是相同的
        //自定义比较的规则，比较两个人的年龄(this,参数Person)
        return this.getAge()-o.getAge();//按照年龄升序排序

    }
}
```

```java
package com.collection.collections;

import java.util.ArrayList;
import java.util.Collections;


//使用前提：被排序的集合里存储的元素，必须实现Comparable,重写接口中的方法compareTo定义排序的规则

//Comparable接口的排序规则：
//this-参数： 升序
//参数-this: 降序
public class Demo02Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        list01.add(1);
        list01.add(3);
        list01.add(2);
        System.out.println(list01);//[1, 3, 2]

        Collections.sort(list01);//默认是升序
        System.out.println(list01);//[1, 2, 3]

        ArrayList<String> list02 = new ArrayList<>();
        list02.add("A");
        list02.add("D");
        list02.add("C");
        System.out.println(list02);

        Collections.sort(list02);
        System.out.println(list02);


        ArrayList<Person> list03 = new ArrayList<>();
        list03.add(new Person("张三",18));
        list03.add(new Person("李四",20));
        list03.add(new Person("王五",15));
        System.out.println(list03);

        Collections.sort(list03);
        System.out.println(list03);

    }
}
```

```java
//定义一个学生类
package com.collection.collections;


public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```

```java
//在sort方法的参数传递中实现Comparator

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

```



## Map集合

将键映射到值的对象。一个映射不能包含重复的键，每个键最多只能映射到一个值。

- `map`中的集合，元素是成对存在的。每个元素由键和值两部分组成，通过键可以找键所对应的值
- `collection`中的集合称为单列集合，`Map`中的集合称为双列集合

### 实现类

- `java.util.HashMap<k,v>集合`

1. `HashMap`集合底层是哈希表，查询的速度特别的快
   1. JDK1.8之前： 数组+单向链表
   2. JDK1.8之后： 数组+单向链表/红黑树
2. `HashMap`集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致



- `LinkedHashMap`的特点

1. 底层是哈希表+链表
2. 是一个有序的集合，存储元素和取出元素的顺序是一致的

### Map接口中常用的方法

- `public V input(K key, V value)`:把指定的键与指定的值加入Map集合中
- `public V remote(Object key)`:把指定的键所对应的键值对元素在Map集合中删除，返回被删除元素的值
- `public V get(Object key)`:根据指定的键，在Map集合中获取对应的值
- `boolean containsKey(Object key)`:判断集合中是否包含指定的键
- `public Set<K> keySet()`:获取Map集合中所有的键，存储到Set集合中
- `public Set<Map.Entry<K,V>> entrySet()`:获取到Map集合中所有的键值对对象的集合（Set集合）

```java
//示例代码
package com.collection.map;

import java.util.HashMap;
import java.util.Map;

/*
    java.util.Map<k,v>
 */
public class Demo01Map {
    public static void main(String[] args) {
        show03();
    }

    /*
        public V put(K key, V value)
        返回值V：
            存储键值对的时候，key不重复，返回值V为null
            存储键值对的时候，key重复，会使用新的value替换map的value，返回被替换的value值
     */


    private  static void show01(){
        //创建Map集合对象，多态
        Map<String,String> map = new HashMap<>();
        String v1 = map.put("lichen","fanbingbing");
        System.out.println("v1:"+v1);

        String v2 = map.put("lichen","fanbingbing");
        System.out.println("v2:"+v2);

        System.out.println(map);

        map.put("lengfeng","longxiaoyun");
        map.put("yangguo","xiaolongnv");
        System.out.println(map);

    }

    /*
        public V put(Object key)
     */


    private static void show02(){
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",160);
        System.out.println(map);

        Integer v1 =  map.remove("赵丽颖");
        //int v1  可以用int类型接收，但是要是键不存在，null无法赋值给int
        System.out.println("v1: "+v1);
        System.out.println(map);

        System.out.println(map.get("杨颖"));
        System.out.println(map.get("迪丽热巴"));



    }

    /*
        public V get(Object Key)

     */

    private static void show03(){

        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",160);
        System.out.println(map);

        boolean b1 = map.containsKey("赵丽颖");
        boolean b2 = map.containsKey("好东西");
        System.out.println("b2： "+b2);
        System.out.println("b1： "+b1);


    }
}
```

```java
//遍历HashSet
package com.collection.map;
/*
    Map集合第一种遍历方式：通过键找值的方式
    实现步骤：
        1. 使用Map集合中的方法keySet()，把Map集合所有的key取出来，存储到一个Set中
        2. 遍历set集合，获取Map集合中的每一个键
        3.通过Map集合中的方法get(key)，获取集合中的每一个value
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo02KeySet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",160);
        System.out.println(map);

        Set<String> set = map.keySet();
        //使用迭代器遍历set集合
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String key = it.next();
            Integer value = map.get(key);
            System.out.println(key+":"+value);
        }

    }
}
```

`Map.Entry<K,V>`：在`Map`接口中有一个内部接口`Entry`

作用： 当`Map`集合一创建，那么就会在`Map`集合中创建一个`Entry`对象，用来记录键与值（键值对对象，键与值的对象）

`Entry`对象中的方法： `getKey()`、`getValue()`

```java
//遍历HashSet第二种方法
package com.collection.map;
/*
    Map集合遍历的第二种方法:使用Entry对象遍历
   实现步骤：
   1. 使用entrySet()把Map集合中多个Entry对象取出来，存储到一个Set集合中
   2. 遍历Set集合，获取每一个Entry对象
   3. 使用Entry对象中的方法getKey()和getValue()获取键与值
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo03EntrySet {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",160);
        System.out.println(map);

        Set<Map.Entry<String,Integer>> set = map.entrySet();
        //使用迭代器遍历Set
        Iterator<Map.Entry<String,Integer>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> entry = it.next();
            String key  = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);

        }

        System.out.println("------------------------------------------");

        for(Map.Entry<String,Integer> entry:set){
            String key =   entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+":"+value);
        }
    }
}

```

### HashMap存储自定义类型

若自定义元素存储在`key`中，必须重写`hashCode`和`equals`方法保证唯一  

  ```java
//定义Person类
package com.collection.map;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

  ```

```java
package com.collection.map;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    HashMap存储自定义类型键值
    Map集合保证key是唯一的
        作为key的元素，必须重写hashCode方法和equals方法保证key唯一
 */
public class Demo04HashMapSavePerson {
    public static void main(String[] args) {
        show2();
    }
    /*
        HashMap存储自定义类型键值
        key:String类型
            String类型重写了HashCode方法和equals方法，可以保证key唯一
        value:Person类型
            value可以重复（同名同年龄）
     */
    private  static void show01(){
        HashMap<String,Person> map = new HashMap<>();
        //往集合中添加元素
        map.put("北京",new Person("张三",18));
        map.put("上海",new Person("李四",19));
        map.put("广州",new Person("王五",20));
        map.put("北京",new Person("赵六",18));

        //使用keySet加上增强for遍历Map集合
        Set<String> set = map.keySet();
        for(String key:set){
            Person value = map.get(key);
            System.out.println(key+":"+value);
        }

    }
    /*
        HashMap存储自定义类型键值
        Map集合保证key是唯一的：
            作为key的元素，必须重写hashCode方法和equals方法，以保证key唯一
     */
    private static void show2(){
        HashMap<Person,String> map = new HashMap<>();
        //往集合中添加元素
        map.put(new Person("女王",18),"英国");
        map.put(new Person("秦始皇",18),"秦国");
        map.put(new Person("普京",30),"俄罗斯");
        map.put(new Person("女王",18),"毛里求斯");
        //使用entrySet和增强for
        Set<Map.Entry<Person,String>> set = map.entrySet();
        for (Map.Entry<Person,String> entry: set){
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+":"+value);

        }
    }
}

```

### LinkedHashMap集合

继承了`HashMap`集合，底层原理是哈希表加上链表，是一个有序的集合。  

### Hashtable集合

1. 底层也是哈希表，但是键和值都不能够是`null`
2. 是最早期的双列集合
3. 是同步的，是单线程的，意味着速度比较慢

```java
package com.collection.map;

import java.util.HashMap;
import java.util.Hashtable;

/*
    Hashtable和Vector集合一样，在jdk1.2版本之后被更先进的集合（HashMap,ArrayList)取代了
    Hashtable的子类Properties依然活跃在历史舞台
    Properties集合是唯一一个和IO流相结合的集合
 */
public class Demo06Hashtable {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put(null,"a");
        map.put("b",null);
        map.put(null,null);
        System.out.println(map);//可以存储null

        Hashtable<String,String > table = new Hashtable<>();
        table.put(null,"a");
        System.out.println(table);//NullPointerException异常

    }
}

```



