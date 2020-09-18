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

