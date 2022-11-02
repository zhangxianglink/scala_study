package book.chapter9

/**
 * Scala 对于模式匹配的出色支持意味着，在并发编程中在处理 Actor 接收到的消息时，将会大量地使用它。
 */
object AboutPatternMatch{
  // 字符串匹配
  def activity(day: String) = {
        day match {
          case  "thursday" => println("crazy")
          case _ => println("cool")
        }
  }
  // 元组匹配
  def processCoordinates(input: Any)= {
    input match {
      case (a, b) => printf("Process (%d, %d)", a, b)
      case "done" => println("done")
      case _ => println("nothing")
    }
  }

  def main(args: Array[String]): Unit = {
    List("Monday","Tuesday","Wednesday","thursday").foreach( activity )

    processCoordinates("done")
    processCoordinates((1,2))
  }

}

