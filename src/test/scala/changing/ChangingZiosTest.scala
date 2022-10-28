package changing

import changing.ChangingZios.{DynamicError, Error1}
import zio.test.Assertion.{anything, equalTo, fails, isSubtype}
import zio.test.{DefaultRunnableSpec, ZSpec, assertM}

object ChangingZiosTest extends DefaultRunnableSpec {

  def spec: ZSpec[_root_.zio.test.environment.TestEnvironment, Any] = suite("Test changing ZIOs")(

    testM("s2 should be a ZIO effect that succeeds with 42 mapped to a string value") {
      assertM(ChangingZios.s2)(equalTo("42"))
    },

    testM("i2 should be a ZIO effect that fails with a NumberFormatException") {
      assertM(ChangingZios.i2.run)(fails(isSubtype[NumberFormatException](anything)))
    },

    testM("f2 should be a ZIO effect that fails with an Exception") {
      assertM(ChangingZios.f2.run)(fails(isSubtype[Exception](anything)))
    },

    testM("s4 should be a ZIO effect that succeeds with 42 mapped to a double value") {
      ???
    },

    testM("i5 should be a ZIO effect that fails with a NumberFormatException") {
      ???
    },

    testM("i5 should be a ZIO effect that succeeds with 42 mapped to a double") {
      ???
    },

    testM("f4 should be a ZIO effect that fails with a DynamicError") {
      ???
    },

    testM("f5 should be a ZIO effect that fails with Error1") {
      ???
    }
  )

}
