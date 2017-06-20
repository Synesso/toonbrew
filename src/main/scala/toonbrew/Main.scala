package toonbrew

import org.scalajs.jquery.{JQuery, jQuery}

import scala.scalajs.js.JSApp

object Main extends JSApp {
  def main(): Unit = {
    jQuery(() => {
      brewToon()
      setupUI()
    })
  }

  def setupUI(): Unit = {
    jQuery("#brew-toon-button").click(() => brewToon())
  }

  def brewToon(): Unit = {
    val toon = Toon.random
    jQuery("#toon-name").html(toon.name)
    jQuery("#toon-desc").html(toon.describe)
  }
}
