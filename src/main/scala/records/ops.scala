package records

import dotty.records.{Field, FieldTyper}

package object ops {

  implicit class RecordOps[R <: Record](r: R) extends AnyVal {
    def +[L <: String, V, F <: Selectable](l: L, v: V)(implicit erased ft: FieldTyper.Aux[l.type, V, F]): R & F = {
      new Record(r._data.updated(l, v)).asInstanceOf[R & F]
    }

    def +[L <: String, V, F <: Selectable](f: Field[L, V])(implicit erased ft: FieldTyper.Aux[L, V, F]): R & F = {
      new Record(r._data.updated(f.label, f.value)).asInstanceOf[R & F]
    }
  }

}
