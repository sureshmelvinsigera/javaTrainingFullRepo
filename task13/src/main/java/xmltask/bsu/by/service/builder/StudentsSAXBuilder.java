package xmltask.bsu.by.service.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import xmltask.bsu.by.service.StudentHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class StudentsSAXBuilder extends AbstractStudentsBuilder {
    private static final Logger LOGGER = LogManager.getLogger();

    private StudentHandler studentHandler;
    private XMLReader reader;

    public StudentsSAXBuilder() {
        studentHandler = new StudentHandler();
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(studentHandler);
        } catch (SAXException e) {
            LOGGER.error(e.getMessage());
        } catch (ParserConfigurationException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void buildListStudents(InputStream inputStream) {
        try {
            InputSource inputSource = new InputSource(new BufferedInputStream(inputStream));
            reader.parse(inputSource);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } catch (SAXException e) {
            LOGGER.error(e.getMessage());
        }
        students = studentHandler.getStudents();
    }
}
