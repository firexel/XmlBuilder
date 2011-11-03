package xml;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 03.11.11
 * Time: 9:08
 */
public class Tag
{
    String name = "";
    List<Attribute> attributes = new LinkedList<Attribute>();
    List<Tag> childs = new LinkedList<Tag>();

    public void prettyPrint(StringBuilder builder)
    {
        prettyPrint(builder, 0);
    }

    protected void prettyPrint(StringBuilder builder, int indent)
    {
        for (int i = 0; i < indent; i++)
            builder.append('\t');
        
        builder.append('<');
        builder.append(name);
        for (Attribute attribute : attributes)
        {
            builder.append(' ')
                    .append(attribute.name)
                    .append("=\"")
                    .append(attribute.value)
                    .append("\"");
        }
        if (childs.size() == 0)
        {
            builder.append("/>\n");
        }
        else
        {
            builder.append(">\n");

            for (Tag tag : childs)
                tag.prettyPrint(builder, indent + 1);

            for(int i=0; i<indent; i++)
                builder.append('\t');

            builder.append('<')
                    .append(name)
                    .append("/>\n");
        }
    }
}
