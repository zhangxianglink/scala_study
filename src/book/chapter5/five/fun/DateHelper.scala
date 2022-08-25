package book.chapter5.five.fun

import java.time.LocalDate
import scala.language.implicitConversions

/**
 * 匿名函数
 * @param offset
 */
class DateHelper(offset: Int) {

  def days(when: String): LocalDate = {
    val date = LocalDate.now()
    when match {
      case "ago" => date.minusDays(offset)
      case "from_now" => date.plusDays(offset)
      case _ => date
    }
  }

}

object DateHelper {
  val ago = "ago"
  val from_now = "from_now"
  implicit def convertIntToDateHelper(offset: Int): DateHelper = new DateHelper(offset)
}
