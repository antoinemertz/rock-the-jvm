package lectures.part2oop

object CaseClasses extends App {
  // 1. with case class, class parameters are promoted to filed
  // 2. sensible toString
  // 3. equals and hashCode implemented
  // 4. have handy copy method and this copy method accepts parameters
  // 5. have companion object
  // 6. are serializable (useful with akka framework)
  // 7. have extractor patterns
  case class Person(name: String, age: Int)

  val jim = new Person("Jim", 34)
  println(jim.name)
  println(jim.toString)

  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  val jim3 = jim.copy(age = 35)
  println(jim3)

  val thePerson = Person // companion object
  val mary = Person("mary", 24) // companion object also

  // case object exist also
  case object UnitedKingdom {
    def name: String = "The GB and NI"
  }
}
