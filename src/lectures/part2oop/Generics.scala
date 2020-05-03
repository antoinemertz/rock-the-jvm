package lectures.part2oop

object Generics extends App {
  // Generic class
  class MyList[+A] {
    //use the generic type A
    def add[B >: A](element: B): MyList[B] = ???
  }

  class MyMap[key, value]

  val listOfInt = new MyList[Int]
  val listOfString = new MyList[String]

  // Generic method

  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfInt = MyList.empty[Int]

  // Variance problem
  class Animal
  class Dog extends Animal
  class Cat extends Animal

  // yes, List[Cat] extends List[Animal]
  class CovariantList[+A]
  val cat: Animal = new Cat
  val cats: CovariantList[Animal] = new CovariantList[Cat]
  // can we add a new dog this list of cats?
  // with covariant list yes but not with invariant list
  class InvariantList[A]

  // Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types
  class Cage[A <: Animal](animal: Animal) // only accepts type A which is sub type of animal
  val cage = new Cage[Dog](new Dog)

  // expends MyList to be generic

}
