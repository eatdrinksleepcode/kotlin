// !DIAGNOSTICS: -UNUSED_PARAMETER

class C {
    <!CONFLICTING_JVM_DECLARATIONS!>fun setX(x: Int) {}<!>

    <!CONFLICTING_JVM_DECLARATIONS!>var x: Int = 1
        set(v) {}<!>
}
