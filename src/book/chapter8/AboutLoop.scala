package book.chapter8

object AboutLoop {
  /**
   * for 表达式接受一个或者多个生成器作为参数，并带有 0 个或者多个定义以及 0 个或者
      多个过滤器。这些都是由分号分隔的。yield 关键字是可选的，如果存在，则告诉表达式返
      回一个值列表而不是一个 Unit
   * @param args
   */
  def main(args: Array[String]): Unit = {
    for (_ <- 1 to 3){
      println("hi")
    }

    val odds = for (i <- 1 to 10; if i % 2 == 1 ; if i > 5)  yield
    {
      i * 1
    }
    println(odds)

    val evens = for {
                      i <- 1 to 10
                      if i % 2 == 0
                      if i > 5
                    } yield i * 1
    println(evens)

    val persons = List(Person("a", "b"), Person("c", "d"), Person("e", "f"), Person("g", "h"), Person("i", "j"))
    val lastNames = for (p <- persons) yield p.lastName
    println(lastNames.mkString(","))

    // 外层在左， 内层在右
    for (i <- 1 to 3 ; j <- 4 to 6){
      println(s"$i, $j")
    }
  }
}






class Person(val firstName: String, val lastName :String){}

object Person {
  def apply(firstName : String, lastName :String) = new Person(firstName,lastName)
}
