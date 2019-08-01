package com.sima

import scala.collection.immutable.HashSet

/**
  * Created by qisima on 4/30/2019 3:25 PM
  */
object L824_GoatLatin {
  def toGoatLatin(S: String): String = {
    val arr = Array('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
    val sb = new StringBuilder()

    for (word <- S.split(" ").zipWithIndex){
      sb.append(" ")
      if (arr.contains(word._1(0))){
        sb.append(word._1).append("ma")
      }else{
        sb.append(word._1.substring(1)).append(word._1(0)).append("ma")
      }
      (0 to word._2).foreach(sb.append('a'))
    }
    sb.substring(1)
  }
}
