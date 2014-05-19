
object Skycast {


  def numOfDigits(channelNumber : Int, count : Int) : Int = {

    if(channelNumber != 0)
      numOfDigits(channelNumber/10, count + 1)
    else
      return count
  }

  def forwardCount(srcChannel: Int, destChannel: Int, count : Int, highCh : Int, lowCh : Int, blockedList : List[Int]) : Int = {
    if(srcChannel == destChannel)
      return count

    else {
      var x = srcChannel + 1
      if (x == (highCh + 1))
        x = lowCh
      if (blockedList.contains(x)) {

        if(blockedList.contains(x+1))
          forwardCount(x + 1, destChannel, count, highCh, lowCh, blockedList)
        else
          forwardCount(x + 1, destChannel, count+1, highCh, lowCh, blockedList)
      }
      else
        forwardCount(x, destChannel, count + 1, highCh, lowCh, blockedList)
    }
  }

  def reverseCount(srcChannel: Int, destChannel: Int, count : Int, highCh : Int, lowCh : Int, blockedList : List[Int]) : Int = {

    if(srcChannel == destChannel)
      return count

    else {
      var x = srcChannel - 1
      if(x == (lowCh - 1))
        x = highCh

      if(blockedList.contains(x)) {
        if (blockedList.contains(x - 1))
          reverseCount(x - 1, destChannel, count, highCh, lowCh, blockedList)
        else
          reverseCount(x - 1, destChannel, count + 1, highCh, lowCh, blockedList)
      }
      else
        reverseCount(x, destChannel, count + 1, highCh, lowCh, blockedList)
    }
  }

  def min(a: Int, b: Int) = if(a <= b) a else b

  def findMinClicks(blockedList : List[Int], channelsToView : List[Int], count : Int, prevNumber : Int, currentIndex : Int, highCh : Int, lowCh : Int, maxIndex: Int ) : Int = {

    if(currentIndex == maxIndex)
      return count

    else
    {

      if((channelsToView(currentIndex) >= 1 && channelsToView(currentIndex) <= 9) || (prevNumber == channelsToView(currentIndex))) {
        val updatedCount = count + 1
        val prev = channelsToView(currentIndex-1)
        findMinClicks(blockedList, channelsToView, updatedCount, prev, currentIndex+1, highCh, lowCh, maxIndex)
      }

      else {
        val temp1 = forwardCount(channelsToView(currentIndex-1), channelsToView(currentIndex), 0, highCh, lowCh, blockedList)
        val temp2 = reverseCount(channelsToView(currentIndex-1), channelsToView(currentIndex), 0, highCh, lowCh, blockedList)
        var t = min(temp1, temp2)

        if(prevNumber != -1) {
          val prevForward = forwardCount(prevNumber, channelsToView(currentIndex), 0, highCh, lowCh, blockedList)
          val prevReverse = reverseCount(prevNumber, channelsToView(currentIndex), 0, highCh, lowCh, blockedList)
          val p1 = min(prevForward, prevReverse) + 1
          t = min(t, p1)
        }

        var prev = -1
        var updatedCount = 0
        val numDigits = numOfDigits(channelsToView(currentIndex), 0)

        if(t < numDigits)
          updatedCount = count + t
        else {
          updatedCount = count + numDigits
          prev = channelsToView(currentIndex-1)
        }

        findMinClicks(blockedList, channelsToView, updatedCount, prev, currentIndex+1, highCh, lowCh, maxIndex)
      }
    }
  }

  def computeMinClicks(lowCh: Int, highCh: Int, blockedChannels: List[Int], channelsToView: List[Int]): Int = {
    if(constraintsCheck(lowCh, highCh, blockedChannels,channelsToView) == true)
      return findMinClicks(blockedChannels, channelsToView, 0, -1, 1, highCh, lowCh, channelsToView.length) + numOfDigits(channelsToView(0), 0)
    else
      return 0
  }

  //Function to check the constraints provided in the question
  def constraintsCheck(lowCh: Int, highCh: Int, blockedChannels: List[Int], channelsToView: List[Int]): Boolean = {
    var flag = 0
    if (((lowCh < 0) || (highCh > 10000) || (highCh <= lowCh))) flag = 1
    for (x <- 0 to (blockedChannels.size - 1)) {
      if ((blockedChannels(x)) < 0 || (blockedChannels(x) > 10000))
        flag = 1
    }
    if (channelsToView.size >= 10) flag = 1
    if (blockedChannels.size >= 10) flag = 1
    if(flag == 0) true
    else false
  }

}
