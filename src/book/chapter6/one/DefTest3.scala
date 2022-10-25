package book.chapter6.one

import java.time.LocalDate

object DefTest3 {

  def main(args: Array[String]): Unit = {
    val date = LocalDate.now()
    log(date,"m1")
    log(date,"m1-U")
    log(date,"m2")


    val stringToUnit = log(date, _: String)
    stringToUnit("m4")
    stringToUnit("m5")
    stringToUnit("m6")

    val log2use = log2(date, _: Int)
    log2use(1)
    log2use(2)
    log2use(3)
  }

  def log(date: LocalDate, msg: String): Unit ={
    println(s" $date , $msg")
  }

  def log2(date: LocalDate, num: Int) = {
    println(s" $date , $num")
  }
}
