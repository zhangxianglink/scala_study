package book.chapter7.abouttrait

object AboutFriend {
  def main(args: Array[String]): Unit = {
    // java 的风格，通过单继承，获得listen
    val man = new Man("jack.l")
    man.listen()
    // scala trait
    val et = new ET("卡车司机")
    et.speck()
    val lgbt = new LGBT("独角兽")
    lgbt.speck()
  }

}


class Human(val name: String) {
  def listen() = {
    println(s"your friend $name is listening")
  }
}
class Man(override val name: String) extends Human(name) {}
class Woman(override val name: String) extends Human(name) {}

trait Friend {
  val name : String
  def speck(): Unit = {
    println(s"your friend $name is specking")
  }
}

// 加入特质trait
class ET(val name: String) extends Friend {}
class LGBT(override val name: String) extends Human(name) with Friend {
  override def speck(): Unit = {
    println(s"your friend $name is specking too")
  }
}