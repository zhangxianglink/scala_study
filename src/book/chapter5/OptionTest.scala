package book.chapter5

/**
 * 空指针预防
 */
object OptionTest {

  def optionValues(input: String) ={
    if (input == "abc") Some("123") else None
  }

  def main(args: Array[String]): Unit = {
    val maybeString = optionValues("dsds")
    val str = maybeString.getOrElse("nothing")
    println(s"$str")
  }


}
