package lab.probability

import math._

object CoinFlip_2 {
	def p(x: Int) = {
  		pow(1/2, x) * pow(1/2, 1-x)
  	}
	p(1) // heads
	p(0) // tails
}