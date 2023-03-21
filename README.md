# Functional Programming in Java

## ch04 Designing with Lambda Expressions
- 方法层面的 [AssetUtil2.java](src/main/java/com/youngzy/book/fpij/ch04/AssetUtil2.java)
- 类之间 [CalculateNAV.java](src/main/java/com/youngzy/book/fpij/ch04/CalculateNAV.java)
- 装饰者模式 [Camera.java](src/main/java/com/youngzy/book/fpij/ch04/Camera.java)
- 默认方法（default methods） [DefaultMethods.java](src/main/java/com/youngzy/book/fpij/ch04/DefaultMethods.java)
  1. 子类型自动继承超类（包括类和接口）的默认方法
  `FastFly` 自动继承了 `Fly` 中的另外3个方法
  2. 对于提供了默认方法的接口，子类型中的实现优先于超类中的实现
  对于继承自 `FastFly` 的类或接口，会使用 `FastFly` 中的 `takeOff()` 方法，而不是 `Fly` 的
  3. 类（包括抽象类）中方法的实现优先于接口中默认方法
     `turn()` 方法在 `Vehicle` `FastFly` `Sail` 中都有，但并没有冲突
  4. 如果多个默认方法的实现存在冲突，或者接口之间存在冲突的默认方法，实现类应该消除歧义
     `cruise()` 方法在 `FastFly` `Sail` 中都有，冲突了，实现类 `SeaPlane` 必须消除歧义