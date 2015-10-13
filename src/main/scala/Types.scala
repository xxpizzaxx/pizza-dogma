import argonaut._, Argonaut._

object Types {
  case class Expression(
                       expressionGroupID: Option[Long],
                       expressionAttributeID: Option[Long],
                       description: Option[String],
                       expressionValue: Option[String],
                       arg1: Option[Long],
                       arg2: Option[Long],
                       expressionName: String,
                       operandID: Long,
                       expressionID: Long,
                       expressionTypeID: Option[Long]
                         ) {
    def operand(implicit om: Map[Long, Operand]): Option[Operand] = om.get(operandID)
  }
  implicit def ExpressionCodecJson = casecodec10(Expression.apply, Expression.unapply)("expressionGroupID", "expressionAttributeID", "description", "expressionValue", "arg1", "arg2", "expressionName", "operandID", "expressionID", "expressionTypeID")

  case class Operand(
                    resultCategoryID: Long,
                    description: String,
                    operandKey: String,
                    format: String,
                    pythonFormat: String,
                    operandID: Long,
                    arg1categoryID: Option[Long],
                    arg2categoryID: Option[Long]
                      ) {

  }
  implicit def OperandCodecJson = casecodec8(Operand.apply, Operand.unapply)("resultCategoryID", "description", "operandKey", "format", "pythonFormat", "operandID", "arg1categoryID", "arg2categoryID")

}
