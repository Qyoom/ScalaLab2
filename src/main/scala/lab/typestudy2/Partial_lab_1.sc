package lab.typestudy2

object Partial_lab_1 {
	// http://danielwestheide.com/blog/2013/01/30/the-neophytes-guide-to-scala-part-11-currying-and-partially-applied-functions.html
	
  case class Email(
	  subject: String,
	  text: String,
	  sender: String,
	  recipient: String)
	type EmailFilter = Email => Boolean
	
	val email1 = Email("Stuff", "howdy", "Bing", "Biff")
                                                  //> email1  : lab.typestudy2.Partial_lab_1.Email = Email(Stuff,howdy,Bing,Biff)
	/*
	type IntPairPred = (Int)(Int) => Boolean
	def sizeConstraint(pred: IntPairPred, n: Int, email: Email) = pred(email.text.size, n)
  
  def huh(x:Int) (y:Int): Boolean = true
  val huh2:IntPairPred = huh(1)_
  
  sizeConstraint(huh2_, 5, email1)
  */
}