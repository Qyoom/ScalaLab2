package misc

object MultiplicationLab2 {

    def main(args: Array[String]): Unit = {
        
        for(i <- 1 to 10) {
            for(j <- 1 to 10) {
                val prod = (i*j).toString
                for(i <- 1 to 4 - prod.length) print(" ")
                print(prod)
            }
            println()
        }
        
    }

}