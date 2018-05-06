import dotty.records._; records._; ops._

object Test2 {

  // Using two arguments
  val r = Record + ("a", 1) + ("b", "two")
  val ra = r.a
  val rb = r.b

  // using arrows
  val s = Record + ("a"->>1) + ("b"->>"two")
  val sa = s.a
  val sb = s.b

  // Mixed
  val t = Record + ("a"->>1) + ("b", "two") + ("c"->>3) + ("d", "four")
  val ta = t.a
  val tb = t.b
  val tc = t.c
  val td = t.d

  // Benchmark
  var u: Record {
    val f1: Int;
    val f2: Int;
    val f3: Int;
    val f4: Int;
    val f5: Int;
    val f6: Int;
    val f7: Int;
    val f8: Int;
    val f9: Int;
    val f10: Int;
    val f11: Int;
    val f12: Int;
    val f13: Int;
  } = Record +
    ("f1", 1) + ("f2", 2) + ("f3", 3) + ("f4", 4) + ("f5", 5) + ("f6",  6) + ("f7", 7) + ("f8", 8) +
    ("f9", 9) + ("f10", 10) + ("f11", 11) + ("f12", 12) + ("f13", 13)

  val v: Record {
    val f1: Int;
    val f2: Int;
    val f3: Int;
    val f4: Int;
    val f5: Int;
    val f6: Int;
    val f7: Int;
    val f8: Int;
    val f9: Int;
    val f10: Int;
    val f11: Int;
    val f12: Int;
    val f13: Int;
    val f14: Int;
    val f15: Int;
  } = u + ("f14"->>14) + ("f15"->>15)

}

