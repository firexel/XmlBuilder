package xml;

import java.text.Normalizer;
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

    public void print(Formatter formatter, StringBuilder builder)
    {
        print(formatter, builder, 0);
    }

    protected void print(Formatter formatter, StringBuilder builder, int indent)
    {
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
            builder.append("/>");
        }
        else
        {
            builder.append('>');
            formatter.printLine(builder);
            
            for (Tag tag : childs)
            {
                formatter.printIndent(builder, indent + 1);
                tag.print(formatter, builder, indent + 1);
                formatter.printLine(builder);
            }

            formatter.printIndent(builder, indent);

            builder.append('<')
                    .append(name)
                    .append("/>");
        }
    }
}
