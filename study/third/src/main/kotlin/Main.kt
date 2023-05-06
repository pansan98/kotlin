fun main(args: Array<String>) {
    //fnarray()
    //fnforarray()
    //fnlistarray()
    //fnmutablelistarray()
    //fnmaparray()
    //fnmutablemaparray()
    //fnhello("Taro")
    //fnprice()
    //println(lambda(500, 10))
    println(fntailrec(1))
    println(fntailrec(3))
    println(fntailrec(5))
}

fun fnarray() {
    val arr = arrayOf(98, 76, 54, 79, 68)
    val total = arr[0] + arr[1] + arr[2] + arr[3] + arr[4]
    val avg = total / 5
    println("total:" + total + ", averrage:" + avg)
}

fun fnforarray() {
    val arr = arrayOf(98, 76, 54, 79, 68)
    var total = 0
    for(item in arr) {
        total += item
    }
    val avg = total / arr.size
    println("total:" + total + ", averrage:" + avg)
}

fun fnlistarray() {
    // 異なる型を配列にできる
    val arr = listOf(98, 76, 54, 79, 68)
    var total = 0
    for(item in arr) {
        total += item
    }
    val avg = total / arr.size
    println("total:" + total + ", avarrage:" + avg)
}

fun fnmutablelistarray() {
    // 異なる型を配列にして追加/削除の操作ができる
    val arr = mutableListOf(10, 20, 30, 40)
    arr.add(50)
    arr.add(1, 1000)
    arr.remove(40)
    arr.removeAt(2)
    println(arr)
}

fun fnIntmutablelistarray() {
    // 一定の型のみを配列に追加できる操作
    val arr = mutableListOf<Int>(10, 20, 30)
    arr.add(100)
    println(arr)
}

fun fnmaparray() {
    // キーを軸に配列を作成できる
    val arr = mapOf("l1" to "Win", "l2" to "Mac", "l3" to "Ubuntu")
    println(arr)
}

fun fnmutablemaparray() {
    // キーを軸に配列を作成して追加/削除ができる
    val arr = mutableMapOf(
        "l1" to "Win",
        "l2" to "Mac",
        "l3" to "Ubuntu"
    )
    arr["l4"] = "centOS"
    for((k, v) in arr) {
        println("Key:" + k + ", Value:" + v)
    }
}

fun fnhello(str:String) {
    println("Hello, " + str)
}

fun fnprice() {
    val arr = arrayOf(10, 20, 30)
    var total = 0
    for(p in arr) {
        total += p
    }
    println("Price:" + total + ", Tax:" + fntax(total))
}

fun fntax(price:Int, tax:Double = 0.08):Int {
    return (price * tax).toInt()
}

fun lambda(price:Int, rate:Int) = (price * (100.0 + rate) / 100.0).toInt()

tailrec fun fntailrec(n:Int, m:Int = 1):Int {
    if(n === 1) {
        return m
    } else {
        return fntailrec(n - 1, m * n)
    }
}