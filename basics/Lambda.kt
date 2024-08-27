fun main() {

    //Lambda- a function without a name ?
    val sum: (Int, Int) -> Int = { a, b -> a + b }

    println(sum(1, 2))

    val catAge: (Int) -> Int = { age -> age * 7 }
    //sine we have one param. we can simply this
    val catAge2: (Int) -> Int = { it * 7 }
    val justPrint: (String) -> Unit = { println(it) }

    println(catAge(2))
    println(catAge2(2))
    println(justPrint("Print me "))

    fun add(x: Int, y: Int) = x + y

    //trailing lambda
    fun enhancedF(msg: String, f: (String) -> Int) {
        println("$msg ${f("Hi")}")
    }
    enhancedF("Hello ") { it ->
        println(it)
        add(1, 3)
    }
}
