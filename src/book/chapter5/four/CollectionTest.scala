package book.chapter5.four

/**
 * 协变：接收一个基类实例的集合的地方，使用一个子类实例的集合（covariance）
 * 逆变：以上（contravariance）
 * 默认情况下scala都不支持
 */
object CollectionTest {

  def main(args: Array[String]): Unit = {
    val cats = Array(new Cat("mark"), new Cat("lucy"))
//      协变失败  new Cat("a") usePet(cats)
    new Cat("b") usePet2(cats)
  }

}

class Pet(val name: String) {
  override def toString: String = name
}

class Cat(override val name: String) extends Pet(name: String){
  def usePet(pets: Array[Pet]): Unit ={
    println(s"${pets apply(1)}")
  }

  def usePet2[T <: Pet](pets: Array[T]): Unit = {
    println(s"support covariance: ")
    for (e <- pets){
      println(e)
    }
  }
}
