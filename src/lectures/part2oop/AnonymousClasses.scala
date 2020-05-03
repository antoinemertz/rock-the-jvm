package lectures.part2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahaha")
  }

  println(funnyAnimal.getClass)
  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal {
    override def eat: Unit = println("ahahahahaha")
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  class Person(val name: String) {
    def hi: String = s"Hi, my name is $name"
  }

  val jim: Person = new Person("Jim") {
    override def hi: String = s"Hi, my name is $name, how can I help"
  }

  println(jim.hi)
}
