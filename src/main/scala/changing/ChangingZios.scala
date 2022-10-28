package changing

import zio.ZIO

object ChangingZios {

  //Examples from workshop
  val s1: ZIO[Any, Nothing, Int] = ZIO.succeed(42)
  val s2: ZIO[Any, Nothing, String] = s1.map(_.toString)


  val i1: ZIO[Any, Nothing, String] = ZIO.succeed("hello")
  val i2: ZIO[Any, Throwable, Int] = i1.mapEffect(_.toInt)

  val f1: ZIO[Any, String, Nothing] = ZIO.fail("Boom!")
  val f2: ZIO[Any, Throwable, Nothing] = f1.mapError(msg => new Exception(msg))


  //Working examples
  val s3: ZIO[Any, Nothing, Int] = ZIO.succeed(42)

  //map the int value in s3 to a double
  val s4: ZIO[Any, Nothing, Double] = ???


  val i3: ZIO[Any, Nothing, String] = ZIO.succeed("hello")
  val i4: ZIO[Any, Nothing, String] = ZIO.succeed("42")

  //map the string value in i3 and i4 to a double, move errors to the zio error type
  val i5: ZIO[Any, Throwable, Double] = ???
  val i6: ZIO[Any, Throwable, Double] = ???

  sealed trait Error

  case object Error1 extends Error
  case class DynamicError(msg: String) extends Error

  //create ZIOs of the following types
  val f3: ZIO[Any, String, Nothing] = ???

  //respond with dynamic error
  val f4: ZIO[Any, Error, Nothing] = ???

  //respond with Error1
  val f5: ZIO[Any, Error, Nothing] = ???


}
