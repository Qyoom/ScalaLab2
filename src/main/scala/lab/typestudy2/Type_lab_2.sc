package lab.typestudy2

object Type_lab_2 {

	//type Froik = List[String]
	def Froik(x: Int*) = List(x: _*)          //> Froik: (x: Int*)List[Int]
	Froik(3,4,5)                              //> res0: List[Int] = List(3, 4, 5)
	//Froik("A","B","C") // Error
	
	// http://www.scala-lang.org/old/node/105.html
	abstract class Buffer {
		type T // abstract
		val element: T // deferred value definition
	}
	
	abstract class SeqBuffer extends Buffer {
		type U
		type T <: Seq[U]
		def length = element.length
	}
	
	abstract class IntSeqBuffer extends SeqBuffer {
		type U = Int
	}
	
	abstract class StringSeqBuffer extends SeqBuffer {
		type U = String
	}
	
	def newIntSeqBuffer(elems: Int*): IntSeqBuffer = {
		new IntSeqBuffer {
			type T = List[U]
			val element = elems.toList
		}
	}                                         //> newIntSeqBuffer: (elems: Int*)lab.typestudy2.Type_lab_2.IntSeqBuffer
	
	def newStringSeqBuffer(elems: String*): StringSeqBuffer = {
		new StringSeqBuffer {
			type T = List[U]
			val element = elems.toList
		}
	}                                         //> newStringSeqBuffer: (elems: String*)lab.typestudy2.Type_lab_2.StringSeqBuffe
                                                  //| r
	
	val buf = newIntSeqBuffer(7, 8, 9, 10)    //> buf  : lab.typestudy2.Type_lab_2.IntSeqBuffer = lab.typestudy2.Type_lab_2$$a
                                                  //| nonfun$main$1$$anon$1@a39ab89
	val sbuf = newStringSeqBuffer("A", "B", "C")
                                                  //> sbuf  : lab.typestudy2.Type_lab_2.StringSeqBuffer = lab.typestudy2.Type_lab_
                                                  //| 2$$anonfun$main$1$$anon$2@502cb49d
	
	buf.element                               //> res1: lab.typestudy2.Type_lab_2.buf.T = List(7, 8, 9, 10)
	buf.length                                //> res2: Int = 4
	
	sbuf.element                              //> res3: lab.typestudy2.Type_lab_2.sbuf.T = List(A, B, C)
	sbuf.length                               //> res4: Int = 3
}