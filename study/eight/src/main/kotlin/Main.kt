import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val p = Person("MyPerson", 5)
    p.show()
    p.name = "change name"
    p.show()
    p.age = 29
    p.show()
}

class NameDelegate {
    private var value:String = ""

    operator fun getValue(thisRef:Any?, property:KProperty<*>):String {
        println("***[${property.name}] get '${this.value}'.***")
        return this.value
    }

    operator fun setValue(thisRef:Any?, property:KProperty<*>, value:String) {
        println("***[${property.name}] set '${this.value}' -> '${value}'.***")
        this.value = value
    }
}

class AgeDelegate {
    private var value:Int = 0

    operator fun getValue(thisRef:Any?, property:KProperty<*>):Int {
        println("***[${property.name}] get '${this.value}'.***")
        return this.value
    }

    operator fun setValue(thisRef:Any?, property:KProperty<*>, value:Int) {
        println("***[${property.name}] set '${this.value}' -> '${value}'.***")
        this.value = value
    }
}

class Person(name:String, age:Int) {
    var name:String by NameDelegate()
    var age:Int by AgeDelegate()

    init {
        this.name = name
        this.age = age
    }

    fun show() {
        println("Name:${this.name}, Age:${this.age}才")
    }
}