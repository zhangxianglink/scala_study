package book.chapter4.four

object OverrideTest {
  def main(args: Array[String]): Unit = {
    println(new subwayStation(12, 123456L, "授票处").toString)
  }
}

class station(val price: Int, val date: Long){
  override def toString  = {
    s"$price , $date"
  }
}

// 继承 override 字段不会重复生成
class subwayStation(override val price: Int, override val date: Long, val ticketOffice : String)
  // 类似super
  extends station(price,date) {
  override def toString  = {
    s"$price , $date, $ticketOffice"
  }
}