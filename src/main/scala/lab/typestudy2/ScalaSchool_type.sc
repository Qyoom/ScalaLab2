package lab.typestudy2

// https://twitter.github.io/scala_school/type-basics.html
object ScalaSchool_type {
  
  val any = 2 :: 1 :: "bar" :: "foo" :: Nil       //> any  : List[Any] = List(2, 1, bar, foo)
  any.head                                        //> res0: Any = 2
  
  def drop1[A](l: List[A]) = l.tail               //> drop1: [A](l: List[A])List[A]
  drop1(List("a", "b", "c"))                      //> res1: List[String] = List(b, c)
  drop1(List(1, 2, 3))                            //> res2: List[Int] = List(2, 3)
  drop1(List(1d, 2, 3))                           //> res3: List[Double] = List(2.0, 3.0)
  drop1(List(true, false))                        //> res4: List[Boolean] = List(false)
  drop1(List(Array(1,2), Array("a","b"), Array(true, false)))
                                                  //> res5: List[Array[_ >: Boolean with String with Int]] = List(Array(a, b), Arr
                                                  //| ay(true, false))
  // ------ Variance -------------- //
  
  class Covariant[+A]
  
  val cov: Covariant[AnyRef] = new Covariant[String]
                                                  //> cov  : lab.typestudy2.ScalaSchool_type.Covariant[AnyRef] = lab.typestudy2.Sc
                                                  //| alaSchool_type$$anonfun$main$1$Covariant$1@2838305b
  //val covNot:Covariant[String] = new Covariant[AnyRef] // Error
  
  class Contravariant[-A]
  
  val cont: Contravariant[String] = new Contravariant[AnyRef]
                                                  //> cont  : lab.typestudy2.ScalaSchool_type.Contravariant[String] = lab.typestud
                                                  //| y2.ScalaSchool_type$$anonfun$main$1$Contravariant$1@39367a2c
  //val contNot: Contravariant[AnyRef] = new Contravariant[String] // Error
  
  // ------ Function return types are contravariance ------------- //
  
  class Animal { val sound = "rustle" }
  class Bird extends Animal { override val sound = "call" }
  class Chicken extends Bird { override val sound = "cluck" }
  class Duck extends Bird { override val sound = "quack" }
  val getTweet: (Bird => String) = ((a: Animal) => a.sound )
                                                  //> getTweet  : lab.typestudy2.ScalaSchool_type.Bird => String = <function1>
  
  getTweet(new Chicken)                           //> res6: String = cluck
  getTweet(new Bird)                              //> res7: String = call
  getTweet(new Duck)                              //> res8: String = quack
  //getTweet(new Animal) // Error
  
  val hatchChick: (() => Bird) = (() => new Chicken)
                                                  //> hatchChick  : () => lab.typestudy2.ScalaSchool_type.Bird = <function0>
  val hatchDuckling: (() => Bird) = (() => new Duck)
                                                  //> hatchDuckling  : () => lab.typestudy2.ScalaSchool_type.Bird = <function0>
  getTweet(hatchChick())                          //> res9: String = cluck
  getTweet(hatchDuckling())                       //> res10: String = quack
  
  // ------ Bounds --------------- //
  
  // def cacophony[T](things: Seq[T]) = things map (_.sound) // Error: value sound is not a member of type parameter T
  
  def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)
                                                  //> biophony: [T <: lab.typestudy2.ScalaSchool_type.Animal](things: Seq[T])Seq[
                                                  //| String]
  val menagerie = Seq(new Animal, new Bird, new Chicken, new Duck)
                                                  //> menagerie  : Seq[lab.typestudy2.ScalaSchool_type.Animal] = List(lab.typestu
                                                  //| dy2.ScalaSchool_type$$anonfun$main$1$Animal$1@3edfb094, lab.typestudy2.Scal
                                                  //| aSchool_type$$anonfun$main$1$Bird$1@4fc1e4cb, lab.typestudy2.ScalaSchool_ty
                                                  //| pe$$anonfun$main$1$Chicken$1@4293f455, lab.typestudy2.ScalaSchool_type$$ano
                                                  //| nfun$main$1$Duck$1@7f8e1a98)
  for(a <- menagerie) yield a.sound               //> res11: Seq[String] = List(rustle, call, cluck, quack)
  	
  	biophony(menagerie)                       //> res12: Seq[String] = List(rustle, call, cluck, quack)
}
/*



*/