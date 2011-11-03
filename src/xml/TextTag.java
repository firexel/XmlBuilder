package xml;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 03.11.11
 * Time: 10:53
 */
public class TextTag extends Tag
{
    String text = "";

    @Override
    protected void prettyPrint(StringBuilder builder, int indent)
    {
        for (int i = 0; i < indent; i++)
            builder.append('\t');

        builder.append('<')
                .append(name);

        for (Attribute attribute : attributes)
        {
            builder.append(' ')
                    .append(attribute.name)
                    .append("=\"")
                    .append(attribute.value)
                    .append("\"");
        }

        builder.append('>')
                .append(text)
                .append('<')
                .append(name)
                .append("/>\n");
    }
}
