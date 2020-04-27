package exercices.part2oop

abstract class MyList {
  /*
  head => first element of the list
  tail => reminder of the list
  isEmpty => is this list empty
  add(int) => new List with element added
  toString => a String representation of the list
   */

  def head: Int

  def tail: MyList

  def isEmpty: Boolean

  def add(e: Int): MyList

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList {
  def head: Int = throw new NoSuchElementException

  def tail: MyList = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add(e: Int): MyList = new Cons(h = e, t = EmptyList)

  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h

  def tail: MyList = t

  def isEmpty: Boolean = false

  def add(e: Int): MyList = new Cons(h = e, t = this)

  def printElements: String = {
    if (t.isEmpty) {
      h.toString
    } else {
      h.toString + ", " + t.printElements
    }
  }
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, EmptyList)))

  println(list.head)
  println(list.tail.head)

  println(list.add(4).head)

  println(list.toString)
}

