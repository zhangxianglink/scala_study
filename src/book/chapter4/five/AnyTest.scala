package book.chapter4.five

object AnyTest {

  def echo[T]( in1: Any,  int2: T): T = {
    println(s"所有类型继承Any: $in1  (${in1.getClass})")
    println(s" $int2  (${int2.getClass})")
    int2
  }

  def main(args: Array[String]): Unit = {
    // 泛型函数
    echo(12,"类型 T")
    echo("flyWay", true)

    // 泛型类
    val m1 = new Message[String]("Hello")
    val m2 = new Message(12)
    println(m1.is("h"))
    println(m1.is("Hello"))
    println(m2.is(23))
    println(m2.is(12))
  }

}


class Message[T](val v: T) {

  def is(value: T) = {
    value == v
  }
}

