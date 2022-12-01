> scala 推崇不可变的集合，默认也是不可变集合。scala.collection.immutable
> 如果需要使用可变集合可以选择，scala.collection.mutable

#### 集合创建方式
```scala 
底层都是采用特殊的apply()，也可称为工厂方法实现创建。
Set("a", "b", "c")
List("a", "b", "c")
Map("k" -> "v")
```

#### Set集合使用
```scala
基本操作
-   `head` 返回集合第一个元素
-   `tail` 返回一个集合，包含除了第一元素之外的其他元素
-   `isEmpty` 在集合为空时返回true
对不可变Set进行增删操作，会产生一个新的set，原来的set并没有改变，这与List一样。
val set1 = Set("a", "b", "c")
val set2 = set1 + "d"
val set3 = set1 - "c"
并集
set1 ++ set2
交集
set1 & set2
差集
set1 &~ set2
```

#### Map集合的使用
```scala
keys   返回 Map 所有的键(key)
values 返回 Map 所有的值(value)
isEmpty 在 Map 为空时返回true
```

#### List集合的使用
```scala
基本操作和set集合差不多
// 空列表  
val empty: List[Nothing] = List()
val ints = List(1, 2, 3, 4, 5)
```

#### 方法名约定 ：
