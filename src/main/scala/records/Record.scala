package records

import dotty.records.{FieldTyper, Field}

class Record(val _data: Map[String, Any]) extends Selectable {

  def selectDynamic(name: String) = _data(name)

  override def equals(that : Any) = that match {
    case Record(d) => _data == d
    case _ => false
  }

  override def toString = s"Record(${_data.map{ case (l, v) => s"$l=$v" }.mkString(", ")})"
}

object Record {

  // def apply(args: (String, Any)*) = new Record(Map(args: _*))

  def unapply(d: Record): Option[Map[String, Any]] = Some(d._data)

  def apply[L1 <: String, V1, F1 <: Selectable]
  (f1: Field[L1, V1])
  (implicit erased ft1: FieldTyper.Aux[L1, V1, F1])
  : Record & F1 = {
    new Record(Map((f1.label, f1.value))).asInstanceOf[Record & F1]
  }

  def apply[L1 <: String, V1, F1 <: Selectable,
            L2 <: String, V2, F2 <: Selectable]
  (f1: Field[L1, V1],
   f2: Field[L2, V2])
  (implicit erased ft1: FieldTyper.Aux[L1, V1, F1],
                   ft2: FieldTyper.Aux[L2, V2, F2]
  ): Record & F1 & F2 = {
    new Record(Map((f1.label, f1.value), (f2.label, f2.value))).asInstanceOf[Record & F1 & F2]
  }

}
