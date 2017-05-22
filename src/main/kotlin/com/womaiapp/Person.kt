package com.womaiapp

import java.io.BufferedReader
import java.io.File


/**
 * Created by cofco on 2017/5/22.
 */
//data class Person (val name:String,val age:Int?=null)

class Rectangle(val height: Int, val width: Int){
    val isSquare:Boolean
        get() = height == width
}
/*enum class Color(
        val r: Int, val g: Int, val b: Int
){
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}*/

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}



interface Expr

class Num(val value:Int):Expr

class Sum(val left:Expr,val right: Expr) : Expr

fun eval(e:Expr):Int{
    if(e is Num){
        val n=e as Num
        return n.value
    }
    if (e is Sum){
        return eval(e.right)+ eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}
fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun main(args: Array<String>) {
    /*val persons= listOf<Person>(Person("Alice"),Person("Tom",12))

    val oldest = persons.maxBy { it.age?:0 }
    println("the oldest is${oldest}")
    println(max(1, 2))
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name!")
    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")*/

//    val rectangle=Rectangle(1,1)
//    println(rectangle.isSquare)

//    println(Color.BLUE.rgb())
//    println(mix(Color.BLUE, Color.YELLOW))
//    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))


    /*for (i in 1..100) {
        print(fizzBuzz(i))
    }*/

    /*val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }*/

//    println(isLetter('q'))
//    println(isNotDigit('x'))
//    val reader = BufferedReader(StringReader("not a number"))
//    readNumber(reader)


    /*val set = hashSetOf(1,3,5,7)
    val list = arrayListOf(1,3,4,5)
    val map = hashMapOf(1 to "one",2 to "two",3 to "three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)*/

    /*val list = listOf(1, 2, 3)
    println(list.joinToString(separator = "; ",
            prefix = "(", postfix = ")"))*/

//    println("abcde".lastestChar())

//    val view: View = Btn()
//    view.click()

//    println("12.345-6.A".split("\\.|-".toRegex()))
//    parsepath("/Users/yole/kotlin-book/chapter.adoc")

//    val persons = listOf(Person("Bob"), Person("Alice"))
//    println(persons.sortedWith(Person.NameComparator))

    /*data class Person(val name: String, val age: Int)
    val canBeInClub27 = { p: Person -> p.age <= 27 }

    val people = listOf(Person("Alice", 27), Person("Bob", 31))

    println(people.all(canBeInClub27))*/


//    val strings = listOf("bac", "def")
//    println(strings)
//    println(strings.flatMap {it.toList()})

    /*class Book(val title: String, val authors: List<String>)
    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
            Book("Mort", listOf("Terry Pratchett")),
            Book("Good Omens", listOf("Terry Pratchett",
                    "Neil Gaiman")))
    println(books.flatMap { it.authors }.toSet())*/

    /*val a=listOf(1, 2, 3, 4).asSequence()
            .map { print("map($it) "); it * it }
            .filter { print("filter($it) "); it % 2 == 0 }
            .toList()
    println(a)*/

    /*val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())*/

//    val file = File("/Users/svtk/.HiddenDir/a.txt")
//    println(file.isInsideHiddenDirectory())
}

fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }

data class Person(val name: String) {
    object NameComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
                p1.name.compareTo(p2.name)
    }
}

fun parsepath(path : String){
    val regex="""(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)

    if(matchResult!=null){
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}
open class View {
    open fun click() = println("View clicked")
}
class Btn : View(){
    override fun click() = println("btn view")
}
fun String.lastestChar():Char =this.get(this.length-1)

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}
fun readNumber(reader: BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    }catch (e:NumberFormatException){
        null
    }
    println(number)
}
fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b

}