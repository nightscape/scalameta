import org.scalatest._
import scala.meta.ui._
import scala.meta.dialects.Dotty

class DottySuite extends ParseSuite {
  test("case List(xs: _*)") {
    val tree = pat("List(xs: _*)")
    assert(tree.show[Raw] === "Pat.Extract(Term.Name(\"List\"), Nil, List(Pat.Bind(Pat.Var(Term.Name(\"xs\")), Pat.Arg.SeqWildcard())))")
    assert(tree.show[Code] === "List(xs: _*)")
  }
}