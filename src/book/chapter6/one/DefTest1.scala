package book.chapter6.one

object DefTest1 {

  def sum(number: Int): Int = {
    var result = 0
    for (i <- 0 to number){
      result += i
    }
    result
  }

  def sum2(number: Int, func: Int => Int): Int = {
    var result = 0
    for (i <- 0 to number){
      result += func(i)
    }
    result
  }

  def more(arr: Array[Int], init: Int, func: (Int, Int) => Int): Int = {
    var tmp = init
    arr.foreach(e => tmp = func(tmp, e))
    tmp
  }

  def curry(arr: Array[Int])(init: Int)(func: (Int, Int) => Int): Int = {
    var tmp = init
    arr.foreach(e => tmp = func(tmp, e))
    tmp
  }

  def main(args: Array[String]): Unit = {
    println(sum(10))
    println(sum2(10, e => e*2))

    val arr = Array(1, 2, 8, -1, 6, 9, 2)
    val i = more(arr, 0, (a, b) => Math.max(a,b))
    println(i)
    // 官方实现
    val i1 = arr.foldLeft(Integer.MAX_VALUE) {
      (x, y) => Math.min(x, y)
    }
    println(i1)
    // 官方简化
    val i2 = (Integer.MAX_VALUE /: arr) {(x,y) => Math.min(x,y)}
    println(i2)
    // 柯里化
    val c = curry(arr)(20){
      (a, b) => if (a >= b) a else b
    }
    println(c)
    // 在函数值只引用一次的变量可以用下划线
    val i3 = (Integer.MAX_VALUE /: arr){Math.min(_,_)}
    println(s" 针对i2简化表达式：$i3")
    arr.exists( e => e > 0)
    arr.exists( _ > 0 )
    // 继续简化
    val i4 = (Integer.MAX_VALUE /: arr){ Math.min }
    println(i4)
  }

}
