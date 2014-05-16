//Duplicating the elements of a list a given number of times

def tempfunc(count: Int, x: Int) : List[Int] = {
  if(count > 0)
     List(x) ++ tempfunc(count-1, x)
  else
      List()
}

def duplicateList(count: Int, xs : List[Int]) : List[Int] = {
  xs.flatMap(x => tempfunc(count, x))
}

val myList = List(1,2,3,4,5)
duplicateList(3, myList)
duplicateList(3, List(1))