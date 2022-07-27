package book.chapter3.one

object Hello {
  def turn (a: String): String ={
    s"---- $a"
  }

  def main(args: Array[String]): Unit = {
    print(turn("sd"))
  }

}


object str{
  def main(args: Array[String]): Unit = {
    val split = "-";
    print( "字符串的拼接不需要 + ：")
    for (i <- 1 to 3){
      print(s"$i  $split")
    }
  }
  // to 是函数，没有参数/一个参数 可以省略 . ()
  // 多个参数 () 必选， .可选
  print (Hello turn "jack")
}

object hello2{
  def loop(): Unit ={
    // 函数式风格代码
    1 to 3 foreach(i => println(s"$i"))
  }
  def main(args: Array[String]) {
    loop()
  }
}

