package book.chapter3.two

import java.util

/**
 * find the difference between scala and java
 */
object ScalaType {

  def scalaInt(): util.ArrayList[String] = {
    // scala Int 为 10
    val length: Int = 10
    // Java 集合
    val strings = new util.ArrayList[String]
    // 隐式转换为 java int
    strings.ensureCapacity(length)
    strings
  }

}

// 元组，多重赋值
object MoreResult {
  def getInfo(): (String,Int,String) = {
    // 元组是一个不可变的对象序列，创建时使用逗号分隔。
    ("jack",18,"tennis")
  }

  def main(args: Array[String]): Unit = {
    val (name,age,sport) = getInfo()
    val info = getInfo()
    // 下划线取值
    println(info._1)
    println(age)
    println(sport)
  }
}

// 可变参数

object MoreParam {

  def result(values: Int*)=  {
    values.foldLeft(values(0))((x,y) => if(x > y)  x else y )
  }

  def main(args: Array[String]): Unit = {
    val i = result(2, 2, 3, 4, 5)
    println(i)
  }

}

// 默认参数
object DefaultValues {
  def getUserInfo(name: String = "jack", age: Int = 22, sport : String = "baseball") = {
    println(s"name: $name, age: $age, sport: $sport")
  }

  def main(args: Array[String]): Unit = {
    getUserInfo(name = "mark")
    getUserInfo(sport = "video game")
  }

}

// 隐藏参数


// 字符串， 多行原始字符串
object MoreString {
  val lines =
    """is his hair red ?
       |the ticket office is right there
       |"I like to cook
    """.stripMargin

  def main(args: Array[String]): Unit = {
    println(lines)
  }

}

// 字符串插值
object StringValue {
  val price = 100
  val num = 2
  def main(args: Array[String]): Unit = {
    println(s"how much the subway ticket? ${price / 2}")
    println(s"how much the subway ticket? $$${price * {num - 0.52}}" )
    println(f"how much the subway ticket? $$${price / {num - 0.52}}%2.2f" )

  }
}


/**
 * scala 没有操作符, 但是优先级
 *
 */


class Add(val x: Int, val y: Int){
  def +(add: Add) ={
    new Add(x + add.x, y + add.y)
  }

  override def toString: String = {
    s"x: $x, y: $y"
  }
}

object AddTest {
   val add1 = new Add(1, 9)
   val add2 = new Add(-8, 5)
   val add3 = add1 + add2

  def main(args: Array[String]): Unit = {
    println(s"$add1 | $add2 | $add3")
  }

}


// == 在scala 是值的比较，是否同一个实例对象 要用eq , 有特殊需要可以重写对象的 equals / hashcode

object amount {
  val a = "hi"
  val b = "hi"
  val c = new String("hi")

  def main(args: Array[String]): Unit = {
    println(a == b)
    println(a eq b)
    println(a == c)
    println(a eq c)
  }
}

/**
 *  默认修饰符
 *  scala 默认 public
 *  protected 让所修饰的成员仅对自己和派生类可见。
 */
class one {
  protected def test(): Unit = {
    println(s" $this one")
  }
  def jack(): Unit = {

  }
}

class two extends one {

  def test1() {
    test()
  }

  def test2(t: two) {
    t.test()
  }
  // 派生类中父类实例无法访问 protected
//  def test3(o: one): Unit ={
//    o.test()
//  }
}

class three {
  def test5(o: one): Unit ={
    // 显式编译错误
    // o.test()
  }
}

object testProtected {
  def main(args: Array[String]): Unit = {
    val one = new one()
    // 无法在其他类使用
//    one.test()
    val two = new two()
    two.test1();
    two.test2(new two())
//    two.test3(new one())
  }
}































