package lab.math.aleks.introstats

import breeze.stats.distributions.Gaussian

object Probability_density_1_ws {
  
  // David Hall answered my question on StackExchange.
  // http://stackoverflow.com/questions/28098783/breeze-linear-algebra-probability-distribution/28099508?iemail=1&noredirect=1#28099508
  
  val gau_dist = new Gaussian(0.0, 1.0)           //> gau_dist  : breeze.stats.distributions.Gaussian = Gaussian(0.0, 1.0)
  gau_dist.cdf(-1.8)                              //> res0: Double = 0.03593031911292566
  // P(Z > -1.80) = 0.964
  1 - gau_dist.cdf(-1.8)                          //> res1: Double = 0.9640696808870743
  // P(Z <= -1.95) = 0.026
  gau_dist.cdf(-1.95)                             //> res2: Double = 0.025588059521638562
  // P(1.36 < Z < 2.13) = 0.070
  gau_dist.cdf(2.13) - gau_dist.cdf(1.36)         //> res3: Double = 0.07032915526348005
}