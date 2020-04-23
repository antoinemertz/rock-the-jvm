package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // this is an expression
  println(x)

  var aVariable = 2
  aVariable += 3 // -= *= /= ... side effects

  // INSTRUCTIONS VS EXPRESSIONS
  // INSTRUCTIONS -> TO DO TO THE COMPUTERS
  // EXPRESSIONS -> HAS A VALUE
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // if expression
  println(aConditionValue)
  println(if (!aCondition) 5 else 2)

  // while and for loops are really discouraged
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // EVERYTHING IS AN EXPRESSION IN SCALA
  var aWeirdValue = (aVariable = 3) // aWeirdValue is of type Unit -> void
  println(aWeirdValue) // Unit is printed as ()

  // side effects examples : println(), whiles, reassignment

  // CODE BLOCKS
  val aCodeBlock = {
    val y = 2
    val z  = y + 1

    if (z>2) "hello" else "goodbye"
  }

  println(aCodeBlock)
  // println(z) // z is not visible outside of code block

  // EXERCISES
  // 1. Difference between "hello world" and println("hello world")
  // "hello world" is a variable of type string
  // println("hello world") prints in the console the string "hello world" but it is a variable of type Unit (expression of side effects)

  // 2. Which value take someValue and someOtherValue in the code below?

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 123 else 456
    42
  }

  // someValue == true & someOtherValue == 42
  println(someValue)
  println(someOtherValue)
}
