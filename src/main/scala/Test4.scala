package main.scala
import java.util.Scanner
import java.io.File
import scala.io.Source
import scala.collection.mutable.HashMap

/**
  * Created by ZTZ on 2017/3/17.
  */
object Test4 {
  def main(args: Array[String]): Unit = {

    val box2 = for((k,v)<-box) yield (k,0.9*v)
    println(box2)
  }
  //1.想购买的装备以及价格，构建另一个MAP，价格打折

  val box = Map("红米肠"->25,"阿姆斯特朗回旋炮"->100,"萝卜糕"->18,"艇仔粥"->15,"XO酱凤爪"->30,"糯米排骨"->38)
  //通过for,
  for((k,v)<-box) yield (k,0.9*v)

  //2.读取文件中的单词，编写word——count的scala程序
  //读取文件，每一个单词放入映射中，每出现一个相同的便+1
//    val in = new Scanner(new java.io.File(""))
//    while (in.hasNext())
//    {
//      //计数，同时放入映射，关键步骤
//
//    }
//    val word =  scala.collection.mutable.Map()

    val in = Source.fromFile("").mkString
    val tokens = in.split("\\s+")
    val map = new HashMap[String,Int]
//  创建了hashmap，key为单词， 经过for 循环更改 HashMap中Int的值，从而达到wordcount的效果
  for (key <- tokens)
    {
      map(key) = map.getOrElse(key,0) +1
    }
  println(map.mkString(","))

//  val in = Source.fromFile("").mkString//源数据.来自方法fromFile
//  val token = in.split("\\+s")
//  val map = new HashMap[String,Int]//为什么需要new
//
//  for (key <- token)
//    {
//      map(key) = map.getOrElse(key,0) +1
//    }
//    println(map.mkString(","))








  //3.使用不可变映射完成word_count






}
