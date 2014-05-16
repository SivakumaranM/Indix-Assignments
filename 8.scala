// 8) A list of prime numbers

def isPrime(xs : Int) : Boolean = {
  var i=2
  var flag = true
  while(i < (xs/2)+1)
  {
    if((xs%i) == 0)
    {
      flag=false
    }
    i+=1
  }
  return flag
}
def generateList(m: Int, n: Int, myList : List[Int]) : List[Int] = {
  if(m==n)
      return myList
  else {
    generateList(m+1, n,  myList ++ List(m))
  }
}
val res = List()
val list1 = generateList(1, 5, res).filterNot(x => isPrime(x)==false || x==1)
println(list1)
