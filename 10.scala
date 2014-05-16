// 10) English number words

def printWord(num : Int) : String = num match{
  case 1 => "one"
  case 2 => "two"
  case 3 => "three"
  case 4 => "four"
  case 5 => "five"
  case 6 => "six"
  case 7 => "seven"
  case 8 => "eight"
  case 9 => "nine"
  case 0 => "zero"
}

def printFunc(x: List[Int]) : String = x match {
  case a::b::Nil => printWord(a) + "-" + printWord(b)
  case a::b::c => printWord(a) + "-" + printWord(b) + "-" + printFunc(c)
  case a::Nil => printWord(a)
  case Nil => ""

}

def reverse(x: Int) : List[Int] = {
  if(x > 0)
  {
      return reverse(x/10) ++ List(x%10)
  }
  else
      return List()
}
println(printFunc(reverse(153)))
println(printFunc(reverse(1)))
println(printFunc(reverse(12)))