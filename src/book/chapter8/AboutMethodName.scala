package book.chapter8

/**
 * 后缀运算
 */
object AboutMethodName {

  def main(args: Array[String]): Unit = {
    val park = new Park
    val tree = new Tree

    // 1.方法名以冒号（:）结尾，那么调用的目标是该操作符后面的实例
    park ? tree
    park ?: tree

    park n tree
    park n_: tree

    // +、-、!、~ 可以作为前置操作符，转换成名为 unary_操作符 的方法调用
    //  前缀操作符 unary_-, 即负操作符 -x
    val sample = new Sample
    + sample
    - sample
    ~ sample
    ! sample

    val result = (65).unary_-

    // Displays output
    println(result)
  }

}

class Park {
  // 操作符
  def ?(tree: Tree) {println("park != tree")}
  // 字母形式
  def n(tree: Tree){ println(" the park behind many trees")}
}

class Tree {
  def ?:(park: Park) {println("tree != park")}
  def n_:(park: Park){ println("many trees in front of the park")}
}

class Sample {
  def unary_+() = {

  }
  def unary_-() = {

  }
  def unary_!() = {

  }
  def unary_~() = {

  }

}