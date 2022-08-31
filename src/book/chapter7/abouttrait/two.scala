package book.chapter7.abouttrait

/**
 * 实例混入
 */
object two {
  def main(args: Array[String]): Unit = {
    val cat = new cat("jack") with sport
    cat.jump()
  }

}

class animal
class cat(val name: String) extends animal

trait sport {
  val name: String
  def jump(): Unit = {
    println(s"$name you jump ")
  }
}