// !WITH_NEW_INFERENCE
class X

operator fun <T> X.iterator(): Iterable<T> = TODO()

fun test() {
    <!HAS_NEXT_MISSING!>for (i in X()) {
    }<!>
}
