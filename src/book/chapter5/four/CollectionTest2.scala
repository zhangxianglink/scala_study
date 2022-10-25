package book.chapter5.four

/**
 * * 泛型类
 *  covariant 协变。使你能够使用比原始指定的类型的子类
    Contravariance 逆变。使你能够使用比原始指定的类型的父类。
    Invariance 不变。你只能使用原始指定的类型，不能协变和逆变
    Upper bounds 上界。
    Lower bounds 下界。
 */
object CollectionTest2 {

    def main(args: Array[String]): Unit = {
        val A = new tmp1[Parent](new Parent)
//        val B: tmp1[Son] = A

        val C = new tmp3[Parent](new Parent)
        val D:tmp3[Son] = C

        val E = new tmp2[Son](new Son)
        val F:tmp2[Parent] = E

        test(C,E)
    }

    def test[K,T](k: K, t: T): Unit ={
        println(k.getClass)
        println(t.getClass)
    }
}

class Parent
class Son extends Parent

class tmp1[T](t: T)
// 协变类
class tmp2[+T](t: T)
// 逆变类
class tmp3[-T](t: T)
