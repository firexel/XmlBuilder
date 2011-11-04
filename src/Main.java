import xml.XML;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 03.11.11
 * Time: 9:00
 */
public class Main
{
    public static void main(String argv[])
    {
        // simple inline example
        String xmls = XML.build("root")
                .child("entry")
                    .attr("attr1", "value1")
                    .attr("attr2", "value2")
                    .close()
                .child("another_entry")
                    .child("child1")
                        .attr("attr-in-text", "attr value")
                        .text("some text")
                        .close()
                    .child("child2")
                        .cdata("text-under-cdata")
                        .close()
                    .close()
                .print(XML.FOR_HUMAN);

        System.out.println(xmls);

        /*Prints following XML

        <root>
            <entry attr1="value1" attr2="value2"/>
            <another_entry>
                <child1 attr-in-text="attr value">
                    some text
                <child1/>
                <child2>
                    <![CDATA[text-under-cdata]]>
                <child2/>
            <another_entry/>
        <root/>

         */

        // mapping example
        Map<String, String> attributesMAp = new TreeMap<String, String>();
        attributesMAp.put("status", "online");
        attributesMAp.put("login", "firexel");
        attributesMAp.put("password", "qwerty");
        Map<String, String> childMap = new TreeMap<String, String>();
        childMap.put("status", "offline");
        childMap.put("login", null);
        childMap.put("password", "123456");
        String mappedXml = XML.build("root")
                .child("user")
                    .attrs(attributesMAp)
                    .close()
                .child("user")
                    .childs(childMap)
                    .close()
                .print(XML.FOR_HUMAN);
        System.out.println(mappedXml);

        /* Prints following XML

        <root>
            <user login="firexel" password="qwerty" status="online"/>
            <user>
                <login>
                    null
                <login/>
                <password>
                    123456
                <password/>
                <status>
                    offline
                <status/>
            <user/>
        <root/>

         */


    }
}
