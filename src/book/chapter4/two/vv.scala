package book.chapter4.two

import book.chapter7.abouttrait.two


class jj {
  // 没有public修饰
  val name :String = "jack"
  var age: Int = 26

}


object vv {

  def main(args: Array[String]): Unit = {
    val j = new jj
    println(j.age)

  }
}
