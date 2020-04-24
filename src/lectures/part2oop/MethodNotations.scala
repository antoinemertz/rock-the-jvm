package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favoritMovie: String) {
    def likeMovie(movie: String): Boolean = {
      favoritMovie == movie
    }

    def +(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    def unary_! : String = s"$name, what the heck?!"

    def isAlive: Boolean = true

    def apply(): String = s"My name is $name and i like $favoritMovie"
  }

  val mary = new Person(name = "Mary", favoritMovie = "Inception")

  println(mary.likeMovie("Inception"))

  // INFIX NOTATION OR OPERATOR NOTATION (SYNTACTIC SUGAR)
  println(mary likeMovie "Inception") // works for method with one parameter

  // "OPERATORS" IN SCALA
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS

  // PREFIX NOTATION
  val x = -1 // equivalent to 1.unary_
  val y = 1.unary_-

  // unary_ prefix only works with + - !

  println(!mary)
  println(mary.unary_!)

  // POSTFIX NOTATION
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply)
  println(mary()) // equivalent
}

