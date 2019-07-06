package doodle
package svg
package examples

import scala.scalajs.js.annotation._
import doodle.svg._

// Wrapper to run an example in a web page
object Example {
  val frame = Frame("canvas").size(600,600)

  @JSExportTopLevel("Main")
  def main(): Unit = {
    // Squares.squares.draw(frame)
    //
    // SierpinskiRipple.image.draw(frame)
    //
    // GradientCircle.image.draw(frame)
    //
    import doodle.interact.syntax._
    import cats.implicits._

    Orbit.frames.animateFrames(frame)
    //
    // import doodle.interact.syntax._
    // import cats.implicits._
    // import doodle.svg._
    // (
    //   for {
    //     canvas <- MouseOver.frame.canvas()
    //   } yield MouseOver.frames.animate(canvas)
    // ).unsafeRunAsync(println _)
  }
}
