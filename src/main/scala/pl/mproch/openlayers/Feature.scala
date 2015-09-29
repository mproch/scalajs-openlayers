package pl.mproch.openlayers

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

object Feature {
}

@JSName("ol.Feature")
@js.native
class Feature(geometry: Geometry) extends js.Object

@JSName("ol.geom.Circle")
@js.native
class Circle(center: OpenLayers.Coordinates, radius: Int, geometryLayout: String = "XY") extends js.Object with SimpleGeometry {
  def setCenter(center: OpenLayers.Coordinates) : Unit = js.native
}

@js.native
trait Geometry extends js.Any


@js.native
trait SimpleGeometry extends Geometry
