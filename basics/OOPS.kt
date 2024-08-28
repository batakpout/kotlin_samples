fun main() {

    class Car {
        val color: String = "RED"
        var model: String = "XMD"

        fun drive() = "driveee awayyyy"

    }

    val car = Car()
    println(car.model)
    println(car.drive())
    car.model = "CCC"
    println(car.model)

    println("===1=====")
    class Car2(var color: String = "blue", var model: String, val isCool: Boolean = true) {

        init {
            if(color == "blue") color = "green"
            model ="XX"
        }
        fun drive() = "driveee awayyyy"

    }

    val car2 = Car2("bluex", "cdmX2") // these are ignored if we set init {}
    println(car2.model)
    println(car2.color)
}
