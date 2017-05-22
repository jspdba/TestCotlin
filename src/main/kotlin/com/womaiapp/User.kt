package com.womaiapp

/**
 * 单例
 * Created by cofco on 2017/5/22.
 */
class User {
    companion object{
        @Volatile var instance: User?=null
        get() {
            if(field==null){
                synchronized(User::class.java){
                    if (field==null){
                        field= User()
                    }
                }
            }
            return field
        }
    }
    var name:String?=null
    var age:String?=null
}