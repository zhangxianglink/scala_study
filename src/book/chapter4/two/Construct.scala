package book.chapter4.two

/**
 * 构造：初始化字段，函数，执行可运行语句
 *
 * @param firstName
 * @param lastName
 */
class Construct (val firstName: String, val lastName: String){


  /**
   * var => private 字段 带有get/set
   * val => private final
   * Scala要求变量在使用前必须初始化 _ 等同于默认值。
    */
  var level: String = _
  println (s"1111111111111111")
  println(s"init $toString")
  println (s"2222222222222222")

  //在辅助构造器中，我们调用主构
  //造器来初始化与名字相关的字段。Scala 强制规定：辅助构造器的第一行有效语句必须调用主
  //构造器或者其他辅助构造器。
  def this( firstName: String,  lastName: String, level: String){
    this(firstName, lastName)
    this.level = level
  }

  override def toString: String = {
    s" $firstName, $lastName, $level"
  }

  def start(): Unit ={
    println("")
  }


}

object test {
  def main(args: Array[String]): Unit = {
    val construct = new Construct("a", "b")
    println(construct)

    val construct2 = new Construct("a", "b","c")
    println(construct2)
  }
}