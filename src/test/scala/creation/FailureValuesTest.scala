package creation

import zio.test.Assertion.{anything, equalTo, fails, isSubtype}
import zio.test.{DefaultRunnableSpec, ZSpec, assertM}

object FailureValuesTest extends DefaultRunnableSpec {

  def spec: ZSpec[_root_.zio.test.environment.TestEnvironment, Any] = suite("Test failing ZIOs")(

    testM("Failure with String value") {

      assertM(FailureValues.f1.run)(fails(equalTo("Boom!")))

    },

    testM("Failure with Throwable") {

      assertM(FailureValues.f2.run)(fails(isSubtype[Exception](anything)))

    },

    testM("Failure with String value") {
      ???
    },

    testM("Failure with String value") {
      ???
    }
  )
}
