package book.chapter6.one

import java.io.PrintWriter

/**
 *
 */
class Resource private () {
  println("Starting transaction...")
  private def cleanUp(): Unit = { println("Ending transaction...") }
  def op1(): Unit = println("Operation 1")
  def op2(): Unit = println("Operation 2")
  def op3(): Unit = println("Operation 3")
}
object Resource {
  def use(codeBlock: Resource => Unit): Unit = {
    val resource = new Resource
    try {
      codeBlock(resource)
    } finally {
      resource.cleanUp()
    }
  }
}

object DefTest5 {

  def main(args: Array[String]): Unit = {
    // execute around method
    // 以依赖构造器来正确地启动事务，使用完对象之后立刻 确定性地结束该事务
    Resource.use(e => {
      e.op3()
      e.op2()
      e.op1()}
    )

    /**
     * （Loan pattern）。在你想确定性地处理非内
        存资源时，使用这种设计模式。（这种设计模式的核心思想是，）资源密集型对象可以被看作
        是借来的，（使用完毕后）我们应该用合理的方式归还
        文件读取为例子 ,感觉类似try catch resource
     */
    writeToFile("C:\\Users\\xiangzhang\\Desktop\\work-0910\\开店模块.txt"){
      writer => writer write("hello, this is my way")
    }

  }

  def writeToFile(fileName: String)(callBlock: PrintWriter => Unit) = {
    val writer = new PrintWriter(fileName)
    try {
      callBlock(writer)
    }finally {
      writer.close()
    }
  }

}
