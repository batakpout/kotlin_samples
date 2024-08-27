fun main() {
    val names = listOf<String>("aamir", "shehzal")
    for (it in names) {
        println(it)
    }
    names.forEach { println(it) }

    val newList1 = names.filter{name -> name.startsWith("aamir")}
    val mutableName = mutableListOf("aamir")
    mutableName.add(1, "shehzal")
    println(names.get(1))
    println(names.indexOf("aamir"))

    println("aamir" in names)

    val myList = mutableListOf<String>() //intialize an empty mutable list of strings

    myList.add("abc")

    val emptyList = emptyList<String>()
    val emptySet = emptySet<String>()
    val emptyMap = emptyMap<String, Int>()
    println("====1====")

    val namesSet = setOf("aamir", "shehzal", "aamir")
    println(namesSet)
    //mutableSet
    println("====2====")

    val map1 = mapOf("one" to 1, "two" to 2)
    println(map1)
    println("one" in map1)
}
