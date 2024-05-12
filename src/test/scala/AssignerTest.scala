import scala.collection.mutable
import characters.TCharacter
import characters.Ninja

class AssignerTest extends munit.FunSuite {
    var testAssigner: Programmer = new Assigner()
    val testNinja: TCharacter = new Ninja("Ninja 1", 100, 50, 70)

    override def beforeEach(context: BeforeEach): Unit = {
        testAssigner = new Assigner()
        testAssigner.addCharacter(testNinja)
    }

    test("Add character") {
        val charactersList: List[(Int, TCharacter)] = testAssigner.getCharacters()
        assertEquals(charactersList.isEmpty, false)
    }

    test("Remove character") {
        testAssigner.removeCharacter(testNinja)

        val charactersList: List[(Int, TCharacter)] = testAssigner.getCharacters()
        assertEquals(charactersList.isEmpty, true)
    }

    test("Augment Action Bar") {
        //Test
        testAssigner.augmentActionBar(10)

        val charactersList: List[(Int, TCharacter)] = testAssigner.getCharacters()
        assertEquals(charactersList.head._1, 10)
    }

    test("Max action bar") {
        //Test
        assertEquals(testAssigner.maxActionBar, 0)

        //Test 2
        testAssigner.augmentActionBar(10)
        assertEquals(testAssigner.maxActionBar, 10)

        //Test 3
        testAssigner.addCharacter(new Ninja("Ninja 2", 100, 50, 70))
        testAssigner.augmentActionBar(10)
        assertEquals(testAssigner.maxActionBar, 20)
    }

    test("Restart action bar") {
        testAssigner.augmentActionBar(10)
        testAssigner.restartActionBar(testNinja)

        assertEquals(testAssigner.maxActionBar, 0)
    }

    test("Completed action bar") {
        //Test
        assertEquals(testAssigner.completedActionBar(testNinja), false)

        //Test 2
        testAssigner.augmentActionBar(testNinja.fullActionBar)
        assertEquals(testAssigner.completedActionBar(testNinja), true)
    }

    test("Throw complete characters") {
        //Test
        val testNinja2: TCharacter = new Ninja("Ninja 2", 100, 50, 70)
        val testNinja3: TCharacter = new Ninja("Ninja 3", 100, 50, 70)
        testAssigner.augmentActionBar(10)
        testAssigner.addCharacter(testNinja2)
        testAssigner.augmentActionBar(20)
        testAssigner.addCharacter(testNinja3)
        var completeCharacters: List[TCharacter] = testAssigner.throwCompleteCharacters

        assertEquals(completeCharacters.isEmpty, true)

        //Test 2
        testAssigner.augmentActionBar(60)
        completeCharacters = testAssigner.throwCompleteCharacters
        assertEquals(completeCharacters, List(testNinja, testNinja2))
    }

    test("Select character") {
        testAssigner.augmentActionBar(10)
        testAssigner.addCharacter(new Ninja("Ninja 2", 100, 50, 70))
        testAssigner.augmentActionBar(20)
        testAssigner.addCharacter(new Ninja("Ninja 3", 100, 50, 70))
        testAssigner.augmentActionBar(60)

        val selected: TCharacter = testAssigner.selectCharacter
        assertEquals(selected, testNinja)
    }

    test("Get characters") {
        val charactersList: List[(Int, TCharacter)] = testAssigner.getCharacters
        assertEquals((0, testNinja), charactersList.head)
    }
}
