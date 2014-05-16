// 11) Lattice Paths

def fact(x: BigInt) : BigInt = {
  if(x == 0 || x == 1)
    1
  else
    x*fact(x-1)
}
val x=20
val y=20
val res=fact(x)
println(fact(x+y)/(fact(x)*fact(y)))