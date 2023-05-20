import kotlinx.coroutines.*

fun main(args: Array<String>) {
    //fncoroutine()
    fnsuspend()
}

fun fncoroutine() {
    val count = 10
    GlobalScope.launch {
        for(n in 1..count) {
            println("${n} counted.")
            delay(20L)
        }
        println("*** finished ***")
    }

    for(n1 in 1..count) {
        println("COUNT: ${n1}")
        runBlocking {
            delay(10L)
        }
    }
    println("coroutine finished")
}

fun fnsuspend() {
    val count = 10
    GlobalScope.launch {
        doit("First", count, 10L)
    }
    GlobalScope.launch {
        doit("Second", count, 20L)
    }
    Thread.sleep(300L)
    println("finished")
}

suspend fun doit(id:String, c:Int, w:Long) {
    for(n in 1..c) {
        println("[${id}] ${n} count.")
        delay(w)
    }
    println("*** ${id} finished ***")
}