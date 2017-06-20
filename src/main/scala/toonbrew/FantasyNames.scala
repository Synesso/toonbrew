package toonbrew

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@JSImport("fantasy-names", JSImport.Namespace)
@js.native
object FantasyNames extends js.Object {
  def names(cat: String, subCat: String, names: Int, gender: Int): js.Array[String] = js.native
}

