 //2) Finding the last but one element of a list

 def findPredicate(xs: List[Int]) : Int = xs match{
   case a::b::Nil => a
   case a::b => findPredicate(b)
   case _ => throw new NoSuchElementException
 }

 val myList = List(1,2,3,4,5)
 findPredicate(myList)