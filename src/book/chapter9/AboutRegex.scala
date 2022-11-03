package book.chapter9

object AboutRegex {
  def process(string: String) = {
    string match {
      case Check1() => println(s" check1 ${string}")
      // 计算返回 a,b 并且传入其他提取器
      case Check2(a @ Check1() ,b @ Check3())  => println(s"Received price $$$b for symbol $a")
      case _ => println(s"Invalid input $string")
    }
  }

  def main(args: Array[String]): Unit = {
    process("IBM")
    process("IBM:")
    process("IBM:2")
    process("ERR")
    process("ERR:1")

  }

}

object Check1 {
  def unapply(string: String): Boolean ={
    string == "IBM" || string == "Oracle"
  }
}

object Check2 {
  def unapply(string: String): Option[(String,Double)] = {
    try {
      if (string contains ":") {
        val splitQuote = string split ":"
        Some((splitQuote(0), splitQuote(1).toDouble))
      } else {
        None
      }
    } catch {
      case _: NumberFormatException => None
      case _: ArrayIndexOutOfBoundsException => None
    }
  }
}

object Check3 {
  def unapply(double: Double): Boolean ={
    double > 1
  }
}