import java.util.*
import kotlin.concurrent.timer
import kotlin.concurrent.thread

// TODO threadのjoinから

fun main(args: Array<String>) {
    //fntimer()
    //fnthread()
    fnmultithread()
}

fun fntimer() {
    var count = 1
    var t:Timer? = null
    t = timer("timerfn", false, 0L, 1000L, {
        println("${count++} counted...")
        if(count >= 6) {
            this.cancel()
            t?.cancel()
            println("*** count finishied ***")
        }
    })
}

fun fnthread() {
    val count = 10
    thread {
        for(n in 1..count) {
            println("thread ${n}")
            Thread.sleep(100L)
        }
        println("finished")
    }
    for(n in 1..count) {
        println("<main>${n}")
        Thread.sleep(70L)
    }
    println("*** main thread finished ***")
}

fun fnmultithread() {
    val count = 100
    val t1 = thread(start=false, priority=1) {
        for (n in 1..count) {
            println("thread ${n}")
        }
        for(m in 1..1000) {
            val l = m * m - m
        }
        println("finished thread")
    }
    val t2 = thread(start=false, priority=10) {
        for(n in 1..count) {
            println("priority thread ${n}")
        }
        for(m in 1..1000) {
            val l = m * m - m
        }
        println("finished priority thread")
    }

    t2.start()
    t1.start()
}