package lab.probability

object Dice_lab_1 {
  // https://class.coursera.org/statinference-010/lecture/205
  /* What is the probability that the roll of a single fair 6-sided die is {1}
   * given that the roll resulted in an odd number, i.e. {1,3,5}?
   */
   
   // B = {1,3,5} = 3/6 = 1/2
   // A = {1} = 1/6
   // P(A|B) = P(AB) / P(B)
   
   val probB :Double = 1/2d                       //> probB  : Double = 0.5
   val probA :Double = 1/6d                       //> probA  : Double = 0.16666666666666666
   probA * probB / probB                          //> res0: Double = 0.16666666666666666
}