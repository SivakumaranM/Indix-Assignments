// 9) Multiples of 3 and 5

def sum(xs : IndexedSeq[Int]) : Int = xs.foldLeft(0) {(m: Int, n:Int) => m+n }

val xs = 1 to 1000
println(sum(xs.filter(x => x%3==0 || x%5==0)))