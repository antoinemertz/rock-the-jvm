package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + ' ' + b // string concatenation
  }

  println(aFunction("hello", 3))

  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction) // can be call without parenthesis

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) {
      aString
    } else {
      aString + aRepeatedFunction(aString, n-1)
    }
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN WE NEED LOOPS USE RECURSION

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = {
      a + b
    }
    aSmallerFunction(n, n-1)
  }

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old
    2. Factorial function
    3. Fibonacci function: f(1) = 1, f(2) = 1, ..., f(n) = f(n-1) + f(n-2)
    4. Tests if a number is prime
   */

  // 1
  def greetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old"
  }
  println(greetingFunction("Antoine", 27))

  // 2
  def factorial(n: Int): Int = {
    if (n <= 1) {
      1
    } else {
      n * factorial(n - 1)
    }
  }
  println(factorial(5))

  // 3
  def fibonacci(n: Int): Int = {
    if (n <= 2) {
      1
    } else if (n < 1) {
      0
    } else {
      fibonacci(n-1) + fibonacci(n-2)
    }
  }
  println(fibonacci(8)) // 1 1 2 3 5 8 13 21

  // 4
  def isPrime(n: Int): Boolean = {

    def isPrimeUntil(n: Int, i: Int): Boolean = {
      if (i <= 1) {
        true
      } else {
        ((n%i) != 0) & (isPrimeUntil(n, i-1))
      }
    }
    isPrimeUntil(n, n/2)
  }

  println(isPrime(5))
  println(isPrime(7))
  println(isPrime(9))
  println(isPrime(37))
  println(isPrime(71))
  println(isPrime(2003))
  println(isPrime((37*23)))
}
