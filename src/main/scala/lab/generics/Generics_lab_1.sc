package lab.generics

object Generics_lab_1 {
  println("Generics lab from Scala Cheatsheet")   //> Generics lab from Scala Cheatsheet
  
  def maplike[T](g:T=>T)(seq:List[T]) = seq.map(g)//> maplike: [T](g: T => T)(seq: List[T])List[T]
  def ml1 = maplike[Double](x => x*2)_            //> ml1: => List[Double] => List[Double]
  ml1(List(8.0, 3.5))                             //> res0: List[Double] = List(16.0, 7.0)
  
  def maplike2[T](g:T=>T) = (seq:List[T]) => seq.map(g)
                                                  //> maplike2: [T](g: T => T)List[T] => List[T]
  def ml2 = maplike2[Double](x => x*2)            //> ml2: => List[Double] => List[Double]
  ml2(List(8.0, 3.5))                             //> res1: List[Double] = List(16.0, 7.0)
}