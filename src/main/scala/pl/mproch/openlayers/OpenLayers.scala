package pl.mproch.openlayers

import org.scalajs.dom.Element

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.{JSExportAll, JSName}
import js.JSConverters._


object OpenLayers {
  type Coordinates = js.Array[Double]

  implicit def lonLatToMercator(lonLat: (Double, Double)): Coordinates = Projection.fromLonLat(js.Array(lonLat._1, lonLat._2))

}

@JSName("ol.proj")
@js.native
object Projection extends js.Object {
  def fromLonLat(coordinates: OpenLayers.Coordinates): OpenLayers.Coordinates = js.native
}

@JSName("ol.Map")
@js.native
class OSMMap(options: OSMMapOpts) extends js.Object {
  def addControl(control: Control): Unit = js.native

  def setTarget(target: OSMMap.Target): Unit = js.native

  def getView(): View = js.native

}

object OSMMap {

  type Target = String | Element

  def apply(target: String | Element,
            layers: Seq[Layer] = List(),
            controls: Seq[Control] = List(),
            view: View) = new OSMMap(OSMMapOpts(target, layers.toJSArray, controls.toJSArray, view))

}

@JSName("ol.layer.Tile")
@js.native
class TileLayer(options: TileOptions) extends js.Object with Layer

object TileLayer {
  def apply(source: Tile) = new TileLayer(TileOptions(source))
}

@JSName("ol.layer.Vector")
@js.native
class VectorLayer(options: VectorLayerOptions) extends js.Object with Layer

object VectorLayer {
  def apply(source: VectorSource, style: js.UndefOr[Style] = js.undefined) = new VectorLayer(VectorLayerOptions(source, style))
}

@JSName("ol.source.Vector")
@js.native
class VectorSource(options: VectorOptions) extends js.Object

object VectorSource {
  def apply(features: List[Feature]) = new VectorSource(VectorOptions(features.toJSArray))
}

@JSName("ol.source.MapQuest")
@js.native
class MapQuest(options: MapQuestOptions) extends js.Object with Tile

object MapQuest {
  def apply(layer: String) = new MapQuest(MapQuestOptions(layer))
}

@JSName("ol.source.OSM")
@js.native
class OSM() extends js.Object with Tile

@JSName("ol.View")
@js.native
class View(options: ViewOptions) extends js.Object {
  def setCenter(center: OpenLayers.Coordinates): Unit = js.native
}

object View {
  def apply(zoom: Integer, center: OpenLayers.Coordinates) = new View(ViewOptions(zoom, center))
}

@JSName("ol.control.ZoomSlider")
@js.native
class ZoomSlider() extends js.Object with Control

@JSName("ol.control.OverviewMap")
@js.native
class OverViewMap() extends js.Object with Control

@JSExportAll
private case class OSMMapOpts(target: String | Element,
                              layers: js.Array[Layer] = js.Array(), controls: js.Array[Control] = js.Array(),
                              view: View)


@JSExportAll
case class TileOptions(source: Tile)

@JSExportAll
case class ViewOptions(zoom: Integer, center: OpenLayers.Coordinates)

@JSExportAll
case class MapQuestOptions(layer: String)

@JSExportAll
case class VectorLayerOptions(source: VectorSource, style: js.UndefOr[Style] = js.undefined)

@JSExportAll
case class VectorOptions(features: js.Array[Feature])

@js.native
trait Layer extends js.Any

@js.native
trait Source extends js.Any

@js.native
trait Tile extends js.Any

@js.native
trait Control extends js.Any