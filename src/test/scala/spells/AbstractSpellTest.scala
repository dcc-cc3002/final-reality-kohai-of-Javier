package spells

import weapons._
import weapons.magicweapons._
import characters._
import characters.magicalcharacters._
import characters.enemies._
import exceptions._
import exceptions.spellexceptions.{InsufficientManaException, InvalidTargetException, NoMagicWeaponException}

/** Abstract class for testing spells.*/
abstract class AbstractSpellTest extends munit.FunSuite {

    var whiteChar: MagicalCharacter = _
    var blackChar: MagicalCharacter = _
    var testAlly: WCharacter = _
    var testEnemy: TEnemy = _
    var testWeapon: Weapon = _
    var testWeapon2: Weapon = _
    val positiveSpell: Spell = new Healing
    val negativeSpell: Spell = new Poison

    override def beforeEach(context: BeforeEach) = {
        whiteChar = new WhiteMage("WhiteMage", 100, 50, 70, 40)
        blackChar = new BlackMage("Black Mage", 100, 50, 70, 40)
        testAlly = new Paladin("Paladin", 100, 50, 70)
        testEnemy = new Enemy("Enemy", 100, 60, 50, 70)
        testWeapon = new Wand("Wand", 30, 40, 10, whiteChar)
        testWeapon2 = new Wand("Wand", 30, 40, 10, blackChar)
    }

    test("Not enough mana") {
        whiteChar = new WhiteMage("WhiteMage", 100, 50, 70, 0)
        intercept[InsufficientManaException](negativeSpell.execute(whiteChar, testEnemy))
    }

    test("Positive spell over enemy") {
        intercept[InvalidTargetException](positiveSpell.execute(whiteChar, testEnemy))
    }

    test("Negative spell over ally") {
        intercept[InvalidTargetException](negativeSpell.execute(whiteChar, testAlly))
    }

    test("Spell over a dead target") {
        testEnemy = new Enemy("Enemy", 0, 60, 50, 70)
        intercept[InvalidTargetException](negativeSpell.execute(whiteChar, testEnemy))
    }

    test("Spell without weapon") {
        whiteChar.unsetWeapon
        intercept[NoMagicWeaponException](negativeSpell.execute(whiteChar, testEnemy))
    }

    test("Spell with non magical weapon") {
        whiteChar = new WhiteMage("WhiteMage", 100, 50, 70, 40)
        testWeapon = new Bow("Bow",30, 10, whiteChar)
        intercept[NoMagicWeaponException](negativeSpell.execute(whiteChar, testEnemy))
    }
}
