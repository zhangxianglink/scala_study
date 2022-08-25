package book.chapter5.five.fun

import book.chapter5.five.fun.DateHelper.{ago, from_now ,convertIntToDateHelper}

object Implicit {

  def main(args: Array[String]): Unit = {
    val a = 2 days ago
    println(a)
    val b = 5 days from_now
    println(b)
  }

}
