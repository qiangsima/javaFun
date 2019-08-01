package com.sima

import scala.util.Sorting

/**
  * Created by qisima on 4/30/2019 4:05 PM
  */
object L976_LargestPerimeter {
  def largestPerimeter(A: Array[Int]): Int = {
    Sorting.quickSort(A)
    val len = A.length
    var sum = 0
    for (i <- Range(len-1, 1, -1)){
      sum = if (A(i) < A(i-1) + A(i-2)) A(i - 1) + A(i - 2) + A(i) else 0
      if (sum > 0) return sum
    }
    sum
  }
}
