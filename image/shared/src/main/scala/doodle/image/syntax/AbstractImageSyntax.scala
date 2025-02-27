/*
 * Copyright 2015 Creative Scala
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package doodle
package image
package syntax

import cats.effect.unsafe.IORuntime
import doodle.effect.DefaultRenderer
import doodle.effect.Renderer
import doodle.image.Image
import doodle.language.Basic
import doodle.syntax.AbstractRendererSyntax

abstract class AbstractImageSyntax(rendererSyntax: AbstractRendererSyntax) {
  import rendererSyntax._

  implicit class ImageOps(image: Image) {
    def drawWithFrame[Alg <: Basic, Frame, Canvas](
        frame: Frame
    )(implicit renderer: Renderer[Alg, Frame, Canvas], r: IORuntime): Unit =
      image.compile[Alg].drawWithFrame(frame)

    def draw[Alg <: Basic, Frame, Canvas]()(implicit
        renderer: DefaultRenderer[Alg, Frame, Canvas],
        r: IORuntime
    ): Unit =
      image.compile[Alg].draw()
  }
}
