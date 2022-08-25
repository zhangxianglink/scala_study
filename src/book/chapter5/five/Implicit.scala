package book.chapter5.five

import book.chapter5.five.DateHelper.{ago, convertIntToDateHelper, from_now}

object Implicit {

  def main(args: Array[String]): Unit = {
    val a = 2 days ago
    println(a)
    val b = 5 days from_now
    println(b)
  }

}
