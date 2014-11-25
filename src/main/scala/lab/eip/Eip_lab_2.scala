package lab.eip

// http://etorreborre.blogspot.com/2011/06/essence-of-iterator-pattern.html
object Eip_lab_2 extends App {
    
  trait Functor[F[_]] {
    def fmap[A, B](f: A => B): F[A] => F[B]
  }
  
  trait Pointed[F[_]] {
    def point[A](a: => A): F[A]
  }
  
  object PointedList extends Pointed[List] {
    def point[A](a: => A) = List(a)
  }
  
  val huh = PointedList.point("Howdy") // huh: List[String] 
  println(huh) // List(Howdy)
  
  trait PointedFunctor[F[_]] {
    val functor: Functor[F]
    val pointed: Pointed[F]

    def point[A](a: => A): F[A] = pointed.point(a)

    def fmap[A, B](f: A => B): F[A] => F[B] = functor.fmap(f)
  }
  
  trait Applic[F[_]] {
    def applic[A, B](f: F[A => B]): F[A] => F[B]
  }
  
  trait Applicative[F[_]] {
    val pointedFunctor: PointedFunctor[F]
    val applic: Applic[F]

    def functor: Functor[F] = new Functor[F] { 
      def fmap[A, B](f: A => B) = pointedFunctor fmap f 
    }
    def pointed: Pointed[F] = new Pointed[F] { 
      def point[A](a: => A) = pointedFunctor point a 
    }

    def fmap[A, B](f: A => B): F[A] => F[B]     = functor.fmap(f)
    def point[A](a: => A): F[A]                 = pointed.point(a)
    def apply[A, B](f: F[A => B]): F[A] => F[B] = applic.applic(f)
  }

}





