package book.chapter4.one

/**
 * scala 默认提供get/set ， 构造器就是类本身， Scala 会执行主构造器中任意表达式和直接内置在类定义中的可执行语句。我
 *
 * @param year
 */
class MyClass(val year: Int) {
  val list = List(1,2,3,4)
  private var month: Int = 0
  var day = 0
  def getMonth: Int = month
  def setMonth(month: Int): Unit = {
    this.month = month
  }

  override def toString: String = {
    s"""toString:
       |year: $year
       |month: $month
       |list: $list""".stripMargin
  }

  println("这是一条内置可执行语句，构造调用执行")
}

object UseClass {
  def main(args: Array[String]): Unit = {
    val clazz = new MyClass(2022)
    clazz.day = 29
    println(clazz.day)
    println(clazz.year)
    println(clazz.toString)
  }
}
