package book.chapter5.five.mask

import book.chapter5.five.mask.MyInterpolator.Interpolator

object MyInterpolator {

  // context 字符串
  implicit class Interpolator (val context: StringContext) extends AnyVal {
    // args 对应表达式数值
    def mask(args: Any*): StringBuilder = {
      val processed = context.parts.zip(args).map { item =>
        // 举例： Account: 0246781263
        val (text, expression) = item
        if (text.endsWith("^"))
          s"${text.split('^')(0)}$expression"
        else
          s"$text...${expression.toString takeRight 4}"
      }.mkString
      // 无表达式
      val last = context.parts.last
      new StringBuilder(processed).append(last)
    }
  }
}

object MyInterpolatorTest {

  def main(args: Array[String]): Unit = {
    val ssn = "123-45-6789"
    val account = "0246781263"
    val balance = 20145.23
    println(mask"""Account: $account
                  |Social Security Number: $ssn
                  |Balance: $$^$balance
                  |Thanks for your business.""".stripMargin)
  }
}
