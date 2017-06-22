package toonbrew

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("fantasy-names", JSImport.Namespace)
object FantasyNames extends js.Function5[String, String, Int, Int, String, String] {
  def apply(cat: String, subCat: String, names: Int, gender: Int, seed: String): String = js.native
}

