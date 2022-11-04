package book.chapter9

object AboutRegex {
  // 默认是一个提取器 ,unapply()方法将会保存返回 Option[String]
  val pattern = "(S|s)cala".r
  val str = "Scala is scalable and cool"

  def main(args: Array[String]): Unit = {
    println(pattern findAllIn (str))
  }

  def process(input: String): Unit = {
    val MatchStock = """^(.+):(\d*\.\d+)""".r
    input match {
      case MatchStock("GOOG", price) => println(s"We got GOOG at $$$price")
      case MatchStock("IBM", price) => println(s"IBM's trading at $$$price")
      case MatchStock(symbol, price) => println(s"Price of $symbol is $$$price")
      case _ => println(s"not processing $input")
    }
  }
  process("GOOG:310.84")
  process("IBM:84.01")
  process("GE:15.96")
}
