package book.chapter4.seven

/**
 * 枚举是一个扩展了 Enumeration 类的对象
 */
object MyEnum extends Enumeration {
  val CNY, USD, JPY, PLN,INR = Value
}

object MyEnum2 extends Enumeration(11) {
  type MyEnum2 = Value
  val CNY, USD, JPY, PLN,INR = Value
  val OTHERS = Value(20,"其他货币")
}

object MyEnum3 extends Enumeration {
  val jack = Value
}

object test {
  def main(args: Array[String]): Unit = {
    MyEnum.values.foreach(e => println(s"${e.id}   $e"))
    MyEnum2.values.foreach(e => println(s"${e.id}   $e"))
  }
}
