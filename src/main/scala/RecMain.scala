import dotty.records._

import records._, records.ops._

object RecMain {

  def main(args: Array[String]): Unit = {

    val r = Record("name"->>"Morty", "age"->>14)
    val rn = r.name
    val ra = r.age

    println(r)
    println(rn)
    println(ra)

    val s = r + ("ssn", "AAA-GG-SSSS")

    println(s)
    println(s.ssn)

  }
}
