import io.circe._
import io.circe.generic.extras.semiauto._
import io.circe.generic.extras.auto._
import io.circe.parser._
import io.estatico.newtype.macros.newtype
import derevo.derive
import derevo.circe.magnolia._
import io.circe.magnolia._

object CirceTest2 extends App {

  implicit val config: Configuration = Configuration.default.withDefaults

  val jsonFromMH: String =
    """
      |{
      |"details" :
      |{
      |  "paymentID": "12345",
      |  "status": "completed",
      |  "updatedAt": "2024-08-30",
      |  "submittedAt": ""
      |}
      |}
    """.stripMargin

  @newtype
  @derive(decoder)
  case class PaymentId(value: String)

  @newtype
  @derive(decoder)
  case class Status(value: String)

  @newtype
  @derive(decoder)
  case class UpdatedAt(value: String)

  @newtype
  @derive(decoder)
  case class SubmittedAt(value: String)

  @io.circe.generic.extras.ConfiguredJsonCodec
  case class PaymentDetails(
                             paymentID: Option[PaymentId],
                             status: Option[Status],
                             updatedAt: Option[UpdatedAt],
                             submittedAt: Option[SubmittedAt]
                           )

  @io.circe.generic.extras.ConfiguredJsonCodec
  case class PaymentWrapper(details: PaymentDetails)

  // Parse the JSON string
  val parsedResult: Either[Error, PaymentWrapper] = decode[PaymentWrapper](jsonFromMH)

  // Handle the result
  parsedResult match {
    case Right(paymentWrapper) => println(s"Parsed PaymentWrapper: $paymentWrapper")
    case Left(error)           => println(s"Failed to parse JSON: $error")
  }
}
