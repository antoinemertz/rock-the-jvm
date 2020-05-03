package lectures.part2oop

object AbstractDataTypes extends App {

  // ABSTRACT CLASS
  abstract class Animal() {
    val creatureType: String
    def eat: Unit
  }

  // an abstract class can't be instantiated
  // val animal = new Animal

  class Dog extends Animal {
    override val creatureType: String = "canine" // override is optional

    override def eat: Unit = println("crunch, crunch")
  }

  // TRAITS
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat(): Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a crocodile and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc eat dog

  // traits vs abstract classes
  // 1- can have both abstract and non abstract members
  // 2- traits can't have constructors parameters
  // 3- multiple traits may be inherited by the same class but scala class can have only one class inheritance
  // 4- traits = behavior and abstract class = type of thing


}
