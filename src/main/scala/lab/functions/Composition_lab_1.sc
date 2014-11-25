package lab.functions

object Composition_lab_1 {
  
  type R = Double
  def compose(g:R=>R, h:R=>R) = {
  		(x:R) => g(h(x))
  }                                               //> compose: (g: lab.functions.Composition_lab_1.R => lab.functions.Composition_
                                                  //| lab_1.R, h: lab.functions.Composition_lab_1.R => lab.functions.Composition_l
                                                  //| ab_1.R)lab.functions.Composition_lab_1.R => lab.functions.Composition_lab_1.
                                                  //| R
  val f = compose({_-1}, {_*2})                   //> f  : lab.functions.Composition_lab_1.R => lab.functions.Composition_lab_1.R 
                                                  //| = <function1>
  f(2)                                            //> res0: lab.functions.Composition_lab_1.R = 3.0
  f(3)                                            //> res1: lab.functions.Composition_lab_1.R = 5.0
  f(f(3))                                         //> res2: lab.functions.Composition_lab_1.R = 9.0
  
  // Currying - obvious syntax
  def zscore(mean:R, sd:R) = (x:R) => (x - mean)/sd
                                                  //> zscore: (mean: lab.functions.Composition_lab_1.R, sd: lab.functions.Composit
                                                  //| ion_lab_1.R)lab.functions.Composition_lab_1.R => Double
  def normer = zscore(85, 8)                      //> normer: => lab.functions.Composition_lab_1.R => Double
  normer(80)                                      //> res3: Double = -0.625
  normer(75)                                      //> res4: Double = -1.25
  normer(85)                                      //> res5: Double = 0.0
  normer(90)                                      //> res6: Double = 0.625
  normer(70)                                      //> res7: Double = -1.875
  
  // Currying - sugar syntax
  def zscore2(mean:R, sd:R)(x:R):R = (x-mean)/sd  //> zscore2: (mean: lab.functions.Composition_lab_1.R, sd: lab.functions.Composi
                                                  //| tion_lab_1.R)(x: lab.functions.Composition_lab_1.R)lab.functions.Composition
                                                  //| _lab_1.R
  def normer2 = zscore2(85, 8)_                   //> normer2: => lab.functions.Composition_lab_1.R => lab.functions.Composition_l
                                                  //| ab_1.R
  normer2(80)                                     //> res8: lab.functions.Composition_lab_1.R = -0.625
  normer2(75)                                     //> res9: lab.functions.Composition_lab_1.R = -1.25
}