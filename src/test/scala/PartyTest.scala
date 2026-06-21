import scala.collection.mutable.ArrayBuffer
import characters.TCharacter
import characters.Ninja

class PartyTest extends munit.FunSuite {

    //TODO: Add constructor test

    test("isDefeated") {
        //Arrange
        val sampleParty = new Party(new ArrayBuffer[TCharacter]())

        //Act
        val result: Boolean = sampleParty.isDefeated

        //Assert
        assertEquals(result, true)
    }

    //We test whether addCharacter methods works
    test("character added") {
        //Arrange
        val sampleParty = new Party(new ArrayBuffer[TCharacter]())
        sampleParty.addCharacter(new Ninja("Ninja 1", 100, 50, 70))

        //Act
        val result: Boolean = sampleParty.isDefeated

        //Assert
        assertEquals(result, false)
    }
}
