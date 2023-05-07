fun main(args: Array<String>) {
    Human.set("Human", "human@example.com", 10)
    Human.say()

    Vec.set("Vec", "vec@example.com")
    val v1 = Vec()
    v1.set(20)
    val v2 = Vec()
    v2.set(100)
    v1.say()
    v2.say()

    val enumT = Sample.Taro
    val enumH = Sample.Hanako
    val enumS = Sample.Sachiko
    println(enumT)
    enumS.show()
}

object Human {
    var name:String = "name"
    var email:String = ""
    var age:Int = 0

    fun set(name:String, email:String, age:Int) {
        this.name = name
        this.email = email
        this.age = age
    }

    fun say() {
        println("Hello!" + this.name + "(" + this.email + ")さん、あなたは" + this.age + "才です。")
    }
}

class Vec {
    var age:Int = 0

    fun set(age:Int) {
        this.age = age
    }

    fun say() {
        println("Hello!" + Vec.name + "("+Vec.email+")さん、あなたは" + this.age + "才です。")
    }

    companion object {
        var name:String = "name"
        var email:String = ""

        fun set(name:String, email:String) {
            this.name = name
            this.email = email
        }
    }
}

enum class Sample(val label:String, val age:Int) {
    Taro("一般市民", 40),
    Hanako("パートの人", 54),
    Sachiko("OL", 26);

    fun show() {
        println("<<${this} ${this.label}(${this.age})>>")
    }
}