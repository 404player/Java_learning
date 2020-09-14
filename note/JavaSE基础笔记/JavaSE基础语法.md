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





