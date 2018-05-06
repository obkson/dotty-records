#!/usr/bin/env bash

DOTTY_HOME=$1

if [ -z "$DOTTY_HOME" ]; then
  echo "$0: no DOTTY_HOME given" >&2
  echo "" >&2
  echo "usage: $0 DOTTY_HOME" >&2
  exit 1
fi

(cd $DOTTY_HOME && sbt "project dist-bootstrapped" pack)

DOTTY_LIB_SRC="$DOTTY_HOME/dist-bootstrapped/target/pack/lib"
DOTTY_LIB_TRG=repo/ch/epfl/lamp

mkdir -p "$DOTTY_LIB_TRG/dotty-library_0.8/0.8.0-bin-SNAPSHOT"  \
&& cp "$DOTTY_LIB_SRC/dotty-library_0.8-0.8.0-bin-SNAPSHOT.jar" "$DOTTY_LIB_TRG/dotty-library_0.8/0.8.0-bin-SNAPSHOT/dotty-library_0.8-0.8.0-bin-SNAPSHOT.jar"

mkdir -p "$DOTTY_LIB_TRG/dotty-compiler_0.8/0.8.0-bin-SNAPSHOT" \
&& cp "$DOTTY_LIB_SRC/dotty-compiler_0.8-0.8.0-bin-SNAPSHOT.jar" "$DOTTY_LIB_TRG/dotty-compiler_0.8/0.8.0-bin-SNAPSHOT/dotty-compiler_0.8-0.8.0-bin-SNAPSHOT.jar"

mkdir -p "$DOTTY_LIB_TRG/dotty-interfaces/0.8.0-bin-SNAPSHOT" \
&& cp "$DOTTY_LIB_SRC/dotty-interfaces-0.8.0-bin-SNAPSHOT.jar" "$DOTTY_LIB_TRG/dotty-interfaces/0.8.0-bin-SNAPSHOT/dotty-interfaces-0.8.0-bin-SNAPSHOT.jar"


# Uncomment to automatically purge the local maven cache:
# rm -r ~/.m2/repository/ch/epfl/lamp
