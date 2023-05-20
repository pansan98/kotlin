import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val t = measureTimeMillis {
        val actionA = GlobalScope.async {do_Aaction(10, 10)}
        val actionB = GlobalScope.async {do_Baction(10, 20)}
        actionA.start()
        actionB.start()
        runBlocking {
            println("A=${actionA.await()} B=${actionB.await()}")
        }
    }
    println("Time: ${t}")
}

suspend fun do_Aaction(c:Int, s:Long):Long {
    val t = measureTimeMillis {
        for(n in 1..c) {
            println("[A] ${n} count =====")
            delay(s)
        }
        println("=== A finished ===")
    }
    return t
}

suspend fun do_Baction(c:Int, s:Long):Long {
    val t = measureTimeMillis {
        for(n in 1..c) {
            println("[B] ${n} count ====")
            delay(s)
        }
        println("=== B finished ===")
    }
    return t
}