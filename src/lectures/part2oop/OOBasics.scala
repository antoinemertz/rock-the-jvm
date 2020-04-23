package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)

  println(person)
}

class Person(name: String, age: Int) // constructor