package toonbrew

import org.scalajs.jquery.jQuery

import scala.scalajs.js.JSApp

object Main extends JSApp {
  def main(): Unit = {
    jQuery(() => {
      brewToon()
      setupUI()
    })
  }

  def setupUI(): Unit = {
    jQuery("#brew-toon-button").click(() => {
      brewToon()
    })
  }

  def brewToon(): Unit = {
    val toon = Toon.random
    jQuery("#toon-name").html(s"${toon.race} ${toon.clazz}")
    jQuery("#toon-desc").html(s"${toon.gender}<br/>${toon.city}<br/>${toon.worship}")
  }
}
