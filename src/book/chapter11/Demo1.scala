package book.chapter11

object Demo1 {

  def loop1(int: Int): Int = {
    if (int == 1)
    int
    else
     int * loop1(int -1)
  }

  def main(args: Array[String]): Unit = {
    println(loop1(5))
  }

}
