// DONT_TARGET_EXACT_BACKEND: WASM
// WASM_MUTE_REASON: IGNORED_IN_JS
// IGNORE_BACKEND: JS_IR
// IGNORE_BACKEND: JS_IR_ES6
// TODO: investigate should it be ran for JS or not
// IGNORE_BACKEND: JS, NATIVE

// WITH_REFLECT

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.*

class C {
    var prop = 42
    val prop2 = 43
}

val C_propReflect = C::class.memberProperties.find { it.name == "prop" } as? KMutableProperty1 ?: throw AssertionError()
val C_prop2Reflect = C::class.memberProperties.find { it.name == "prop2" } as? KProperty1 ?: throw AssertionError()
val C_prop = C::prop
val cProp = C()::prop

fun box() =
        when {
            C_prop.getter != C_prop.getter -> "C_prop.getter != C_prop.getter"
            C_propReflect.getter != C_propReflect.getter -> "C_propReflect.getter != C_propReflect.getter"
            cProp.getter != cProp.getter -> "cProp.getter != cProp.getter"

            cProp.getter == C_prop.getter -> "cProp.getter == C_prop.getter"
            C_prop.getter == cProp.getter -> "C_prop.getter == cProp.getter"
            cProp.getter == C_propReflect.getter -> "cProp.getter == C_propReflect.getter"
            C_propReflect.getter == cProp.getter -> "C_propReflect.getter == cProp.getter"

            cProp.getter == C()::prop.getter -> "cProp.getter == C()::prop.getter"
            cProp.setter == C()::prop.setter -> "cProp.setter == C()::prop.setter"
            C_prop.getter != C_propReflect.getter -> "C_prop.getter != C_propReflect.getter"
            C_prop.setter != C_propReflect.setter -> "C_prop.setter != C_propReflect.setter"

            C()::prop2.getter == C()::prop2.getter -> "C()::prop2.getter == C()::prop2.getter"
            C::prop2.getter != C_prop2Reflect.getter -> "C::prop2.getter != C_prop2Reflect.getter"
            else -> "OK"
        }
