package book.chapter5.four

/**
 * 泛型方法
 *  *  covariant 协变。使你能够使用比原始指定的类型的子类
    Contravariance 逆变。使你能够使用比原始指定的类型的父类。
    Invariance 不变。你只能使用原始指定的类型，不能协变和逆变
    Upper bounds 上界。
    Lower bounds 下界。
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

  def usePet2[T <: Pet](pets: Array[T]): Unit = {
    println(s"support covariance: ")
    for (e <- pets){
      println(e)
    }
  }

  def usePet3[T >: Cat](pets: Array[T]): Unit = {
    println("逆变")
    for (e <- pets){
      println(e)
    }
  }

  def usePet4[T >: Randall <: Cat](pet: Array[T]): Unit = {
    println(s"上下界: $pet")
  }

  def main(args: Array[String]): Unit = {
    val cats = Array(new Cat("mark"), new Cat("lucy"))
//      协变失败  new Cat("a") usePet(cats)
    // 泛型上界，协变
    usePet2(cats)
    // 泛型下界，逆变
    usePet3(Array(new Pet("this is a pet")))
    // 逆变失败 usePet3(Array(new WhiteRandall("this is a pet")))

    // 上下界同时存在
    usePet4(Array(new WhiteRandall("边界外布偶猫")))
    usePet4(Array(new Randall("布偶猫")))
    usePet4(Array(new Pet("动物")))
    usePet4(Array(new Cat("猫")))


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
}

class Randall(override val name: String) extends Cat(name: String){
}

class WhiteRandall(override val name: String) extends Randall(name: String){
}