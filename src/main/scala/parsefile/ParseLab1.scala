package parsefile

import scala.io.Source

object ParseLab1 {

    /*def main(args: Array[String]): Unit = {
        val file = "/Users/hieronymus/Development/Workspace/ScalaLab/src/parsefile/data/example_data_1.txt"
        val source = Source.fromFile(file)
        val fileLinesList = source.getLines.toList
        val records = groupRecords(fileLinesList)
        println(records)
    }
    
    def groupRecords(lines: List[String]): List[String] = {
		lines match {
		    case Nil => Nil
		    case x :: xs => { // x is an individual line
		        val tokens = x.split("\\s+")
		        if(tokens[0] == "Header") {
		            x :: groupRecords(xs)
		        }
		        else Nil
		        //x :: groupRecords(xs)
		    }
		}
    }*/

}