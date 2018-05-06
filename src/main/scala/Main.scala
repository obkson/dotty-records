import dotty.records._

import records._, records.ops._
import hlist._, hlist.ops._

object Main {

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

    println("--------------")

    val l = ("name"->>"Morty") :*: ("age"->>14) :*: HNil()

    val ha: Int = l.get["age"]
    val hn: String = l.get["name"]

    println(l)
    println(ha)
    println(hn)

    val t = l.toRecord

    println(t)
    println(t.name)
    println(t.age)

  }
}
