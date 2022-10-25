package book.chapter4.six

import scala.collection._
/**
 * Java： static 的意味初始化一次，所有实例共享一份的资源
 * scala: object 代表单例模式，
 */
object MarkerFactory {
  private val map = mutable Map (
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "yellow" -> new Marker("yellow")
  )

//  new Marker("a") test

  def getInstance(color: String) ={
    map getOrElse (color,new Marker(color))
  }
}

/**
 * MarkerFactory 是一个独立对象
 * Marker 是伴生对象，其名字和对应类的名字一致，可以相互访问私有字段和方法（比如将构造方法 private 声明）
 */
object Marker {
  private val map = mutable Map (
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "yellow" -> new Marker("yellow")
  )

  new Marker("test").test

  // 静态方法
  def getRoll: Iterable[String] = map.keys

  def getInstance(color: String) ={
    map getOrElse (color,new Marker(color))
  }

  // 简化new
  def apply(color: String) ={
    map getOrElseUpdate (color, op = new Marker(color))
  }
}

class Marker  (val color: String){
  println(s"init: $this")

  private def test = {
    println(s"伴生对象可用")
  }

   override def toString: String = {
    s"color: $color"
  }
}

object test {
  def main(args: Array[String]): Unit = {
 /*   println(MarkerFactory getInstance "blue")
    println(MarkerFactory getInstance "blue")
    println(MarkerFactory getInstance "red")
    println(MarkerFactory getInstance "red")
    println(MarkerFactory getInstance "green")*/

    println(Marker getInstance "blue")
    println(Marker getInstance "blue")
    println(Marker getInstance "red")
    println(Marker getInstance "red")
    println(Marker getInstance "green")

    println(Marker.getRoll)

    Marker.apply("简化new1")
    Marker("简化new2")


  }
}