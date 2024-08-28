fun main() {

    open class Vehicle(var color: String, var model: String, val isCool: Boolean = true) {

        init {
            if (color == "blue") color = "green"
            model = "XX"
        }

        fun speed() {
            println("My car is $color car with $model model..")
        }

        open fun drive() = println("vrooomm....")


    }

    //Vehicle must be open to be inherited
    class Truck(color: String, model: String) : Vehicle(color, model) {
        override fun drive() {
            println("baaaaaarrreee") // only when its super is open
        }
    }

    val truck = Truck("Blue", "X86")
    truck.speed()
    truck.drive()
}
