fun main(args: Array<String>) {
    val adult = Person("Adult", "adult@example.com")
    adult.say()
    val child = Student("Child", "child@example.com", 3)
    child.say()
    val animal = Animals("ゴリラ", "4足歩行")
    animal.say()
    val arr:Array<Vector> = arrayOf<Vector>(adult, child, animal)
    println(arr)

    val v = Vec {println("Hello," + it + "!")}
    v.say("Vec")

    val fni = fninterface {
        name:String, age:Int ->
            println("Hello," + name + "(" + age + ")さん")
    }
    fni.say("fnInterface", 5)

    val at = Attr("Attribute Name", "attribute@example.com", 100)
    at.say(at)
}

interface Vector {
    var name:String
    fun say()
}

open class Person(override var name: String = "noname", var email: String = ""):Vector {
    override fun say() {
        println("Name:" + this.name + ", Email:" + this.email)
    }
}

class Student(name:String = "noname", email:String = "", var grade:Int = 0):Person(name, email) {
    override fun say() {
        println("Name:" + this.name + ", Email:" + this.email + ", Grade:" + this.grade)
    }
}

class Animals(override var name:String = "animals", var type:String = ""):Vector {
    override fun say() {
        println("Name:" + this.name + ", 種別:" + this.type)
    }
}

fun interface Vec {
    fun say(name:String)
}

fun interface fninterface {
    fun say(name:String, age:Int)
}

data class Attr(val name:String, val email:String, val age:Int) {
    fun say(attr:Attr) {
        println("Name: ${attr.name} Email: ${attr.email} Age: ${attr.age}")
    }
}