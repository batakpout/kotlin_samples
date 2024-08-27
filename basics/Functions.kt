fun main() {

    fun returnUnit() { // no need to specify return type
        println("hi")
    }

    fun add(x: Int, y: Int) = x + y // no need to specify return type when we don't use braces

    fun addThenSubtract(x: Int, y: Int): Int { // return type is important and I added return keyword at last
        val temp = x + y
        return temp - x
    }

    fun addThenSubtractV2(x: Int, y: Int) { //since no return type mentioned, it infers as Unit
        val temp = x + y
         temp - x - y
    }

    returnUnit()
    println(add(1, 3))
    println(addThenSubtract(12, 2))//so return type is must if we want to return anything
    println(addThenSubtractV2(12, 2)) //kotlin.Unit
}
