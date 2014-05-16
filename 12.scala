// 12) Lexicographic Permutations

def permute(str : String) : Seq[String] = {
  if(str.size == 1)
    Seq(str)
  else
    str.flatMap(x => permute(str.filterNot(_ == x)).map(x +))
}
val res = permute("0123456789")(999999)
println(res)