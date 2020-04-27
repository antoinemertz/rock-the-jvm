package exercices.part2oop

abstract class MyList[+A] {
  /*
  head => first element of the list
  tail => reminder of the list
  isEmpty => is this list empty
  add(int) => new List with element added
  toString => a String representation of the list
   */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](e: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](e: B): MyList[B] = new Cons(h = e, t = EmptyList)

  def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](e: B): MyList[B] = new Cons(h = e, t = this)

  def printElements: String = {
    if (t.isEmpty) {
      h.toString
    } else {
      h.toString + ", " + t.printElements
    }
  }
}

object ListTest extends App {
  val list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, EmptyList)))

  println(list.head)
  println(list.tail.head)

  println(list.add(4).head)

  println(list.toString)
}

