

import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.matchers.{ShouldMatchers, Matcher}

class SkycastTest extends FlatSpec with Matchers {

  "Skycast" should "compute for blocked channels" in {
    Skycast.computeMinClicks(1, 20, List(18, 19), List(15, 14, 17, 1, 17)) should be (7)
    Skycast.computeMinClicks(103, 108, List(104), List(105, 106, 107, 103, 105)) should be (8)
    Skycast.computeMinClicks(1, 100, List(78, 79, 80, 3), List(10, 13, 13, 100, 99, 98, 77, 81)) should be (12)
    Skycast.computeMinClicks(1, 200, List(), List(1, 100, 1, 101)) should be (7)
    Skycast.computeMinClicks(1, 100, List(78, 79, 80, 3), List(10, 13, 13, 100, 99, 98, 77, 81)) should be (12)
    }


  "numOfDigits" should "return number of digits in a number" in {
      Skycast.numOfDigits(1000, 0) should be (4)
      Skycast.numOfDigits(0, 0) should be (0)
  }

  "forwardCount" should "return number of clicks by pressing forward button only" in {

    Skycast.forwardCount(5, 15, 0, 20, 1, List(18, 19)) should be (10)
    Skycast.forwardCount(107, 105, 0, 108, 103, List(104)) should be (3)
  }

  "reverseCount" should "return number of clicks by pressing backward button only" in {

    Skycast.reverseCount(15, 5, 0, 20, 1, List(18, 19)) should be (10)
    Skycast.reverseCount(105, 107, 0, 108, 103, List(104)) should be (3)
  }

  "Skycast" should "compute for not following constraints" in {
    Skycast.constraintsCheck(100,1, List(78, 79, 80, 3), List(10, 13, 13, 100, 99, 98, 77, 81).toList) should be(false)
    Skycast.constraintsCheck(100,100, List(78, 79, 80, 3), List(10, 13, 13, 100, 99, 98, 77, 81)) should be(false)
    Skycast.constraintsCheck(1,100, List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),List(10, 13, 13, 100, 99, 98, 77, 81)) should be(false)
    Skycast.constraintsCheck(1,100, List(78, 79, 80, 3),List(10, 13, 13, 100, 99, 98, 77, 81,1,2,3,4,5,6,7,8,9,10)) should be(false)


  }
}

