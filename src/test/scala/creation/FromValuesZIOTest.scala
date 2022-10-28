package creation

import creation.FromValues.Dog
import creation.FromValues.Dog.DogReadError
import zio.test.Assertion.{anything, equalTo, fails, isSubtype}
import zio.test.{DefaultRunnableSpec, ZSpec, assertM}

object FromValuesZIOTest extends DefaultRunnableSpec {

  def spec: ZSpec[_root_.zio.test.environment.TestEnvironment, Any] = suite("Check ZIOs from other values")(

    testM("zOpt3 should be a ZIO effect that succeeds with an integer of 2") {
      assertM(FromValues.zOpt3)(equalTo(2))
    },

    testM("zOpt3 should be a ZIO effect that fails with a string") {
      assertM(FromValues.zOpt4.run)(fails(isSubtype[String](anything)))
    },

    testM("zEither1 should be a ZIO effect that succeeds with an integer of 5") {
      assertM(FromValues.zEither1)(equalTo(5))
    },

    testM("zEither2 should be a ZIO effect that fails with a string") {
      assertM(FromValues.zEither2.run)(fails(isSubtype[String](anything)))
    },

    testM("s4 should be a ZIO effect that succeeds with an integer value of 21") {
      assertM(FromValues.zTry1)(equalTo(21))
    },

    testM("zTry2 should be a ZIO effect that fails with a ClassCastException") {
      assertM(FromValues.zTry2.run)(fails(isSubtype[ClassCastException](anything)))
    },

    testM("zioBonnie1 should be a ZIO effect that succeeds with a Dog") {
      ???
    },

    testM("zioBonnie2 should be a ZIO effect that fails with a DogReadError") {
      ???
    }
  )

}
