#### 常规函数
```scala
def sum(number: Int): Int = {  
  var result = 0  
  for (i <- 0 to number){  
    result += i  
  }  
  result  
}
```
#### 高阶函数
```scala
def sum(number: Int, func: Int => Int): Int = {  
  var result = 0  
  for (i <- 0 to number){  
    result += func(i)  
  } 
   result  
}
sum2(10, e => if (e % 2 == 0 ) e else  0)
```
#### 多参数函数
```scala
def more(arr: Array[Int], init: Int, func: (Int, Int) => Int): Int = {  
  var tmp = init  
  arr.foreach(e => tmp = func(tmp, e))  
  tmp  
}
val arr = Array(1, 2, 8, -1, 6, 9, 2)  
more(arr, 0, (a, b) => Math.max(a,b))
// 官方简化，函数值放入大括号
arr.foldLeft(Integer.MAX_VALUE) {  
  (x, y) => Math.min(x, y)  
}
// 官方简化, flodLeft的简写 /:  foldRight的简写 :\
(Integer.MAX_VALUE /: arr) {(x,y) => Math.min(x,y)}
```
#### 柯里化currying
```scala
在计算机科学中，柯里化（英语： Currying ），又译为卡瑞化或加里化，是把接受多个参数的函数变换成接受一个单一参数（最初函数的第一个参数）的函数，并且返回接受余下的参数而且返回结果的新函数的技术。
下面对more函数进行柯里化改造
def curry(arr: Array[Int])(init: Int)(func: (Int, Int) => Int): Int = {  
  var tmp = init  
  arr.foreach(e => tmp = func(tmp, e))  
  tmp  
}

val arr = Array(1, 2, 8, -1, 6, 9, 2) 
curry(arr)(20){ (a, b) => if (a >= b) a else b }
```
#### 参数占位符
```scala
scala使用_代表一个函数值的参数。常用于单个只用一次的变量
简化前：arr.exists( e => e > 0)
简化后：arr.exists( _ > 0 )

简化前：(Integer.MAX_VALUE /: arr) { (x,y) => Math.min(x,y) }
简化后：(Integer.MAX_VALUE /: arr) { Math.min(_,_) }
编译器推导：(Integer.MAX_VALUE /: arr) { Math.min }

```
#### 函数复用，部分应用函数
```scala

class Equipment(val func: Int => Int){  
  def simple(int: Int): Unit ={  
    println("start ------------")  
    func(int)  
  }}
// 复用函数
def func(x: Int): Int = {}
val equipment = new Equipment(func)  
equipment.simple(20)

def log2(date: LocalDate, num: Int) = {  
  println(s" $date , $num")  
}
// 部分应用函数
val log2use = log2(date, _: Int)  
// 调用时scala会在内部创建一个含有特殊的apply()的新类，实际上是在用新类
log2use(1)  
log2use(2)

```
#### 闭包
```scala
闭包：绑定作用域和参数列表外的变量
object DefTest4 {  
  
  def loopPipe(num: Int)(function: Int => Unit) ={  
    for (i <- 1 to num) {  
      function(i)  
    }  }  
  def main(args: Array[String]): Unit = {  
    var result = 1  
    val add = {e:Int => result *= e}  
    loopPipe(5)(add)  
  
    loopPipe(5){  
      e => result *= e  
      println(s"闭包loop: ${e}  result: ${result}")  
    }    // 闭包的绑定不是复制, 而是传递。  
    result += 1  
    println(s"当前result： ${result}")  
  
    // 简化写法  
    var product = 1  
    loopPipe(5){product *= _ }  
    println(s"product: ${product}")  
  
  }}
```