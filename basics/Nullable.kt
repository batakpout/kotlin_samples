fun main() {
    val favoriteActor = null
    println(favoriteActor)

    var favoriteActress: String = "Sandra Oh"
    //favoriteActress = null CTE

    var favoriteActor2: String? = null
    //println(favoriteActor2.length) CTE
    println(favoriteActor2?.length)
    /**
     * As the name suggests, if you use the !! not-null assertion,
     * it means that you assert that the value of the variable isn't null, regardless of whether it is or isn't.
     * Unlike ?. safe-call operators, the use of a !! not-null assertion operator may result in a
     * NullPointerException error being thrown if the nullable variable is indeed null
     */
    println(favoriteActor2!!.length)

    //elvis operator
   val res: Int =  favoriteActor2?.length ?: 0


}
