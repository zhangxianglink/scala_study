package book.chapter8

object UsingSet {

  def main(args: Array[String]): Unit = {
    aboutSet()
  }

  def aboutImmutable() = {
    // 默认不可变
    val set1 = Set("a", "b", "c")
    println(s"set1: $set1")
    println(s"set1 + d: ${set1 + "d"}")
    println(s"set1: $set1")
  }

  def aboutSet() = {
    val feeds1 = Set("blog.toolshed.com", "pragdave.me", "blog.agiledeveloper.com")
    val feeds2 = Set("blog.toolshed.com", "martinfowler.com/bliki")

    val blogs = feeds1 filter(e => e.contains("blog"))
    println(s"blogs: ${blogs mkString(" - ")}")

    val merge = feeds1 ++ feeds2
    println(merge)

    val common = feeds1 & feeds2
    println(common)

    val strings = feeds1.map("http://" + _)
    strings foreach(e => println(s"${e}"))
  }



}
