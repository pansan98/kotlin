fun main(args: Array<String>) {
    val p = Person().also {
        it.set("also action", 10)
        println("<<also>>" + it.msg())
    }.let {
        it.set("let action", 30)
        println("<<let>>" + it.msg())
    }
    print(p)
}

class Person {
    var name:String = ""
    var age:Int = 0

    fun set(name:String, age:Int) {
        this.name = name
        this.age = age
    }

    fun msg():String {
        return "${this.name}(${this.age})"
    }
}