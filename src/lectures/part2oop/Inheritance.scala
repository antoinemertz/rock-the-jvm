package lectures.part2oop

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunchcrunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adults(name: String, age: Int, idCard: String) extends Person(name, age)

  class Child(name: String, age: Int, toy: String) extends Person(name)

  // overriding
  // super
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)
  val anotherDog = new Dog("k9")
  println(anotherDog.creatureType)

  // type substitution
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // preventing overrides
  // 1- use final:
  // a- on the method: final def eat(): ...
  // b- on the class: final class Animal ...
  // 2- seal the class = extend classes in THIS FILE, prevent extensions in other files: sealed class Animal ...
}
