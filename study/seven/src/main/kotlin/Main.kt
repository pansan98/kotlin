import kotlin.properties.Delegates

fun main(args: Array<String>) {
    val p = Person("my person")
    p.show()
    p.name = "Change Name"
    p.show()
}

class Person(name:String) {
    var name:String by Delegates.observable("name") {
        property, oldValue, newValue ->
            println("[${property.name}] ${oldValue} -> ${newValue}")
    }

    init {
        this.name = name
    }

    fun show() {
        println("My Name ${this.name}")
    }
}