package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      //println("Computing factorial of " + n + " - I first need factorial of " + factorial(n-1))
      val result = n * factorial(n - 1)
      //println("Computed factorial of " + n)
      result
    }
  }


  println(factorial(10))

  // Recursion stacks lot of computation in memory to get the result
  // If the number is too big, the recursion failed with StackOverflowError
  // factorial(10000)

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) {
        accumulator
      } else {
        factHelper(x-1, x*accumulator)
      }
    }
    factHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10*1)
    = factHelper(8, 9*10*1)
    = ...
    = factHelper(2, 3*4*5*6*7*8*9*10*1)
    = factHelper(1, 2*3*4*5*6*7*8*9*10*1)
    = 2*3*4*5*6*7*8*9*10*1 = 10!
   */

  println(anotherFactorial(10000))

  // TAIL RECURSION -> factHelper doesn't need to stack intermediate results to compute the results: use recursive call as the LAST expression
  // add @tailrec before factHelper to be sure that we want to use tail recursive, and if we are not the compiler will crash

  // WHEN YOU NEED LOOPS, USE TAIL RECURSION

  /*
  1. Concatenate a string n times
  2. isPrime function tail recursive
  3. Fibonacci function tail recursive
   */

  @tailrec
  def concatenateStrings(aString: String, n: Int, acc: String): String = {
    if (n <= 0) {
      acc
    } else {
      concatenateStrings(aString, n-1, acc+aString)
    }
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(isStillPrime: Boolean, i: Int): Boolean = {
      if (!isStillPrime) {
        false
      } else if (i <= 1) {
        true
      } else {
        isPrimeTailRec((n%i != 0), i-1)
      }
    }
    isPrimeTailRec(true, n/2)
  }

  println(isPrime(2003))
  println(isPrime(37*23))

  @tailrec
  def fibonacci(n: Int, prev1: Int, prev2: Int): Int = {
    if (n <= 2) {
      prev1
    } else {
      fibonacci(n - 1, prev1 + prev2, prev1)
    }
  }

  // OTHER SOLUTION

  def fibonacciForward(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      {
        if(i >= n) {
          last
        }
        else {
          fiboTailrec(i + 1, last + nextToLast, last)
        }
      }

    if (n <= 2) {
      1
    }
    else {
      fiboTailrec(2, 1, 1)
    }
  }

  /*
  fibonacci(8,1,1) = fibonacci(7,2,1)
  = fibonacci(6,3,2)
  = fibonacci(5,5,3)
  = fibonacci(4,8,5)
  = fibonacci(3,13,8)
  = fibonacci(2,21,13)
   */

  println(fibonacci(8, 1, 1)) // 1 1 2 3 5 8 13 21
  println(fibonacciForward(8)) // 1 1 2 3 5 8 13 21

}
