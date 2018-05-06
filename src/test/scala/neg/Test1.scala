import dotty.records._; records._; ops._


object Test1 {

  // The lower bound is Nothing, so we can't be sure to not add an existing field
  def a[R <: Record{val foo: Any}](r: R) = {
    r + ("a" ->> 1) // error
  }

  // Lower bound without lower bound
  def b[S <: Record{val foo: Any}, R >: S <: Record](r: R) = {
    r + ("a" ->> 1) // error
  }

  // Concrete member has conflicting type
  def c(r: Record{val a: String}) = {
    r + ("a" ->> 1) // error
  }

  // NOT ok to overwrite class member, even though the type matches
  import scala.collection.immutable.HashMap
  def d(r: Record) = {
    r + ("_data"->>HashMap.empty) // error
  }

  val r = Record + ("a", 1)
  val ra = r.a
  val rb = r.b // error
}
