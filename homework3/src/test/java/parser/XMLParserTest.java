package parser;

import org.testng.Assert;
import org.testng.annotations.Test;

public class XMLParserTest {
    private XMLParser parser;

    @Test
    public void testParserSearchFileForParse() {
        parser = new XMLParser("src/test/resources/test.xml.files/first_test_file.xml");
    }

    @Test(expectedExceptions = Exception.class)
    public void testParserSearchFileForParseNotExist() {
        parser = new XMLParser("src/test/resources/test.xml.files/non_existent.xml");
    }

    @Test
    public void testParser() {
        parser = new XMLParser("src/test/resources/test.xml.files/first_test_file.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 0);
    }

    @Test
    public void testParserWithSchema() {
        parser = new XMLParser("src/test/resources/test.xml.files/file_with_my_schema.xml");
        parser.parseDocument();
        Assert.assertNotEquals(parser.getErrors().size(), 0);
    }

    @Test(description = "special characters '>' ")
    public void testParserWithSpecialCharactersOne() {
        parser = new XMLParser("src/test/resources/test.xml.files/file_with_special_characters_one.xml");
        parser.parseDocument();
        Assert.assertNotEquals(parser.getErrors().size(), 0);
    }

    @Test(description = "special characters '<' ")
    public void testParserWithSpecialCharactersTwo() {
        parser = new XMLParser("src/test/resources/test.xml.files/file_with_special_characters_two.xml");
        parser.parseDocument();
        Assert.assertNotEquals(parser.getErrors().size(), 0);
    }

    @Test(description = "special characters '&' ")
    public void testParserWithSpecialCharactersThree() {
        parser = new XMLParser("src/test/resources/test.xml.files/file_with_special_characters_three.xml");
        parser.parseDocument();
        Assert.assertNotEquals(parser.getErrors().size(), 0);
    }

    @Test
    public void testParserWithDoctype() {
        parser = new XMLParser("src/test/resources/test.xml.files/file_with_doctype.xml");
        parser.parseDocument();
        Assert.assertNotEquals(parser.getErrors().size(), 0);
    }

    @Test
    public void testParserWithCDATA() {
        parser = new XMLParser("src/test/resources/test.xml.files/file_with_cdata.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 0);
    }

    @Test
    public void testParserWithNameSpaces() {
        parser = new XMLParser("src/test/resources/test.xml.files/file_with_namespaces.xml");
        parser.parseDocument();
        Assert.assertNotEquals(parser.getErrors().size(), 0);
    }
}


