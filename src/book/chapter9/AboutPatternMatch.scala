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

  // 数组匹配
  def processLists(items: List[String]) = {
    items match {
      case List("a","b") => println(" ab ")
      case List("1","2","3") => println(" 123 ")
      case List("1","2",_*) => println(" 12? ")
      case List("+","-", otherItems @ _* ) => println(" + - " + otherItems)
      case _ => println(" ???????????? ")
    }
  }

  // 类型匹匹配
  def processTypes(input: Any) = {
    input match {
      case (_:Int,_:Int) => write(s"process int ${input}")
      case (_:Double,_:Double) => println(s"process double ")
      // 注意顺序 当存在判断条件的情况下
      case msg: Int if msg > 200 => println(s"process int > 200")
      case _: Int => println(s"process int _ ")
      case _: String => println("process string _")
      case _ => printf(s"Can't handle $input... ")
    }

    def write(string: String): Unit ={
      println(string)
    }
  }

  def main(args: Array[String]): Unit = {

    List("Monday","Tuesday","Wednesday","thursday").foreach( activity )

    processTypes((1, 2))
    processTypes((34.2, -159.3))
    processTypes(0)
    processTypes(1000001)
    processTypes(2.2)

    processCoordinates("done")
    processCoordinates((1,2))

    processLists(List("a","b"))
    processLists(List("1","2","4"))
    processLists(List("1","2","3"))
    processLists(List("+","-","/","*"))
    processLists(List("?"))

    val plate = new plate
    plate.find(100)
    plate.find(0)
    plate.find(-100)


  }
}

// 模式变量 和 预定义值
class plate {
  val MAX = 100
  val min = -100
  val zero = 0
  def find(input: Int) = {
    input match {
      case MAX => println("大写表示预定义值")
//      case `min` => println("单引号提示")
      case this.min => println("引用提示")
      case min => println("scala 认为是模式变量")
    }
  }
}
