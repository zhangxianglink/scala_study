## 实用指南第四章
<hr>
1. scala 构造函数
```scala
scala 默认提供get/set ， 构造器就是类本身， Scala 会执行主构造器中任意表达式和直接内置在类定义中的可执行语句。

class MyClass(val day: Int) {
println (s"1111111111111111")
}

val clazz = new MyClass(2022)
clazz.day = 29  
println(clazz.day)
```
2. scala 自定义构造函数
```scala
class Construct (val firstName: String, val lastName: String){
	/**  
	 * var => private 字段 get/set  
	 * val => private final  get 
	 * Scala要求变量在使用前必须初始化 _ 等同于默认值。  
	*/
	var level: String = _

    /**
      自定义构造函数，第一行必须调用主构造或其他构造器
    */
    def this(firstName: String, lastName: String, level: String){
        this(firstName,lastName )
        this.level = level 
    }
}
```
3. scala 继承
```scala
class station(val price: Int, val date: Long){}
// 继承 override 字段不会重复生成
class subwayStation(override val price: Int, override val date: Long, val ticketOffice : String)
// 类似super
extends station(price,date) {}
```
4.  scala的泛型
```scala
// 泛型类
class Message[T](val v: T) {}
// 泛型方法
def echo[T]( in1: Any,  int2: T): T = {  
  println(s"所有类型继承Any: $in1  (${in1.getClass})")  
  int2  
}
```
5.  scala 伴生对象
```scala
scala在语言层面解决了单例模式，object修饰的类无法实例化。
// 构造私有化
class Marker private  (val name : String){
	 override def toString: String = {  
	  s"color: $color"  
	}
}
// 伴生对象
object Marker {
	private val map = mutable Map (  
	  "red" -> new Marker("red"),  
	  "blue" -> new Marker("blue"),  
	  "yellow" -> new Marker("yellow")  
	)
    // 静态方法
	def getInstance(color: String) ={  
	  map getOrElse (color,new Marker(color))  
	}
	// 特殊方法 apply 
	def apply(color: String) ={  
	  map getOrElseUpdate (color, op = new Marker(color))  
	}
}
// 类和伴生对象可以互相访问私有字段方法，所有可以在伴生对象new实例
println(Marker getInstance "blue") 
// 提示错误
new Marker("blue")  
// 简化new
Marker.apply("1")  
Marker("2")

```
6. scala 的枚举类实现
```scala
object MyEnum2 extends Enumeration(11) {  
  type MyEnum2 = Value  
  val CNY, USD, JPY, PLN,INR = Value  
  val OTHERS = Value(20,"其他货币")  
}
MyEnum2.values.foreach(e => println(s"${e.id}   $e"))
```
7. scala的基础类型
```scala
Any 是所有类型的超类，直接后裔AnyVal,AnyRef
AnyVal 代表值类型（Int,Double等）并且映射到java的元素类型
AnyRef 代办所有引用的基础类型，包含了Object的方法
	AnyRef.wait()
	AnyRef.notify()
Nothing 是最底层的类型
```
8. scala的Option类型
```scala
Option 作为抽象类有两个实现类 Some, None
def getOp(value : String) = {  
  if (value == "nice") Some("good") else None  
}  
def main(args: Array[String]): Unit = {  
  val maybeString = getOp("nice")  
  println(maybeString getOrElse("not found"))  
  val option = getOp("")  
  println(option getOrElse("not found"))  
}
```
9. scala 的Enter类型
```scala
Either 作为抽象类有两个实现类 ，Left, Right
def differentValue(input: Int) = {  
  if (input > 0) Right("字符串类型") else Left(new event(age = 22, user = "jack"))  
}  
  
def display(input: Either[event, String]) = {  
  input match {  
    case Left(value) => println(s" display $value")  
    case Right(value) => println(s" display $value")  
  }}
```