import dotty.records._; records._; ops._

object Test1 {
  val r = Record + ("a"->>1)
  val s = Record + ("a"->>1)
  val t = Record + ("a"->>2)

  val addr = Record +
    ("street"->>"N/A") +
    ("city"->>"Seattle") +
    ("state"->>"Washington") +
    ("country"->>"USA") +
    ("universe"->>"Dimension C-137")

  val p = Record +
    ("name"->>"Morty") +
    ("age"->>14) +
    ("address"->>addr)



  def main(args: Array[String]) = {
    println(r.a)
    println(p.name)
    println(p.age)
    println(p.address.universe)
    println(r == s)
    println(r == t)
  }

  /*
   * Expected output:
   *
   * 1
   * Morty
   * 14
   * Dimension C-137
   * true
   * false
   *
   * */
}
