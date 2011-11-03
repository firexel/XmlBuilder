import xml.XML;

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
        String xmls = XML.build("root")
                .child("entry")
                    .attr("attr1", "value1")
                    .attr("attr2", "value2")
                    .close()
                .child("another_entry")
                    .child("child1", "some text value")
                        .attr("attr-in-text", "attr value")
                        .close()
                    .child("child2", "another text value")
                        .close()
                    .close()
                .prettyPrint();

        System.out.print(xmls);

        /*Prints following XML

        <root>
            <entry attr1="value1" attr2="value2"/>
            <another_entry>
                <child1 attr-in-text="attr value">some text value<child1/>
                <child2>another text value<child2/>
            <another_entry/>
        <root/>

         */
    }
}
