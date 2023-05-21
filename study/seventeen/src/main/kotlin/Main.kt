import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

fun main(args: Array<String>) {
    //fnLazy()
    fnflow()
}

fun fnLazy() = runBlocking {
    val t = measureTimeMillis {
        val a = async(start=CoroutineStart.LAZY) {
            do_Aaction(10, 10)
        }

        val b = async(start=CoroutineStart.LAZY) {
            do_Baction(10, 20)
        }
        a.start()
        delay(50L)
        b.start()
        println("A=${a.await()}, B=${b.await()}")
    }
    println("TIME: ${t}")
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

fun fnflow() = runBlocking {
    launch {
        for(n in 1..10) {
            println(" no flow ${n}")
            delay(10)
        }
    }
    doit("First", 10, 10).collect {
        value -> println(value)
    }
}

fun doit(id:String, n:Int, s:Long): Flow<String> = flow {
    for(n in 1..n) {
        runBlocking {
            delay(s)
        }
        emit("[${id}] ${n} count")
    }
}