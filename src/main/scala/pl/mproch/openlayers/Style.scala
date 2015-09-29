package pl.mproch.openlayers

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.{JSExportAll, JSName}

@js.native
@JSName("ol.style.Style")
class Style(options: StyleOptions) extends js.Object

object Style {
  type Color = js.Array[Double]
  def apply(geometry: js.UndefOr[Geometry] = js.undefined,
                          fill: js.UndefOr[Fill] = js.undefined,
                          stroke: js.UndefOr[Stroke] = js.undefined,
                          text: js.UndefOr[String] = js.undefined)
    = new Style(StyleOptions(geometry, fill, stroke, text))
}

@JSExportAll
case class StyleOptions(geometry: js.UndefOr[Geometry] = js.undefined,
                        fill: js.UndefOr[Fill] = js.undefined,
                        stroke: js.UndefOr[Stroke] = js.undefined,
                        text: js.UndefOr[String] = js.undefined)


@JSName("ol.style.Fill")
@js.native
class Fill(options: FillOptions) extends js.Object

object Fill {
  def apply(color: Style.Color) = new Fill(FillOptions(color))
}

@JSExportAll
case class FillOptions(color: Style.Color)

@JSName("ol.style.Stroke")
@js.native
class Stroke(options: StrokeOptions) extends js.Object

object Stroke {
  def apply(color: Style.Color, width: Double) = new Stroke(StrokeOptions(color, width))
}

@JSExportAll
case class StrokeOptions(color: Style.Color | String, width: Double)
