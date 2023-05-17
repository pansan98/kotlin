import java.io.File

fun main(args: Array<String>) {
    //read()
    //writeloop()
    //readloop()
    //writeBinary()
    readBinary()
}

fun read() {
    val path = "sample.txt"
    val f = File(path)
    runCatching {
        val re = f.readText(Charsets.UTF_8)
        println(re)
    }
    println("read finish")
}

fun readloop() {
    val path = "sample.txt"
    val f = File(path)
    var c = 1
    runCatching {
        f.forEachLine {
            line -> println("${c++}: ${line}")
        }
    }
    println("read loop finish")
}

fun writeloop() {
    val path = "sample.txt"
    val f = File(path)
    f.appendText("¥n===========¥n")
    while(true) {
        print("TEXT: ")
        var s = readLine()?: ""
        if(s == "") break
        f.appendText("${s}¥n")
    }
    println("Finish...")
}

fun writeBinary() {
    print("plz message: ")
    val s = readLine()?: "plz, message..."
    var arr = s.toByteArray()
    arr = arr + byteArrayOf(0, 10, 20, 30, 40)
    val path = "binary.dat"
    val f = File(path)
    f.writeBytes(arr)
    println("finishied")
}

fun readBinary() {
    val path = "binary.dat"
    val f = File(path)
    val arr = f.readBytes()
    arr.forEach {
        print("${it}")
    }
    println()
    arr.forEach {
        print("${it.toChar()}")
    }
    println()
    print("finished")
}