// !WITH_NEW_INFERENCE
// !LANGUAGE: +ArrayLiteralsInAnnotations, -AssigningArraysToVarargsInNamedFormInAnnotations -AllowAssigningArrayElementsToVarargsInNamedFormForFunctions

// FILE: JavaAnn.java

@interface JavaAnn {
    String[] value() default {};
    String[] path() default {};
}

// FILE: test.kt

annotation class Ann(vararg val s: String)

@Ann(s = <!TYPE_INFERENCE_EXPECTED_TYPE_MISMATCH{OI}, TYPE_MISMATCH{NI}!>arrayOf()<!>)
fun test1() {}

@Ann(s = <!TYPE_MISMATCH!>intArrayOf()<!>)
fun test2() {}

@Ann(s = <!TYPE_INFERENCE_EXPECTED_TYPE_MISMATCH{OI}, TYPE_MISMATCH{NI}!>arrayOf(1)<!>)
fun test3() {}

@Ann(s = <!TYPE_INFERENCE_EXPECTED_TYPE_MISMATCH{OI}, TYPE_MISMATCH, TYPE_MISMATCH!>["value"]<!>)
fun test5() {}

@JavaAnn(value = <!TYPE_INFERENCE_EXPECTED_TYPE_MISMATCH{OI}, TYPE_MISMATCH{NI}!>arrayOf("value")<!>)
fun jTest1() {}

@JavaAnn(value = <!TYPE_INFERENCE_EXPECTED_TYPE_MISMATCH{OI}, TYPE_MISMATCH, TYPE_MISMATCH!>["value"]<!>)
fun jTest2() {}

@JavaAnn(value = <!TYPE_INFERENCE_EXPECTED_TYPE_MISMATCH{OI}, TYPE_MISMATCH, TYPE_MISMATCH!>["value"]<!>, path = ["path"])
fun jTest3() {}

annotation class IntAnn(vararg val i: Int)

@IntAnn(i = <!TYPE_INFERENCE_EXPECTED_TYPE_MISMATCH{OI}, TYPE_MISMATCH, TYPE_MISMATCH!>[1, 2]<!>)
fun foo1() {}

@IntAnn(i = <!TYPE_MISMATCH!>intArrayOf(0)<!>)
fun foo2() {}

fun foo(vararg i: Int) {}

@Ann(s = "value")
fun dep1() {
    foo(i = 1)
}
