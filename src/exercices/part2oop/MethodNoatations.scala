package exercices.part2oop

object MethodNoatations extends App {
  class Person(val name: String, favoritMovie: String, val age: Int = 0) {
    def likeMovie(movie: String): Boolean = {
      favoritMovie == movie
    }

    def +(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    def +(nickName: String): Person = {
      new Person(s"$name ($nickName)", favoritMovie)
    }

    def unary_! : String = s"$name, what the heck?!"

    def unary_+ : Person = new Person(name, favoritMovie, age+1)

    def isAlive: Boolean = true

    def learns(learning: String): String = s"$name learns $learning"

    def learnsScala: String = this learns "Scala"

    def apply(): String = s"My name is $name and i like $favoritMovie"

    def apply(n: Int): String = s"$name watched favorite movie $n times"
  }

  val mary = new Person(name = "Mary", favoritMovie = "Inception")
  val maryRockstar = mary + "the rockstar"
  println(maryRockstar.name)

  val maryOlder = +mary
  println(maryOlder.age)

  println(mary learnsScala)

  println(mary(5))
}
