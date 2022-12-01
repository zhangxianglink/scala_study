covariant 协变。使你能够使用比原始指定类型的子类
Contravariance 逆变。使你能够使用比原始指定类型的父类。
scala比Java要严格，默认一个派生类型的集合不应该赋值给一个基类型的集合。

### 不变
```scala
class Pet(val name: String) {  
  override def toString: String = name  
}  
  
class Cat(override val name: String) extends Pet(name: String){  
  override def toString: String = name  
  def usePet(pets: Array[Pet]): Unit ={  
    println(s"${pets apply(1)}")  
  }}  
  
class Randall(override val name: String) extends Cat(name: String){  
  override def toString: String = name  
}  
  
class WhiteRandall(override val name: String) extends Randall(name: String){  
  override def toString: String = name  
}
// 后续会用到
var v1 = new Array [Int]
var v2 = new Array [Any]
v2 = v1 编译错误
```

### 泛型方法：协变，逆变，上下界
```scala
// 支持协变
def usePet2[T <: Pet](pets: Array[T]): Unit = {}
usePet2(Array(new Cat("this is a cat")))
// 支持逆变
def usePet2[T >: Cat](pets: Array[T]): Unit = {}
usePet3(Array(new Pet("this is a pet")))
// 上下界同时存在
def usePet4[T >: Randall <: Cat](pets: Array[T]): Unit = {}
// 转换实例
def copyPet[S , P >: S](son: Array[S], parent: Array[P]): Unit = {  
  for (p <- parent){  
    println(p)  
  }  println(" ----- 转化 ------")  
  for ( i <- 0 to (son.length -1) ){  
    val s = son.apply(i)  
    if(s.isInstanceOf[P]){  
      val pet: P = s.asInstanceOf[P]  
      parent.update(i, pet)  
    }  }  for (p <- parent){  
    println(p)  
  }
  }
// 泛型方法
def test[K,T](k: K, t: T): Unit ={  }
```

### 泛型类：协变，逆变，上下界
```scala
class Parent  
class Son extends Parent  
// 泛型类
class tmp1[T](t: T)  
// 协变类  
class tmp2[+T](t: T)  
val E = new tmp2[Son](new Son)  
val F:tmp2[Parent] = E
// 逆变类  
class tmp3[-T](t: T)
val C = new tmp3[Parent](new Parent)  
val D:tmp3[Son] = C
// 
```