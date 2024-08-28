fun main() {

    //extension function
    fun String.append(toAppend: String): String  {
        return this.plus(toAppend)
    }

    fun String.removeFirstAndLastCharacter(): String {
        return this.substring(1, this.length - 1)
    }

    println("Hello Jenny".append(" How are you"))
    println("Hello Jenny".removeFirstAndLastCharacter())

    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1] // 'this' corresponds to the list
        this[index1] = this[index2]
        this[index2] = tmp
    }

    val list = mutableListOf(1, 2, 3)
    println(list)
    list.swap(0, 2)
    println(list)

    /**
     * Extension functions are dispatched statically. So which extension function is called is already known
     * at compile time based on the receiver type. For example:
     * below example prints Shape, because the extension function called depends only on the declared type of the parameter s,
     * which is the Shape class.
     */

    open class Shape
    class Rectangle : Shape()

    fun Shape.getName() = "Shape" // extension function
    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape) {
        println(s.getName())
    }

    printClassName(Rectangle())
    /**
    If a class has a member function, and an extension function is defined which has the same receiver type,
    the same name, and is applicable to given arguments, the member always wins.
     */
    class Example {
        fun printFunctionType() {
            println("Class method")
        }
    }

    fun Example.printFunctionType() {
        println("Extension function")
    }

    Example().printFunctionType()
    /**
     * it's perfectly OK for extension functions to overload member functions that have the same name but a different signature
     */
    class Example2 {
        fun printFunctionType() {
            println("Class method")
        }
    }

    fun Example2.printFunctionType(i: Int) {
        println("Extension function #$i")
    }

    Example2().printFunctionType(1)

    /**
     * If a class has a companion object defined, you can also define extension functions and properties
     * for the companion object. Just like regular members of the companion object, they can be called using only
     * the class name as the qualifier
     */
    MyClass.printCompanion()

    fun List<String>.getLongestString() {
      //  code to find longeststring
    }
    val l = listOf("abc")
    l.getLongestString()
}

class MyClass {
    companion object { }  // will be called "Companion"
}

fun MyClass.Companion.printCompanion() { println("companion") }
