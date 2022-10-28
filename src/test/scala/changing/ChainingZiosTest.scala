package changing

import zio.test.Assertion.equalTo
import zio.test.{DefaultRunnableSpec, ZSpec, assertM}

object ChainingZiosTest extends DefaultRunnableSpec {

  def spec: ZSpec[_root_.zio.test.environment.TestEnvironment, Any] = suite("Test chaining ZIOs")(

    testM("zInt2 should be a ZIO effect that succeeds with the value 6") {
      assertM(ChainingZios.zInt2)(equalTo(6))
    },

    testM("i2 should be a ZIO effect that succeeds with the value 6") {
      assertM(ChainingZios.zInt)(equalTo(6))
    },

    testM("doubledIntsAsStrings should double and map all integers to strings") {
      ???
    }
  )

}
