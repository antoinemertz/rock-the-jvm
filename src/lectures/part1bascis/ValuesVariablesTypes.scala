package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // VAL ARE IMMUTABLE

  // COMPILER CAN INFER TYPE

  val aString: String = "Hello, Scala" // double quotes

  val aBoolean: Boolean = true // or false

  val aCharacter: Char = 'a' // single quotes

  val aShort: Short = 4321
  val aLong: Long = 987654321123456789L
  val aFloat: Float = 3.96f
  val aDouble: Double = 3.96

  // VARIABLES
  var aVar: Int = 42
  aVar = 12
  // variables are used for side effects


}
