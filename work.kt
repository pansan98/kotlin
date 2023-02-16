fun fnVars() {
	var age1:Int = 27
	var age2 = 25
	val me1:Int = 20
	val me2 = 30

	println(age1)
	println(age2)
	println(me1)
	println(me2)

	var nullable:String? = null
	println(nullable?.length)
}

fun fnConditions(num: Int) {
	if(num < 5) {
		println("low")
	} else if(num > 5) {
		println("High")
	} else {
		println("equal")
	}
}

fun fnWhen(str: String) {
	var ret = when(str) {
		"Long"->"strは「Long」です"
		"Miedium"->"strは「Miedium」です"
		"Short"->"strは「Short」です"
		else -> "strはどれでもありません。"
	}
	println(ret)
}

fun main() {
	fnVars()
	fnConditions(5)
	fnWhen("Short")
}