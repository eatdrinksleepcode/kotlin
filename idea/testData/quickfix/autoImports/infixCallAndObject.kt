// "Import" "false"
// ERROR: Unresolved reference: infix
package x

object infix {
    fun invoke() {

    }
}

fun x() {
    "" <caret>infix ""
}