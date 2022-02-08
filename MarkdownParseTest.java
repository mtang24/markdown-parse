import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void ParseTest1() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        List<String> list1 = List.of("https://something.com", "some-page.html");
        assertEquals("test file 1", list1, MarkdownParse.getLinks(contents));
    }

    @Test
    public void ParseTest2() throws IOException {
        Path fileName = Path.of("test-file2.md");
	    String contents = Files.readString(fileName);
        List<String> list2 = List.of("https://duckduckgo.com");
        assertEquals("test file 2", list2, MarkdownParse.getLinks(contents));
    }

    @Test
    public void ParseTest3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        List<String> list3 = List.of();
        assertEquals("test file 3", list3.size(), 0);
    }

    @Test
    public void ParseTestActions() throws IOException {
        assertEquals(5, MarkdownParse.subtract(11, 6)); 
    }

    // @Test
    // public void ParseTest4() throws IOException {
    //     Path fileName = Path.of("test-file6.md");
	//     String contents = Files.readString(fileName);
    //     List<String> list4 = List.of("duckduckgo.com");
    //     assertEquals("test file 6", list4, MarkdownParse.getLinks(contents));
    // }


}