package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)

  println(person)
  // println(person.age) -> age is class parameter not a class fields, can't be access
  // and you can transform parameter to field by adding val in front of the parameter
  println(person.name)
  println(person.greet("David"))
  println(person.greet)
}

class Person(val name: String, age: Int) { // constructor
  // body
  val x = 2 // field

  println(1+2)

  // method
  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi $name")
  }

  // overloading
  def greet(): Unit = println(s"Hi, i am $name")

  // multiple constructors (overloading constructors)
  def this(name: String) = this(name, 0)
}