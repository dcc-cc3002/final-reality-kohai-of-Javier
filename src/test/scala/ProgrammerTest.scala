import scala.collection.mutable.PriorityQueue
import characters.CharacterTrait
import characters.Ninja

class AssignerTest extends munit.FunSuite {
    var testAssigner: Programmer = new Assigner()
    val testNinja: CharacterTrait = new Ninja("Ninja 1", 100.0, 50.0, 70.1)

    override def beforeEach(context: BeforeEach): Unit = {
        testAssigner = new Assigner()
        testAssigner.addCharacter(testNinja)
    }

    //TODO: Constructor test

    test("Add character") {
        val charactersQueue: PriorityQueue[CharacterTrait] = testAssigner.getCharacters()
        assertEquals(charactersQueue.isEmpty(), false)
    }

    test("Remove character") {
        testAssigner.removeCharacter(testNinja)

        val charactersQueue: PriorityQueue[CharacterTrait] = testAssigner.getCharacters()
        assertEquals(charactersQueue.isEmpty(), true)
    }

    test("Augment Action Bar") {
        //Test 1
        testAssigner.augmentActionBar(10)

        val charactersQueue: PriorityQueue[CharacterTrait] = testAssigner.getCharacters()
        assertEquals(charactersQueue.dequeue().getActionBar, 10)

        //Test 2
        testAssigner.addCharacter(new Ninja("Ninja 2", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(20)

        charactersQueue[CharacterTrait] = testAssigner.getCharacters()
        assertEquals(charactersQueue.dequeue().getActionBar, 30)
        assertEquals(charactersQueue.dequeue().getActionBar, 20)
    }

    test("Max action bar") {
        //Test 1
        assertEquals(testAssigner.maxActionBar(), 0)

        //Test 2
        testAssigner.augmentActionBar(10)
        assertEquals(testAssigner.maxActionBar(), 10)

        //Test 3
        testAssigner.addCharacter(new Ninja("Ninja 2", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(20)
        assertEquals(testAssigner.maxActionBar(), 30)
    }

    test("Restart action bar") {
        testAssigner.augmentActionBar(10)
        testAssigner.addCharacter(new Ninja("Ninja 2", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(20)
        testAssigner.restartActionBar()

        assertEquals(testAssigner.maxActionBar(), 0)
    }

    test("Completed action bar") {
        //Test 1
        assertEquals(testAssigner.completedActionBar(testNinja), false)

        //Test 2
        testAssigner.augmentActionBar(testNinja.maxActionBar())
        assertEquals(testAssigner.completedActionBar(testNinja), true)
    }

    test("Throw complete characters") {
        testAssigner.augmentActionBar(10)
        testAssigner.addCharacter(new Ninja("Ninja 2", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(20)
        testAssigner.addCharacter(new Ninja("Ninja 3", 100.0, 50.0, 70.1))
        val completeCharacters: mutable.Iterable[CharacterTrait] = testAssigner.throwCompleteCharacters()

        assertTrue(completeCharacters.isEmpty(), true)

        test.assigner.augmentActionBar(30)
        val charactersQueue: PriorityQueue[CharacterTrait] = testAssigner.getCharacters()
        assertEquals(completeCharacters.forall(_.actionBar() >= _.maxActionBar()), true)
        assertEquals(charactersQueue.exists(_.actionbar() >= _.maxActionBar() && completeCharacters.find(_) == None), false)
        var lastActionBar: Option[Double] = None
        for(element <- completeCharacters) {
            assertEquals(!lastActionBar.isDefined() || element.actionBar() <= lastActionBar.get(), true)
            lastActionBar = Some(element.actionBar())
        }
    }

    test("Select character") {
        testAssigner.augmentActionBar(10)
        testAssigner.addCharacter(new Ninja("Ninja 2", 100.0, 50.0, 70.1))
        testAssigner.augmentActionBar(20)
        testAssigner.addCharacter(new Ninja("Ninja 3", 100.0, 50.0, 70.1))

        val selected: CharacterTrait = testAssigner.selectCharacter()
        assertEquals(selected, testNinja)
    }
}
