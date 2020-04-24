package exercices.part2oop

object OOBasics extends App {
  val jk_rowling = new Writer(name = "Rowling", surname = "J.K.", birthYear = 1965)
  val jrr_tolkien = new Writer(name = "Tolkien", surname = "J.R.R.", birthYear = 1892)

  val ecole_des_sorciers = new Novel(name = "Harry Potter à l'école des sorciers", releaseYear = 1997, author = jk_rowling)
  val chambre_des_secrets = new Novel(name = "Harry Potter et la chambre des secrets", releaseYear = 1998, author = jk_rowling)
  val prisonnier_azkaban = new Novel(name = "Harry Potter et le prisonnier d'Azkaban", releaseYear = 1999, author = jk_rowling)
  val coupe_de_feu = new Novel(name = "Harry Potter et la coupe de feu", releaseYear = 2000, author = jk_rowling)
  val ordre_phenix = new Novel(name = "Harry Potter et l'Ordre du Phénix", releaseYear = 2003, author = jk_rowling)
  val prince_sang_mele = new Novel(name = "Harry Potter et le Prince de sang-mêlé", releaseYear = 2005, author = jk_rowling)
  val reliques_mort = new Novel(name = "Harry Potter et les reliques de la Mort", releaseYear = 2007, author = jk_rowling)

  val communaute_anneau = new Novel(name = "La fraternité de l'anneau", releaseYear = 1954, author = jrr_tolkien)
  val deux_tours = new Novel(name = "Les deux tours", releaseYear = 1954, author = jrr_tolkien)
  val retour_roi = new Novel(name = "Le retour du Roi", releaseYear = 1955, author = jrr_tolkien)
  println(s"${jk_rowling.fullname} avait ${ecole_des_sorciers.authorAge} quand est sorti ${ecole_des_sorciers.name}")
  println(s"${deux_tours.author.fullname} avait ${deux_tours.authorAge} quand est sorti ${deux_tours.name}")

  println(s"${jk_rowling.fullname} a-t-il écrit le livre ${deux_tours.name} ? ${deux_tours.isWrittenBy(jk_rowling)}")
  println(s"${jk_rowling.fullname} a-t-il écrit le livre ${deux_tours.name} ? ${deux_tours.isWrittenBy(jrr_tolkien)}")

  val retour_roi_copy = retour_roi.copy(2003)
  println(s"${retour_roi_copy.author.fullname} a sorti une copie du livre ${retour_roi_copy.name} en ${retour_roi_copy.releaseYear}")


  val counter = new Counter(0)
  counter.increment
  counter.print
}

class Writer(val name: String, val surname: String, val birthYear: Int) {
  def fullname(): String = {
    surname + " " + name
  }
}

class Novel(val name: String, val releaseYear: Int, val author: Writer) {
  def authorAge(): Int = {
    releaseYear - author.birthYear
  }

  def isWrittenBy(author: Writer): Boolean = {
    this.author == author
  }

  def copy(new_release_year: Int): Novel = {
    new Novel(name = name, releaseYear = new_release_year, author = author)
  }
}

class Counter(n: Int) {
  def currentCount(): Int = {
    this.n
  }

  def increment(): Counter = {
    println("incrementing...")
    new Counter(n+1)
  }

  def decrement(): Counter = {
    println("decrementing..")
    new Counter(n-1)
  }

  /*
  IF INCREMENT AND DECREMENT FUNCTIONS ARE MORE COMPLEX AND WE WANT TO AVOID
  COPY PASTE ALL THE CODE JUST TO CHANGE ONE LITTLE THING WE CAN USE RECURSION
  def increment(i: Int = 1): Counter = {
    new Counter(n+i)
  }

  def decrement(i: Int = 1): Counter = {
    new Counter(n-i)
  }
   */

  def increment(i: Int): Counter = {
    if (i <= 0) {
      this
    } else {
      increment.increment(i-1)
    }
  }

  def decrement(i: Int): Counter = {
    if (i <= 0) {
      this
    } else {
      decrement.decrement(i-1)
    }
  }

  def print: Unit = println(this.currentCount)
}
