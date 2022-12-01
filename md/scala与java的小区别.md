## scala实用指南第三章

1.  关键字基本上是函数， 函数是一等公民
```scala
1 to 3 foreach(i => println(s"$i"))
```
2.  元组，（元组是一个不可变的对象序列，创建时使用逗号分隔。）多重赋值
```scala
def getInfo(): (String,Int,String) = { 
  ("jack",18,"tennis")  
}
```
3.  下划线取值
```scala
val info = getInfo()  
println(info._1)
```
4. 可变参数
```scala
def result(values: Int*)=  {  
  values.foldLeft(values(0))((x,y) => if(x > y)  x else y )  
}
```
5.  默认参数
```scala
def getUserInfo(name: String = "jack", age: Int = 22, sport : String = "baseball") = {  
  println(s"name: $name, age: $age, sport: $sport")  
}


getUserInfo(name = "mark")
```
6.  多行字符串
```scala
val lines = """is his hair red ?  
     |the ticket office is right there     
     |"I like to cook  """.stripMargin
```
7.  字符串插值计算
```scala
object StringValue {  
  val price = 100  
  val num = 2  
  def main(args: Array[String]): Unit = {  
    println(s"how much the subway ticket? ${price / 2}")  
    println(s"how much the subway ticket? $$${price * {num - 0.52}}" )  
    println(f"how much the subway ticket? $$${price / {num - 0.52}}%2.3f" )  
  
  }}
```
8.  == 和 equals 的区别
```scala
== 在scala 是值的比较，是否同一个实例对象 要用eq , 有特殊需要可以重写对象的 equals / hashcode

object amount {  
  val a = "hi"  
  val b = "hi"  
  val c = new String("hi")  
  
  def main(args: Array[String]): Unit = {  
    println(a == b)  // true
    println(a eq b)  // true
    println(a == c)  // true
    println(a eq c)  // false
  }}
```
