/**
  * Created by ZTZ on 2017/3/13.
  */

import scala.math._;
import scala.collection.mutable.ArrayBuffer;
import scala.collection.mutable.HashMap;
import scala.collection.SeqLike;

object hh {
  def main(args: Array[String]): Unit = {
    println("hahahahaha ")
    println(BigInt(2).pow(1024))
    println(b)

    val s = sum(1,2,3,4,5)
    println(s)

//    val name = readLine("Your name:")
//    println(name)
//    val age = readInt()
//    printf("Well, next year ,you will be " ,name ,age+1)
//    until 直到 a.length


//    for (i <- 0 until b.length)
//      {
//        sum += b(i)
//      }
//    println(sum)
    // if条件内置，满足条件的选项才进入循环的后置运算
    for (i <- 1 to 3 ;j <- 1 to 3; if i != j) {println(10*i+j)}

    for (i <- 1 to 10 ) yield i % 3

    product("Hello")

  }

    val a = 1
    val b = 1.to(11,1)
//  这个计算器有点意思的

//  val distance = { val dx = x -x0;val dy = y-y0;sqrt(dx * dx + dy * dy)}
//  未进行定义 故不能进行计算 * + 等为方法 故需要放入对应类型 至少*需要数值

    def abs(x:Double) = if (x>=0) x else -x
    //绝对值方法
    //递归
    def fac(n:Int)   =
    {
      var r = 1
      for (i <- 1 to n ) r = r * i
      r
    }
    //another one
//      能否重载
//    def fac(n:Int): Int = if (n <= 0) 1 else n * fac(n-1)

  def decorate(str:String,left:String="[",right:String="]") = {left+str+right}

  //可变长度参数
  def sum(args:Int*):Int={
    var result = 0
    for (arg <- args ) result += arg
    result
  }

  def product(s:String)=
  {
    var result:Long = 1
    for (i <- s)
      {
        result = result * i.toLong
      }
    println(result)
  }
//  递归应当有一个明确的目标，故判定输入字段其长度，递归至0
//    def prodect(s:String):Long = {
//      if (s.length==1) return s.charAt(0).toLong
//      else s.take(1).charAt(0).toLong * product(s.drop(1))//反复剔除第一个元素，drop（1）。take:select first n elements.
//    }


//    def second(x:Double,n:Int): Double =
//  {
//    调用自身的条件，不断的判定视为递归
//    if (n==0) 1
//      &&:并
//    else if(n>0 && n%2==0) second(x,n/2)*second(x,n/2)
//    else if(n>0 && n%2==1) second(x,n-1)*x
//    else if(n<0) 1/second(x,-n)
//  }
  //生成固定长度数组
  val nums = new Array[Int](10)
  //
  //生成可变数组 可new 可不new
  val b = new ArrayBuffer[Int]()
  b.insert(2,1)
  b.remove(2,1)
  b.toArray//将缓冲数组转化成固定数组，跟JAVA比起来真是方便的一笔啊

  for (i <- 0 until b.length) //遍历Array元素
    {
      println(i +":" +b(i))
    }

  for(i <- b)
    {
      println(i)
    }

  println(0 until(100,2))//为对0调用方法until至100，step=2
  (0 until(b.length)).reverse//倒序
  //遍历b中元素，
  for(i <- b)
    {println(i)}

  //if 条件判定，满足条件部分进行后续
  for (elem <- b if elem % 2 ==0) yield 2 * elem


  //习题3
//  1.产生n个随机数，在0-n之间

  def makerand(n:Int):Array[Int] =
  {
    val a = Array[Int](n)
    val rand = new scala.util.Random()
    for (i <- a) yield rand.nextInt(n) //yield 处理为将rand里面的随机数n倍
  }
//2.循环，数组中每两个元素进行置换
  def revert(a:Array[Int])= {
    for (i <- 0 until(a.length - 1, 2)) {//两单位一跳转，即0,2,4进行循环内计算
      val t = a(i)
      a(i) = a(i + 1)
      a(i + 1) = t
    }
  }

  //3.与第二题相同，但产生新的数组
  def revertnext(arr:Array[Int]) =
  {
    for (i <- 0 to(arr.length-1)) yield {if (i < (arr.length-1) && i % 2 ==0)
      {
        val t = arr(i)
        arr(i) = arr(i+1)
        arr(i+1) = t
      }
    }
  }

//  4.将数组中的数值以 正数，0，负数的形式  按原序列排序
//  val a = Array(1,-2,5,3,0,-1,3,5,2)
  //我需要创建三个数组，当判定其为其中一个类型时 将数值丢入该对应数组
  def con(arr:ArrayBuffer[Int])={
    val arr1 = ArrayBuffer[Int]()
    val arr2 = ArrayBuffer[Int]()
    val arr3 = ArrayBuffer[Int]()
    for (i <- 0 until(arr.length-1))
      yield
        {
          if (arr(i)>0) arr1 += arr(i)
          else if (arr(i)==0) arr2 += arr(i)
          else if (arr(i)<0) arr3 += arr(i)
        }
    arr1 ++=arr2
    arr1 ++=arr3
    arr1.toArray
  }
  //5.计算Array[Double]均值
  def avg(arr:Array[Double]) = {
    arr.sum/arr.length
  }
//  ????real??    玩野的吧。
// 6.reverse,转化为toArray.reverse

//7.产出数组中所有元素，去除重复值
  def arrdis(arr:Array[Int]) =
{
  arr.distinct
}
//8.标记负数位置，将位置信息提取，倒序，依次去除元素，除去最后一个
  def luobo(a:Array[Int])=
    {

    }


//四  hashMap
  //定义映射
  val scores = scala.collection.mutable.HashMap[String,Int]
//  val bscores = if (scores.contains("B")) scores("B") else 0 //如果scores中包含B，则返回scores（"B"）,否则返回0
//  val bscores = scores.getOrElse("B",0)


//  更新hashmap值
//  对值进行操作，读取，更新
  //元组 tuple
  val t = (1,3.14,"Luobo") //tuple(Int,Double,String)

  val c = t._3 //调用元组中的第几个元素
//  val (frist,second,third) = t
  //并非所有部件都需要的话
  val (frist,second,_) = t
  "New York".partition(_.isUpper)
  //多值绑定在一起可以使用zip
  val symbols = Array("1","2","3")
  val counts = Array(2,10,2)
  val pairs = symbols.zip(counts)

















}



