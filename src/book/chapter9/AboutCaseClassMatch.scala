package book.chapter9;

/**
 * @author xiangzhang
 * @since 2022-11-03 16:49
 */
object AboutCaseClassMatch {

  def processCase(input: Any) = {
        input match {
          case table(10,weight) => println("桌子高10")
          case chair(a,b) if a == 10 && b == 10 => println("正方形沙发")
          case book() => println("书")
          case _ => println("error input")
        }

  }

  def main(args: Array[String]): Unit = {
    processCase(table(10,80))
    processCase(chair(10,10))
    // 空参列表情况下，没有括号实际输入的是伴生对象
    processCase(book)
    processCase(book())
  }

}


case class table(height: Int, weight: Int)
case class chair(height: Int, weight: Int)
case class book()