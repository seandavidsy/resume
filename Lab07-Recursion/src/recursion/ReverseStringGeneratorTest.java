package recursion;

/**
 * Tests that ReverseStringGenerator runs and executes as intended
 * 
 * @author Sean Sy (906311775)
 * @version 2020.10.09
 */
public class ReverseStringGeneratorTest extends student.TestCase {

    @SuppressWarnings("unused")
    private ReverseStringGenerator testGenerator = new ReverseStringGenerator();
    
    /**
     * Tests that static reverse method correctly returns the String
     * in reverse form
     */
    public void testReverse() {
        assertEquals("zyx", ReverseStringGenerator.reverse("xyz"));
        assertEquals("zzzczzd", ReverseStringGenerator.reverse("dzzczzz"));
        assertEquals("abcdef", ReverseStringGenerator.reverse("fedcba"));
        assertEquals("wxyzzymno", ReverseStringGenerator.reverse("onmyzzyxw"));
    }
}
