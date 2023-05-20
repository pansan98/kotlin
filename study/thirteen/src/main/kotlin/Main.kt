import java.util.*
import kotlin.concurrent.timer
import kotlin.concurrent.thread

fun main(args: Array<String>) {
    //fntimer()
    //fnthread()
    //fnmultithread()
    fnthreadjoin()
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

fun fnthreadjoin() {
    val count = 10
    var t1:Thread
    var t2:Thread
    var t3:Thread

    t1 = thread {
        for(n in 1..count) {
            println("* thread1(${n}) *")
            Thread.sleep(10L)
        }
        println("thread1 finished")
    }

    t2 = thread {
        for(n in 1..count) {
            println("* thread2(${n}) *")
            Thread.sleep(10L)
            runCatching {
                when(n % 2) {
                    0 -> t1.join(10L)
                }
            }
        }
        println("thread2 finished")
    }

    t3 = thread {
        for(n in 1..count) {
            println("* thread3(${n}) *")
            Thread.sleep(10L)
            runCatching {
                when(n % 3) {
                    0 -> t1.join(10L)
                    1 -> t2.join(10L)
                }
            }
        }
        println("thread3 finished")
    }
}