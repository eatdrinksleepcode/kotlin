package b

fun foo() {
    <!HAS_NEXT_MISSING!>for (i in <!UNRESOLVED_REFERENCE!>collection<!>) {
        {
         break
    }
}<!><!SYNTAX!><!>
