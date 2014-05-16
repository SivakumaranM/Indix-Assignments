//6) Dropping every Nth element from a list

val myList = List(1,2,3,4,5,6,7,8,9)
val temp=myList.zipWithIndex.filterNot(x => ((x._2 +1)%3==0))
println(temp.map(x=> x._1))