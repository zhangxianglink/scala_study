package book.chapter7.abouttrait

import java.io.StringWriter

/**
 * 特质中的方法延迟绑定
 */
object four {

  def main(args: Array[String]): Unit = {
    val use = new use with up with rep
    val use2 = new use with rep with up

    use.writeMsg("aaaaaaaaoooo")
    use2.writeMsg("aaaaaaaaoooo")

    println(use)
    println(use2)
  }
}

abstract class Writer {
  def writeMsg(name: String)
}

class use extends Writer {
  private val writer = new StringWriter

  def writeMsg(name: String): Unit = writer.write(name)

  override def toString: String = writer.toString
}

trait up extends Writer {
  abstract override def writeMsg(name: String): Unit = super.writeMsg(name.toUpperCase)
}

trait rep extends Writer {
  abstract override def writeMsg(name: String): Unit = super.writeMsg(name.replace("a","s"))
}
