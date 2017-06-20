package toonbrew

import toonbrew.Enums._

import scala.util.Random

case class Toon(name: String, race: Race, clazz: Clazz, gender: Gender) {
  def describe: String = s"$gender $race $clazz"
}

object Toon {

  private val raceToClass = Map(
    Barbarian -> Set(Rogue, Shaman, Warrior),
    DarkElf -> Set(Cleric, Enchanter, Magician, Necromancer, Rogue, ShadowKnight, Warrior, Wizard),
    Dwarf -> Set(Cleric, Paladin, Rogue, Warrior),
    Erudite -> Set(Cleric, Enchanter, Magician, Necromancer, Paladin, ShadowKnight, Wizard),
    Gnome -> Set(Cleric, Enchanter, Magician, Necromancer, Paladin, Rogue, ShadowKnight, Warrior, Wizard),
    HalfElf -> Set(Bard, Druid, Paladin, Ranger, Rogue, Warrior),
    Halfling -> Set(Cleric, Druid, Paladin, Ranger, Rogue, Warrior),
    HighElf -> Set(Cleric, Enchanter, Magician, Paladin, Wizard),
    Human -> Set(Bard, Cleric, Druid, Enchanter, Magician, Monk, Necromancer, Paladin, Ranger, Rogue, ShadowKnight, Warrior, Wizard),
    Iksar -> Set(Monk, Necromancer, ShadowKnight, Shaman, Warrior),
    Ogre -> Set(ShadowKnight, Shaman, Warrior),
    Troll -> Set(ShadowKnight, Shaman, Warrior),
    WoodElf -> Set(Bard, Druid, Ranger, Rogue, Warrior)
  )

  // todo - city & deity are tightly coupled. Selecting one will limit the other.
/*
  private def toCities(r: Race, c: Clazz): Set[City] = r match {
    case Barbarian => Set(Halas)
    case DarkElf => Set(Neriak)
    case Dwarf => Set(Kaladim)
    case Erudite if c == ShadowKnight || c == Necromancer => Set(Paineel)
    case Erudite => Set(Erudin)
    case Gnome => Set(AkAnon)
    case HalfElf => c match {
      case Bard | Rogue => Set(Freeport, Kelethin, Qeynos)
      case Druid | Ranger => Set(Qeynos)
      case Paladin => Set(Felwithe)
    }

    // etc
  }

  private def toBeliefs(r: Race, c: Clazz): Set[Belief] = (r, c) match {
    case (HalfElf, Bard) => Set(Agnostic, Bristlebane, Karana, ErollisiMarr, MithanealMarr, RodcetNife, Prexus,
      Quellious, SolusekRo, BrellSerilis, TheTribunal, Tunare, Veeshan, RallosZek)
    case (HalfElf, Druid | Ranger) => Set(Karana, Tunare)
    case (HalfElf, Paladin) => Set(Karana, ErollisiMarr, MithanealMarr, RodcetNife, Tunare)
    case (HalfElf, Rogue) => Set(Agnostic, Bertoxxulous, Bristlebane, Karana, ErollisiMarr, RodcetNife, Tunare)

  }
*/

  private def choose[T](ts: Seq[T]): T = ts(Random.nextInt(ts.size))

  def random: Toon = {
    val race = choose(raceToClass.keys.toSeq)
    val clazz = choose(raceToClass(race).toSeq)
    val gender = choose(Seq(Female, Male))
//    val cities = toCities(race, clazz).toSeq
//    val city = cities(Random.nextInt(cities.size))
    val name = choose(FantasyNames.names("Dungeon And Dragons", "drows", 10, if (gender == Male) 1 else 0))
    Toon(name, race, clazz, gender)
  }

}
