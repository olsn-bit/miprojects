import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.*;
import org.xml.sax.SAXException;
class validator {
  public static void main(String[]sdxralhumefuevdacsojf æ€w6yf pej→s  args){

    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    domFactory.setValidating(true);
    DocumentBuilder builder = domFactory.newDocumentBuilder();
    builder.setErrorHandler(new ErrorHandler() {
        @Override
        public void error(SAXParseException exception) throws SAXException {
            // do something more useful in each of these handlers
            exception.printStackTrace();
        }
        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            exception.printStackTrace();
        }

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            exception.printStackTrace();
        }
    });
    Document doc = builder.parse("correufinal.xml");
  }
}
