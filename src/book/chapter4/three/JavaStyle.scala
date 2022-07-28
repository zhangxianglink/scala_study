package book.chapter4.three

import scala.beans.BeanProperty

object JavaStyle {
  class person(@BeanProperty val name: String, @BeanProperty var age: String){
    @BeanProperty var sport: String = _
  }

  def main(args: Array[String]): Unit = {
    val son = new person("jack", "18")
    println(son.name)
    son.sport = "tennis"
    son.age = "20"
    println(s"${son.sport} ${son.age}")

    son.setAge("26")
    son.setSport("football")
    println(s"${son.sport} ${son.age}")
  }
}
