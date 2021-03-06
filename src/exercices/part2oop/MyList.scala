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

  def map[B](transformer: MyTransformer[A,B]): MyList[B]

  def filter(predicate: MyPredicate[A]): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

 def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
}

case object EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](e: B): MyList[B] = new Cons(h = e, t = EmptyList)

  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing,B]): MyList[B] = EmptyList

  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = EmptyList

  // lists concatenation
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = EmptyList
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
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

  def map[B](transformer: MyTransformer[A,B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) {
      new Cons(h, t.filter(predicate))
    } else {
      t.filter(predicate)
    }
  }

  // lists concatenation
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
}

trait MyPredicate[-T] {
  def test(t: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(a: A): B
}

object ListTest extends App {
  val list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, EmptyList)))
  val anotherList: MyList[Int] = new Cons(4, new Cons(5, EmptyList))

  println(list.head)
  println(list.tail.head)

  println(list.add(4).head)

  println(list.toString)

  println(list.map(new MyTransformer[Int, Int] {
    override def transform(a: Int): Int = a*2}).toString)

  println(list.filter(new MyPredicate[Int] {
    override def test(a: Int): Boolean = a >= 2}).toString)

  println(list.filter(new MyPredicate[Int] {
    override def test(a: Int): Boolean = a % 2 == 0}).toString)

  println((list ++ anotherList).toString)

  println(list.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(a: Int): MyList[Int] = new Cons(a, new Cons(a+1, EmptyList))}).toString)
}

