package lectures.part1bascis

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7,11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.toUpperCase)
  println(str.length)

  val aNumberString: String = "45"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')

  println(str.reverse)

  println(str.take(3))

  // STRING INTERPOLATORS

  // S-interpolators
  val name: String = "Antoine"
  val age: Int = 27
  val greeting: String = s"Hello, my name is $name and I'm $age years old."
  val anotherGreeting: String = s"Hello, my name is $name and I will be turning ${age+1} years old."

  println(anotherGreeting)

  // F-interpolators
  val speed = 1.234f
  val myth = f"$name can eat $speed%2.2f burgers per minute."
  println(myth)

  // raw-interpolator
  println(raw"This is a \n new line.")
  val escape = "This is a \n new line"
  println(raw"$escape")

}
