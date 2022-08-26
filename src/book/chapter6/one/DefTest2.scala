package book.chapter6.one

/**
 * 参数路由
 */
object DefTest2 {

  def main(args: Array[String]): Unit = {
    def func(x: Int): Int = {
      println("x--------")
      x
    }

    val func2 = {num: Int =>
      println("num -------------")
      num
    }

    val equipment = new Equipment(func)
    equipment.simple(20)

    val equipment1 = new Equipment(func2)
    equipment1.simple(30)

  }



}

class Equipment(val func: Int => Int){
  def simple(int: Int): Unit ={
    println("start ------------")
    func(int)
  }
}