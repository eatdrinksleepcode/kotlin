
import kotlin.reflect.KProperty

class Foo {
  val foo get() = getMeNonNullFoo()
  val foo2: Foo get() = getMeNonNullFoo()
  fun getMeNonNullFoo() : Foo = Foo()
}