package com.paraam.cpeagent.core;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Pretty-prints xml, supplied as a string.
 * <p/>
 * eg.
 * <code>
 * String formattedXml = new XmlFormatter().format("<tag><nested>hello</nested></tag>");
 * </code>
 */
public class XmlFormatter {
    boolean stripXmlDeclaration;
    boolean xsiTypeWorkaround;
            
    public XmlFormatter() {
        this.stripXmlDeclaration = false;
        this.xsiTypeWorkaround = false;
    }
    
    public XmlFormatter(String xmlFormatString) {
        this.stripXmlDeclaration = xmlFormatString.contains("stripdec");
        this.xsiTypeWorkaround = xmlFormatString.contains("faketypes");
    }

    public boolean isStripXmlDeclarationEnabled() {
        return stripXmlDeclaration;
    }

    public boolean isXsiTypeWorkaroundEnabled() {
        return xsiTypeWorkaround;
    }
    
    public String format(String unformattedXml) {        
        try {
            final Document document = parseXmlFile(unformattedXml);

            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer writerOut = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(writerOut, format);
            serializer.serialize(document);

            String out = writerOut.toString();
            
            if(stripXmlDeclaration)
                out = out.replaceAll("<\\?xml.*\\?>\\n*", "");
            
            if(xsiTypeWorkaround)
                out = out.replaceAll("<Value>", "<Value xsi:type=\"xsd:string\">")
                         .replaceAll("<Value/>", "<Value xsi:type=\"xsd:string\"></Value>");
            
            return out;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String unformattedXml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?><QueryMessage\n" +
                        "        xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"\n" +
                        "        xmlns:query=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/query\">\n" +
                        "    <Query>\n" +
                        "        <query:CategorySchemeWhere>\n" +
                        "   \t\t\t\t\t         <query:AgencyID>ECB\n\n\n\n</query:AgencyID>\n" +
                        "        </query:CategorySchemeWhere>\n" +
                        "    </Query>\n\n\n\n\n" +
                        "</QueryMessage>";

        System.out.println(new XmlFormatter().format(unformattedXml));
    }
}