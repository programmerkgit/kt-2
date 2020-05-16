interface A {
    val a: Int
}

class A2 : A {
    override val a = 3
}

class B(val node: A2) : A by node {

}

fun main() {
    println(B(A2()).a)
}