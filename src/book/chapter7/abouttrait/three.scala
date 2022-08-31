package book.chapter7.abouttrait

/**
 * 利用特质实现装饰器模式
 */
object three {

  def main(args: Array[String]): Unit = {
    val check = new eleCheck with PhoneCheck with PcCheck
    check.check
  }

}

// 规范
abstract class check {
  def check = println(s" 基础检查 ")
}

// 装饰者
class eleCheck extends check {
  override def check: Unit = println(" 电器检查 ")
}

// 被装饰者，这些特质只能被混入那些扩展了相同基类的类中，以及我们可以在这些特质中使用基类的方法。
trait PcCheck extends check {
  override def check: Unit = {
    println(s" 检查电脑 ")
    super.check
  }
}
// 当super 在第一行使用 ： 最右边的特质充当了第一个处理器，响应了对 check()方法的调用。
// 然后，它们调用了 super.check()方法，并将调用转发到了它们左侧的特质。最终，最左侧的特质将会在实际的实例上调用 check()方法。
// 当super 在最后一行，以上流程倒退
trait PhoneCheck extends check {
  override def check: Unit ={
    println(s" 检查手机 ")
    super.check
  }
}

