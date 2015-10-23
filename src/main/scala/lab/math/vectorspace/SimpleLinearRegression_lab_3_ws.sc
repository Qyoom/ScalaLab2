package lab.math.vectorspace
 
import breeze.linalg._
import lab.math.vectorspace.SimpleLinearRegression._
import breeze.numerics._
import breeze.stats.mean
 
object SimpleLinearRegression_lab_3_ws {

	// ------ Data ------------------------------- //
	// www.Aleks.com Simple linear regression
	// Sample observed input
	val X = DenseVector(2.2, 3.0, 4.3, 4.9, 6.0, 7.4, 7.9)
                                                  //> X  : breeze.linalg.DenseVector[Double] = DenseVector(2.2, 3.0, 4.3, 4.9, 6.0
                                                  //| , 7.4, 7.9)
  // Sample observed output
	val Y = DenseVector(1.1, 4.4, 3.1, 5.2, 7.5, 5.4, 9.0)
                                                  //> Y  : breeze.linalg.DenseVector[Double] = DenseVector(1.1, 4.4, 3.1, 5.2, 7.5
                                                  //| , 5.4, 9.0)
	
  // ------ Input Measures ------------------------------- //
  val n = Y.length                                //> n  : Int = 7
  val meanY = mean(Y)                             //> meanY  : Double = 5.1000000000000005
  val meanX = mean(X)                             //> meanX  : Double = 5.1
  
  // Variance: average of the squared differences from the Mean.
  val variance = pow(Y - meanY, 2).sum / n        //> variance  : Double = 5.937142857142857
  // Standard Deviation, i.e. average squared difference from the mean.
  val stdDev = sqrt(variance)                     //> stdDev  : Double = 2.4366253009321843
  
  // Convertion to the standard normal distribution (per Aleks)
  val z = (Y - meanY) / stdDev                    //> z  : breeze.linalg.DenseVector[Double] = DenseVector(-1.641614735950461, -0.
                                                  //| 28728257879133073, -0.8208073679752306, 0.04104036839876138, 0.9849688415702
                                                  //| 763, 0.1231211051962845, 1.600574367551699)
  
  // --------------------------------------------------------------------------- //
  // Referencing www.Aleks.com "Simple linear regression" for statistical formulas
  // Also, it turns out this series is pretty much exactly parallel to the presentation in ch.3
  // in James, Witten, et al (Intro to Statistical Learning)
 
  // ------ Model, prediction --------------- //
  // Derive the model from observations
  val model, (slope, intercept) = deriveModel(X, Y)
                                                  //> model  : (Double, Double) = (1.0357142857142858,-0.18214285714285694)
                                                  //| slope  : Double = 1.0357142857142858
                                                  //| intercept  : Double = -0.18214285714285694
  val predict = fitLine(model)_                   //> predict  : Double => Double = <function1>
  
  // Produce predicted outcomes from model based on observed input
  val predictions = for(x <- X) yield predict(x)  //> predictions  : breeze.linalg.DenseVector[Double] = DenseVector(2.0964285714
                                                  //| 28572, 2.9250000000000007, 4.271428571428572, 4.892857142857144, 6.03214285
                                                  //| 7142858, 7.4821428571428585, 8.000000000000002)
  mean(predictions)                               //> res0: Double = 5.100000000000001
  // Prediction output
 
  // ----- Output measures -------- //
  diagnosticLog(Y, predictions)                   //> Aug 19, 2015 4:42:26 PM com.github.fommil.jni.JniLoader liberalLoad
                                                  //| INFO: successfully loaded /var/folders/qk/q84p77h56y371pyw0vp69j1h0000gn/T/
                                                  //| jniloader2983585083280175817netlib-native_system-osx-x86_64.jnilib
                                                  //| SSE: 12.124999999999998
                                                  //| mean of redisuals: -9.516197353929913E-16
                                                  //| SST: 41.559999999999995
                                                  //| SSR: 29.43500000000001
                                                  //| SST - (SSE + SSR): -1.4210854715202004E-14
                                                  //| SSR/SST (r^2): 0.7082531280077
                                                  //| 1 - SSR/SST (Tibshirani version of r^2): 0.2917468719923
                                                  //| F: 0.2942318425586639
  
  // According to Tibshirani, cor(X,Y) should be equal to r^2 (i.e. SSR/SST) and this appears true. However, the version he presents (in course video) using 1 - SSR/SST is wrong.
  val r = correlation(X, Y)                       //> r  : Double = 0.8415777611175929
  val r_squared = pow(r, 2)                       //> r_squared  : Double = 0.7082531280077002
  
  // Compare via sum of squared residuals
  val SSE = sumSquaredResiduals(Y, predictions)   //> SSE  : Double = 12.124999999999998
  
  // Mean squared error. MSE is an unbiased estimate of the variance of the error term epsilon.
  // James, Witten, et al refer to this as RSE (Residual Standard Error)
  val MSE = SSE / (n - 2)                         //> MSE  : Double = 2.425
  
  // The square root of MSE is the standard error of the estimate, which is an unbiased estimate of the standard deviation of the error term epsilon.
  // James, Witten et al refer to this as the RSE (Residual Standard Error).
  val s = sqrt(MSE)                               //> s  : Double = 1.5572411502397436
  
  // Standard error of the estimated slope.
	val SEb1 = s / pow(X - meanX, 2).sum      //> SEb1  : Double = 0.05675077078133176
	
	// Standard error of the estimated intercept. See James, Witten et al p.66
	val SEb0 = s * ((1/n) + (pow(meanX, 2) / pow(X - meanX, 2).sum))
                                                  //> SEb0  : Double = 1.4760875480224391
	
	// Using this statistic, it is possible to do a test of the null hypothesis that the population slope equals zero, that is, that there is no linear relationship between the variables x and y.
	// See StatLearning (James, Witten, Hastie, Tibshirani)
	val t = slope / SEb1                      //> t  : Double = 18.250224119510733
	
	//James, Witten et all refer to this as the 95% confidence interval of the slope.
	// That is, there is approximately a 95 % chance that the interval...
	(slope - SEb1, slope + SEb1)              //> res1: (Double, Double) = (0.9789635149329541,1.0924650564956175)
	// ...will contain the true value of the slope.
	slope                                     //> res2: Double = 1.0357142857142858
	
	// Confidence interval of the intercept
	(intercept - SEb0, intercept + SEb0)      //> res3: (Double, Double) = (-1.658230405165296,1.2939446908795822)
	intercept                                 //> res4: Double = -0.18214285714285694
	
	// Regression Sum of Squares (per Aleks)
	val SSR = pow(predictions - meanY, 2).sum //> SSR  : Double = 29.43500000000001
  // With this statistic it is also possible to do a test of the null hypothesis, i.e. that there is no linear relationship between the variables x and y
	(SSR/1)/MSE                               //> res5: Double = 12.138144329896912
}
/*



*/