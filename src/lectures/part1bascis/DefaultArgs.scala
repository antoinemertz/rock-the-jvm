package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {
  @tailrec
  def trFactorial(n: Int, acc: Int): Int = {
    if (n <= 1) {
      acc
    }
    else {
      trFactorial(n-1, n*acc)
    }
  }

  println(trFactorial(5,1))

  // ALWAYS CALL THE FUNCTION WITH acc=1...

  @tailrec
  def trFactorialWithDefaultArgs(n: Int, acc: Int = 1): Int = {
    if (n <= 1) {
      acc
    }
    else {
      trFactorialWithDefaultArgs(n-1, acc = n*acc)
    }
  }

  println(trFactorialWithDefaultArgs(5))
}
