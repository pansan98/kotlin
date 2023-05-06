fun main(args: Array<String>) {
    val p = Person()
    p.name = "Taro"
    p.email = "sample@example.com"
    p.say()
    val pa = PersonArgs("Wasabi", "sample")
    pa.say()
    val pi = PersonInit("Init", "init@example.com")
    pi.say()
    val pc1 = PersonConstructor("Constructor", "constructor@example.com")
    pc1.say()
    val data = mapOf<String, String>(
        "name" to "cMap",
        "email" to "cmap@example.com"
    )
    val pc2 = PersonConstructor(data)
    pc2.say()
    val pgs = PersonGetterSetter()
    pgs.content = "GetterSetter,gettersetter@example.com"
    pgs.say()
    val b = Base("base", "base@example.com")
    val c = Children("children", "children@example.com", 10)
    b.say()
    c.say()

    val prb = prBase("prBase", "prBase@example.com")
    val prc = prChildren("prChildren", "prChildren@example.com", 8)
    prb.say()
    prc.say()
}

class Person {
    var name = "name"
    var email = ""

    fun say() {
        println("Name:" + name + ", Email:" + email)
    }
}

class PersonArgs(n:String = "", e:String = "") {
    var name = n
    var email = e

    fun say() {
        println("Name:" + name + ", Email:" + email)
    }
}

class PersonInit(name:String = "noname", email:String = "") {
    var name:String
    var email:String

    init {
        this.name = name
        this.email = email
    }

    fun say() {
        println("Name:" + this.name + ", Email:" + this.email)
    }
}

class PersonConstructor {
    var name:String
    var email:String

    constructor(name:String = "name", email:String = "") {
        this.name = name
        this.email = email
    }

    constructor(arr:Map<String, String>) {
        this.name = arr["name"]?: "noname"
        this.email = arr["email"]?: ""
    }

    fun say() {
        println("Name:" + this.name + ", Email:" + this.email)
    }
}

class PersonGetterSetter {
    var name:String = ""
        get() = field
        set(value) {
            field = value
        }
    var email:String = ""
        get() = field
        set(value) {
            field = value
        }
    var content:String = ""
        get() = field
        set(value:String) {
            val arr = value.split(',')
            if(arr.size >= 2) {
                this.name = arr[0]?: ""
                this.email = arr[1]?: ""
            }
            field = value
        }

    fun say() {
        println("Name:" + this.name + ", Email:" + this.email)
    }
}

open class Base {
    var name:String
    var email:String

    constructor(name:String = "noname", email:String = "") {
        this.name = name
        this.email = email
    }

    open fun say() {
        println("Name:" + this.name + ", Email:" + this.email)
    }
}

class Children:Base {
    var age:Int

    constructor(name:String = "noname", email:String = "", age:Int = 0) {
        this.name = name
        this.email = email
        this.age = age
    }

    override fun say() {
        println("Name:" + this.name + ", Email:" + this.email + ", Age:" + this.age)
    }
}

open class prBase(var name:String = "noname", var email:String = "") {
    open fun say() {
        println("Name:" + this.name + ", Email:" + this.email)
    }
}

class prChildren(name:String = "noname", email:String = "", var age:Int = 0):prBase(name, email) {
    override fun say() {
        println("Name:" + this.name + ", Email" + this.email + ", Age:" + this.age)
    }
}