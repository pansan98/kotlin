import kotlinx.coroutines.*

fun main() = runBlocking {
    val count = 10
    val j1 = launch {
        for(n in 1..count) {
            println("${n} count.")
            delay(10L)
            if(n == 3) {
                cancel()
                println("** j1 cancelled **")
            }
        }
        println("*** finished ***")
    }

    val j2 = launch {
        for(n in 1..count) {
            println("COUNT ${n}")
            delay(10L)
        }
        println("j2 finished")
    }

    val j3 = launch {
        withContext(NonCancellable) {
            for(n in 1..count) {
                println("non cancelled ${n} count.")
                delay(20L)
            }
            println("*** non cancelled finished ***")
        }
    }

    var c = 1
    while(true) {
        println("[j1] ${j1.isActive} ${j1.isCompleted} ${j1.isCancelled}")
        println("[j2] ${j2.isActive} ${j2.isCompleted} ${j2.isCancelled}")
        println("[j3] ${j3.isActive} ${j3.isCompleted} ${j3.isCancelled}")
        runBlocking {
            delay(10L)
        }

        if(++c == 5) {
            j2.cancelAndJoin()
            println("** j2 cancelled ***")
        }

        if(c === 8) {
            j3.cancelAndJoin()
            println("t3をキャンセルしようとしました。")
        }
        if(j1.isCompleted && j2.isCompleted && j3.isCompleted) {
            break
        }
    }
    println("all end")
}