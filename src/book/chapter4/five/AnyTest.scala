package book.chapter4.five

object AnyTest {

  def echo[T]( in1: Any,  int2: T): T = {
    println(s"所有类型继承Any: $in1  (${in1.getClass})")
    println(s" $int2  (${int2.getClass})")
    int2
  }

  def main(args: Array[String]): Unit = {
    echo(12,"类型 T")
    echo("flyWay", true)

  }

}


class Message[T](val v: T) {

  def is(value: T) = {
    value == v
  }
}

