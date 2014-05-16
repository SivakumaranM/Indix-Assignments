// 4) Eliminating consecutive duplicates of list elements

def dupRemove(xs : List[Int]) : List[Int] = xs match{
   case a::b::c => {
     if(a == b)
     {
       dupRemove(b::c)
     }
     else
       List(a) ++ dupRemove(b::c)
   }
   case _ => throw new NoSuchElementException
 }
 val myList1 = List(1,1,1,2,8,6,6,3,4,5,5,5,5,6,6)
 val myList2 = List(1)
 val myList3 = List()
 dupRemove(myList1)
 dupRemove(myList2)
 dupRemove(myList3)