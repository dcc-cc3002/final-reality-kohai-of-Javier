import scala.collection.mutable.ArrayBuffer
import characters.TCharacter
import characters.Ninja
import exceptions.PartyLimitException

class PartyTest extends munit.FunSuite {
    var sampleParty: TParty = new Party(new ArrayBuffer[TCharacter]())

    override def beforeEach(context: BeforeEach) = {
        sampleParty = new Party(new ArrayBuffer[TCharacter]())
    }

    test("isDefeated") {
        val result: Boolean = sampleParty.isDefeated

        assertEquals(result, true)
    }

    //We test whether addCharacter methods works
    test("character added") {
        sampleParty.addCharacter(new Ninja("Ninja 1", 100, 50, 70))

        //Act
        val result: Boolean = sampleParty.isDefeated

        //Assert
        assertEquals(result, false)
    }

    //An exception must be thrown if we try to make a party to have more than three charaters.
    test("Too many characters") {
        sampleParty.addCharacter(new Ninja("Ninja 1", 100, 50, 70))
        sampleParty.addCharacter(new Ninja("Ninja 2", 100, 50, 70))
        sampleParty.addCharacter(new Ninja("Ninja 3", 100, 50, 70))
        intercept[PartyLimitException](sampleParty.addCharacter(new Ninja("Ninja 4", 100, 50, 70)))
    }
}
