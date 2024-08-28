import java.io.IOException

/*enum class Result {
    SUCCESS,
    ERROR,
    IDLE,
    LOADING
}*/

sealed class Result

data class SUCCESS(val dataFetched: String?): Result()
data class ERROR(val exception: Exception): Result()
object NOTLOADING: Result()
object LOADING: Result()

sealed class Failure: Result() {
    data class CustomFailure(val customFailure: IOException): Failure()
    data class AnotherCustomFailure(val anotherCustomFailure: NullPointerException): Failure()
}

fun getResult(result: Result) {
    return when (result) {
        is SUCCESS -> println(result.dataFetched ?: "Ensure u start the fetch first") // if not null then resulut.data else ""
        is ERROR -> println(result.exception.toString())
        is LOADING -> println("Loading!")
        is NOTLOADING -> println("Not Loading!")
        // else -> println("N/A") not needed when we use sealed instead of abstract class Result
        is Failure.AnotherCustomFailure -> println(result.anotherCustomFailure.toString())
        is Failure.CustomFailure -> println(result.customFailure.toString())
    }
}

object Repository {
    private var loadState: Result = NOTLOADING
    private var dataFetched: String? = null
    fun startFetch() {
        loadState = LOADING
        dataFetched = "data"
    }

    fun finishFetch() {
        loadState = SUCCESS(dataFetched)
        dataFetched = null
    }

    fun error() {
        loadState = ERROR(Exception("Exception"))
    }

    fun getCurrentState(): Result {
        return loadState
    }

    fun customFailure(): Result {
        loadState = Failure.CustomFailure(IOException("IOException..."))
        return loadState
    }

    fun anotherCustomFailure(): Result {
        loadState = Failure.AnotherCustomFailure(java.lang.NullPointerException("NullPointer exception..."))
        return loadState
    }
}

fun main() {

    Repository.finishFetch()
    getResult(result = Repository.getCurrentState())
    Repository.startFetch()
    getResult(result = Repository.getCurrentState())
    Repository.error()
    getResult(result = Repository.getCurrentState())

    Repository.customFailure()
    getResult(result = Repository.getCurrentState())
    Repository.anotherCustomFailure()
    getResult(result = Repository.getCurrentState())
}
