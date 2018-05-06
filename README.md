## dotty-records

Polymorphic extensible records with structural subtyping for Dotty.

Using fork of Dotty 0.8 compiler: <https://github.com/obkson/dotty/tree/dotty-records>

### Example Usage

Assuming the library is [compiled](compiling) using the Dotty fork, fire up a dotty REPL with `dotty-records` on the class path:

```
dotr -classpath target/dotty-records-0.1-jar-with-dependencies.jar -repl
```

Import compiler-support library and dotty-records `Record` class implementation:

```
scala> import dotty.records._; import records.Record
```

Creating a record with two typed fields:

```
scala> val r = Record("name"->>"Morty", "age"->>14)
val r: records.Record{name: String; age: Int} = Record(name=Olle, age=14)
```

Type-safe field access using dot notation:

```
scala> r.name
val res0: String = "Morty"

scala> r.age
val res1: Int = 14

scala> r.foo
1 |r.foo
  |^^^^^
  |value `foo` is not a member of records.Record{name: String; age: Int}
```

Records can be extended with additional fields:

```
scala> val s = r + ("ssn"->>"AAA-GG-SSSS")
val s: records.Record{name: String; age: Int; ssn: String}
  = Record(name=Olle, age=14, ssn=AAA-GG-SSSS)
```

Extension is immutable:

```
scala> r
val r: records.Record{name: String; age: Int} = Record(name=Olle, age=14)
```

It also works in polymorphic contexts, given proof of extensibility in the form of a context bound:

```
def addSSN[R <: Record : Ext["ssn", String]](r: R, ssn: String) = r + ("ssn"->>ssn)

scala> addSSN(r)
val res2: records.Record{name: String; age: Int; ssn: String}
  = Record(name=Olle, age=14, ssn=AAA-GG-SSSS)
```


### Compiling

#### Step 1:

Clone the [Dotty 0.8 fork](https://github.com/obkson/dotty/tree/dotty-records) into some folder `DOTTY_HOME`

```
$ (cd DOTTY_HOME/.. && git clone git@github.com:obkson/dotty.git)
```

#### Step 2:

Build compiler and install / copy required artefacts into the local `repo`

```
$ ./install_deps.sh DOTTY_HOME
```

**NOTE!** If re-compiling the local dotty fork, the local maven cache must be purged before the change will take effect.
To facilitate this, uncommend the last line in `install_deps.sh`:

```
rm -r ~/.m2/repository/ch/epfl/lamp
```

#### Step 3:

Compile and package

```
mvn clean package
```

### Run Tests

TODO... at the moment unclear how to run junit tests with maven using local version of Dotty...

### Compile and run executable example program

```
mvn clean compile assembly:single
```

```
(cd target && java -jar dotty-records-0.1-jar-with-dependencies.jar)
```
