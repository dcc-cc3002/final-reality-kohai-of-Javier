import scala.collection.mutable
import characters.CharacterTrait
import characters.Ninja

class AssignerTest extends munit.FunSuite {
    var testAssigner: Programmer = new Assigner()
    val testNinja: CharacterTrait = new Ninja("Ninja 1", 100.0, 50.0, 70.1)

    override def beforeEach(context: BeforeEach): Unit = {
        testAssigner = new Assigner()
        testAssigner.addCharacter(testNinja)
    }

    test("Add character") {
        val charactersList: List[(Double, CharacterTrait)] = testAssigner.getCharacters()
        assertEquals(charactersList.isEmpty, false)
    }

    test("Remove character") {
        testAssigner.removeCharacter(testNinja)

        val charactersList: List[(Double, CharacterTrait)] = testAssigner.getCharacters()
        assertEquals(charactersList.isEmpty, true)
    }

    test("Augment Action Bar") {
        //Test 1
        testAssigner.augmentActionBar(10)

        val charactersList: List[(Double, CharacterTrait)] = testAssigner.getCharacters()
        assertEquals(charactersList.head._1, 10.0)
    }

    test("Max action bar") {
        //Test 1
        assertEquals(testAssigner.maxActionBar, 0.0)

        //Test 2
        testAssigner.augmentActionBar(10)
        assertEquals(testAssigner.maxActionBar, 10.0)

        //Test 3
        testAssigner.addCharacter(new Ninja("Ninja 2", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(20)
        assertEquals(testAssigner.maxActionBar, 30.0)
    }

    test("Restart action bar") {
        testAssigner.augmentActionBar(10)
        testAssigner.restartActionBar(testNinja)

        assertEquals(testAssigner.maxActionBar, 0.0)
    }

    test("Completed action bar") {
        //Test 1
        assertEquals(testAssigner.completedActionBar(testNinja), false)

        //Test 2
        testAssigner.augmentActionBar(testNinja.maxActionBar)
        assertEquals(testAssigner.completedActionBar(testNinja), true)
    }

    test("Throw complete characters") {
        testAssigner.augmentActionBar(10)
        testAssigner.addCharacter(new Ninja("Ninja 2", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(20)
        testAssigner.addCharacter(new Ninja("Ninja 3", 100.0, 50.0, 70.1))
        var completeCharacters: List[CharacterTrait] = testAssigner.throwCompleteCharacters

        assertEquals(completeCharacters.isEmpty, true)

        testAssigner.augmentActionBar(50)
        completeCharacters = testAssigner.throwCompleteCharacters
        assertEquals(completeCharacters.size, 1)
        assertEquals(completeCharacters.head, testNinja)
    }

    test("Select character") {
        testAssigner.augmentActionBar(10)
        testAssigner.addCharacter(new Ninja("Ninja 2", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(20)
        testAssigner.addCharacter(new Ninja("Ninja 3", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(50)

        val selected: CharacterTrait = testAssigner.selectCharacter
        assertEquals(selected, testNinja)
    }

    test("Get characters") {
        val charactersList: List[(Double, CharacterTrait)] = testAssigner.getCharacters
        assertEquals((0.0, testNinja), charactersList.head)
    }
}
