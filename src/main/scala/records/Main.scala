package records

import dotty.records._
import records.ops._

object Main {

  def main(args: Array[String]): Unit = {
    val r = Record("name"->>"Morty", "age"->>14)
    val n = r.name
    val a = r.age

    println(r)
    println(n)
    println(a)

    val s = r + ("ssn", "AAA-GG-SSSS")

    println(s)
    println(s.ssn)

  }
}
