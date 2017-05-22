package com.womaiapp;

import java.lang.Thread.sleep

/**
 * Created by cofco on 2017/5/18.
 */
fun main(args: Array<String>) {
    println("hello world!")

    val arrs = Array(3){Array(2){IntArray(1)}}

    var str:String="hello world!"

    var str1="hello word"
    var str2:String?=null


    var x=10
    when (x){
        2 -> println("等于2")
        if (x>0) 1 else -1 -> println("大于0并等于1，或小于0并等于-1")
        in 1..5 -> println("范围匹配 1-5")
        !in 6..9 -> println("不是6-9")
        is Int -> println("类型判断")
        else -> println("else")
    }

    //代替if else if
    when{
        x>6 && x<=10 -> println(">6 <=10")
        x<6 -> println("<6")
        else -> println("else")
    }

    val list=ArrayList<String>()

    for (i in list.indices){
        print(list[i])
    }
    //递增for (int i = 2; i < list.size(); i++)
    for (i in 2..list.size-1) {
        print(list[i])
    }

    for (i in list.size-1 downTo 0){
        println(list[i])
    }
    //操作列表内的对象
    for (item in list) {
        print(item)
    }

    for ((i,item) in list.withIndex()){
        println(list[i])
        println(item)
    }

    list.forEach{
        println(it)
    }
    list.forEachIndexed{
        i,s->
        println(list[i])
        println(s)
    }
    list.forEachIndexed(object:(Int,String)->Unit{
        override fun invoke(i: Int, s: String) {
            print(list[i])
            print(s)
        }
    })

    fun getName(): String{
        return "tutu"
    }

    //类继承
    class UserList<E>(): ArrayList<E>() {
        //...
    }

    class NameList<E>(): ArrayList<E>(){
    }

/*    class User {
        inner class State{
            fun getUser(): User{
                //返回User
                return this@User
            }
            fun getState(): State{
                //返回State
                return this@State
            }
        }
    }*/

    val user = User()

    user.name="tutu"
    user.age="28"
    val name = user.name
    val age = user.age

    var userInfo = "name:${user.name},  age:$age"
    println(userInfo)

    Thread(Runnable{
        sleep(3000)
    }).start()


    var agge:String?=null
    val ages1 = agge?.toInt() ?: -1
//    println(ages)
}