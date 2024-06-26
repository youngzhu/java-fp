# Functional Programming in Java, 2nd Edition

## Ch01 Hello, Lambda Expressions!

## Ch02 Using Collections

## Ch03 Strings, Comparators, and Filters

## Ch04 Transforming Data
map: one-to-one function
flatMap (maps first and then flattens): one-to-many function


## Ch05 Designing with Lambda Expressions
- 方法层面的 [AssetUtil2.java](src/main/java/com/youngzy/book/fpij/ch05/AssetUtil2.java)
- 类之间 [CalculateNAV.java](src/main/java/com/youngzy/book/fpij/ch05/CalculateNAV.java)
- 装饰者模式 [Camera.java](src/main/java/com/youngzy/book/fpij/ch05/Camera.java)
- 默认方法（default methods） [DefaultMethods.java](src/main/java/com/youngzy/book/fpij/ch05/DefaultMethods.java)
  1. 子类型自动继承超类（包括类和接口）的默认方法
  `FastFly` 自动继承了 `Fly` 中的另外3个方法
  2. 对于提供了默认方法的接口，子类型中的实现优先于超类中的实现
  对于继承自 `FastFly` 的类或接口，会使用 `FastFly` 中的 `takeOff()` 方法，而不是 `Fly` 的
  3. 类（包括抽象类）中方法的实现优先于接口中默认方法
     `turn()` 方法在 `Vehicle` `FastFly` `Sail` 中都有，但并没有冲突
  4. 如果多个默认方法的实现存在冲突，或者接口之间存在冲突的默认方法，实现类应该消除歧义
     `cruise()` 方法在接口 `FastFly` `Sail` 中都有，冲突了，实现类 `SeaPlane` 必须消除歧义
- 方法链（Method Chaining） [MailerBuilder.java](src/main/java/com/youngzy/book/fpij/ch05/MailerBuilder.java)

## Ch06 Working with Resources
- Automatic Resource Management (ARM): [FileWriterARM.java](src/main/java/com/youngzy/book/fpij/ch06/FileWriterARM.java)
- Execute Around Method (EAM) pattern
  - > "Execute Around Method pattern" 是一种编程设计模式，也称为"环绕执行模式"，通常用于实现资源管理和异常处理等功能。
    > 在该模式中，一个方法会接收一个 lambda 函数作为参数，然后在这个 lambda 函数周围包装一些公共的代码逻辑，
    > 例如资源的获取和释放等操作，最后再执行 lambda 函数。这样可以确保公共逻辑在执行 lambda 函数前后得到正确地处理，同时使得代码更加简洁、易于理解和维护。
  - Resource Cleanup: [FileWriterEAM.java](src/main/java/com/youngzy/book/fpij/ch06/FileWriterEAM.java)
  - Managing Locks: [Locking.java](src/main/java/com/youngzy/book/fpij/ch06/Locking.java)
  - Exception Tests: [RodCutterTest.java](src/test/java/com/youngzy/book/fpij/ch06/RodCutterTest.java)

## Ch07 Being Lazy
- 延迟初始化（原始版） [HolderNaive.java](src/main/java/com/youngzy/book/fpij/ch07/HolderNaive.java)
- 延迟初始化（线程安全） [HolderThreadSafe.java](src/main/java/com/youngzy/book/fpij/ch07/HolderThreadSafe.java)
- 延迟初始化（Lambda表达式） [Holder.java](src/main/java/com/youngzy/book/fpij/ch07/Holder.java)
- Lazy Evaluation [Evaluation.java](src/main/java/com/youngzy/book/fpij/ch07/Evaluation.java)
- Stream 的延缓执行 [LazyStreams.java](src/main/java/com/youngzy/book/fpij/ch07/LazyStreams.java)
- 寻找素数 [Primes.java](src/main/java/com/youngzy/book/fpij/ch07/Primes.java)

## Ch08 Optimizing Recursions
- TCO(tail-call optimization)，尾调用优化
  - >在一个递归函数中，如果递归调用是函数的最后一步操作，那么这个递归调用被称为尾递归。
    > 尾调用优化的思想是将这种尾递归调用转换成一个跳转操作，从而避免创建新的栈帧。这样，程序在递归时就不会占用过多的内存，也不会因为栈溢出导致程序崩溃。
  - 没太理解。这是ChatGPT给的一个例子
    ```java
      public static int factorial(int n) {
        return factorialHelper(n, 1);
      }

      private static int factorialHelper(int n, int accumulator) {
          if (n == 0) {
              return accumulator;
          } else {
              return factorialHelper(n - 1, n * accumulator);
          }
      }
    ```

## Ch09 Composing Functions with Lambda Expressions

## Ch10 Error Handling
将异常封装成“数据”，继续传递下去，以便链式函数能执行完成。在最后的结果集中处理数据和异常。

## Ch11 Refactoring to Functional Style

## Ch12 Functional Programming Idioms
- 表达式尽量写一行，最多两行。多了则用函数代替
- 优选方法引用
  - 不需要传参时，可以用“方法引用”替换
  - 要传参，又简单的，就不要替换了
  - ```java
      .filter(driver -> driver.getAge() > 21) // 保持原样
      .filter(Driver::isDriversLicenseValid) // 使用“方法引用”
    ```
- 注意格式，一行一个方法，如 `filter` `map` 等
- 一个条件，一个filter
- 函数表达式中不要有共享（可变的）变量。变量可用 `final` 修饰

## Ch13 Bringing It All Together
- 改变思维习惯，从之前的“命令式”改为“声明式”。Tell, Don't ask.
- 多使用不可变变量 `final`

## 主要的几个接口
### Consumer\<T>
消费者。有入参，没有出参。可用于 `forEach()` 等函数

### Supplier\<T>
生产者/工厂。返回类型T的实例

### Predicate\<T>
真假判断。返回true/false 。常用于 `filter()` `anyMatch()` 等函数

### Function\<T, R>
对象转换。有入参T，有出参R。T、R可能是同一个类型。常用于 `map()` 函数

## 心得/总结
- 函数式编程的优点：简明、高效
- 缺点：对于异常处理不够友好
- 函数式编程=声明式思维+高阶函数