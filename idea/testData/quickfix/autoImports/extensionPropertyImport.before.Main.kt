// "Import" "true"
// ERROR: Unresolved reference: someVal
package test

fun some() {
    "".<caret>someVal
}

/* FIR_COMPARISON */