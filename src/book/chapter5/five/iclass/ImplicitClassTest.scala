package book.chapter5.five.iclass


import book.chapter5.five.iclass.DateUtils._


object ImplicitClassTest {

  def main(args: Array[String]): Unit = {
    val c = 2 time ago
    val d = 5 time from_now
    println(c)
    println(d)

  }

}
