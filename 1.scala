// 1) Finding the last element of a list

def findLastElement(xs: List[Int]) : Int = xs match{
  case a::Nil => return a
  case Nil => throw new NoSuchElementException()
  case a::b => return findLastElement(b)
}
val myList1 = List(1,2,3,4,5)
val myList2 = List(1)
println(findLastElement(myList1))
println(findLastElement(myList2))