package book.chapter5

/**
 * 返回两个不同类型结果
 */
object EnterTest {

  def differentValue(input: Int) = {
    if (input > 0) Right("字符串类型") else Left(new event(age = 22, user = "jack"))
  }

  def display(input: Either[event, String]) = {
    input match {
      case Left(value) => println(s" display $value")
      case Right(value) => println(s" display $value")
    }
  }

  def main(args: Array[String]): Unit = {
    println(differentValue(-1))
    println(differentValue(1))

    display(differentValue(-1))
    display(differentValue(1))

  }
}

class event(val user: String, val age: Int){
  override def toString: String = {
    s"event{ user: $user, age: $age}"
  }
}
