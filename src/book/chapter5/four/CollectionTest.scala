package book.chapter5.four

/**
 * 协变：接收一个基类实例的集合的地方，使用一个子类实例的集合（covariance）
 * 逆变：以上（contravariance）
 * 默认情况下scala都不支持
 */
object CollectionTest {

  def copyPet[S , P >: S](son: Array[S], parent: Array[P]): Unit = {
    for (p <- parent){
      println(p)
    }
    println(" ----- 转化 ------")
    for ( i <- 0 to (son.length -1) ){
      val s = son.apply(i)
      if(s.isInstanceOf[P]){
        var pet: P = son.apply(i).asInstanceOf[P]
        parent.update(i, pet)
      }
    }

    for (p <- parent){
      println(p)
    }
  }

  def main(args: Array[String]): Unit = {
    val cats = Array(new Cat("mark"), new Cat("lucy"))
//      协变失败  new Cat("a") usePet(cats)
//    new Cat("b") usePet2(cats)

    val pets = Array(new Pet("a"), new Pet("b"))

    copyPet(cats, pets)
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
