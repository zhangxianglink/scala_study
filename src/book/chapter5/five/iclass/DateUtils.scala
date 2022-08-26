package book.chapter5.five.iclass


object DateUtils {

  val ago = "ago"
  val from_now = "from_now"

  implicit class DateHelper(val offset: Int) extends AnyVal {
    import java.time.LocalDate
    def time(when: String) : LocalDate = {
      val date = LocalDate.now()
      when match {
        case "ago" => date.minusDays(offset)
        case "from_now" => date.plusDays(offset)
        case _ => date
      }
    }
  }

}
