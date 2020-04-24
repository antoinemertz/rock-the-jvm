package lectures.part2oop

object Objects{
  // Scala doesn't have class-level functionality ("static")
  // companions
  object Person {
    // 'class'/'static' = level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }
  class Person(val name: String) {

  }

  def main(args: Array[String]): Unit = {

    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = Singleton instance
    val mary = new Person ("mary")
    val john = new Person ("john")
    println (mary == john)

    val person1 = Person
    val person2 = Person
    println (person1 == person2)

    val bobbie = Person (mary, john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]) : Unit
  }
}
