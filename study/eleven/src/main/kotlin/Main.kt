import java.lang.NumberFormatException

fun main(args: Array<String>) {
    print("type a number:")
    val str = readLine()?: ""
    var num = 0
//    num = try {
//        str.toInt()
//    } catch(e:NumberFormatException) {
//        println(e.message)
//        0
//    }
    runCatching {
        num = str.toInt()
    }.onSuccess {
        println("*** success ***")
    }.onFailure {
        println(it.message)
    }
    var total:Int = 0
    for(i in 1..num) {
        total += i
    }
    println(total)
}