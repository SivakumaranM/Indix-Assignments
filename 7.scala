// 7) Extracting a slice from a list

val xs = List('a','b','c','d','e','f','g','h')
val temp=xs.zipWithIndex.filter(x => (x._2 >= 2 && x._2 < 5))
println(temp.map(x=>x._1))