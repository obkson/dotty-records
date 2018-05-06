import dotty.records._; records._; ops._

object Test1 {

  // The lower bound guarantees R to only contain {b: Int}
  def a[R >: Record{val b: Int} <: Record](r: R) = r + ("a" ->> 1)

  // Ok to update with a value of a subtype of existing
  def b(r: Record{val a: String}) = r + ("a"->>"new value")

  // We know that R.f has a super type of String. Then the new value is a guaranteed subtype.
  def c[R >: Record{val a: String} <: Record](r: R) = r + ("a"->>"new value")

  def d[R <: Record](r: R)(implicit ev: Extensible[R, "a", Int]) = r + ("a"->>1)

  def e[R <: Record](r: R)(implicit ev1: Extensible[R, "a", Int], ev2: Extensible[R, "b", Int]) = r + ("a" ->> 1) + ("b" ->> 2)

  def f[R <: Record : Ext["a", Int] : Ext["b", Int]](r : R) = r + ("a"->>1) + ("b", 2)

  def g[R <: Record{val f: Int} : Ext["a", Int] : Ext["b", Int]](r: R) = {
    val s = r + ("a"->>1) + ("b"->>2)
    val sf = s.f
    val sa = s.a
    val sb = s.b
    s
  }

  def main(args: Array[String]): Unit = {
    val r = Record()
    val s = f(r)
    println(s.a: Int)
    println(s.b: Int)
  }
}
