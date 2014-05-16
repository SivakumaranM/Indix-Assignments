// 3) Reversing a list

 def reverse(xs: List[Int]) : List[Int] = xs match{
   case a::b => reverse(b) ++ List(a)
   case _ => List()
 }
 val myList = List(1,2,3,4,5)
 val revList = reverse(myList)