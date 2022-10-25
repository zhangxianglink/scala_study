package book.chapter6.one

/**
 * 闭包
 */
object DefTest4 {

  def loopPipe(num: Int)(function: Int => Unit) ={
    for (i <- 1 to num) {
      function(i)
    }
  }

  def main(args: Array[String]): Unit = {
    var result = 1
    val add = {e:Int => result *= e}
    loopPipe(5)(add)

    loopPipe(5){
      e => result *= e
      println(s"闭包loop: ${e}  result: ${result}")
    }
    // 闭包的绑定不是复制, 而是传递。
    result += 1
    println(s"当前result： ${result}")

    // 简化写法
    var product = 1
    loopPipe(5){product *= _ }
    println(s"product: ${product}")

  }
}
