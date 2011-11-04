package xml;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 04.11.11
 * Time: 21:54
 */
public class CDataTag extends TextTag
{
    public CDataTag(String text)
    {
        super(text);
    }

    @Override
    protected void print(Formatter formatter, StringBuilder builder, int indent)
    {
        builder.append("<![CDATA[");
        super.print(formatter, builder, indent);
        builder.append("]]>");
    }
}
