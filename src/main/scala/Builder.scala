import Types.{Operand, Expression}

import scala.io.Source
import argonaut._, Argonaut._

/**
 * Created by Andi on 12/10/2015.
 */
object Builder extends App {

  import Types.{ExpressionCodecJson, OperandCodecJson}

  val expressions = Source.fromFile("dgmexpressions.json").getLines().mkString("\n").decodeOption[List[Expression]].getOrElse(Nil).map(e => (e.expressionID, e)).toMap
  val operands = Source.fromFile("operands.json").getLines().mkString("\n").decodeOption[List[Operand]].getOrElse(Nil).map(o => (o.operandID, o)).toMap

  val stasisweb = Map("preExpression" -> expressions(3489), "postExpression" -> expressions(3491))

  println("done")

}
