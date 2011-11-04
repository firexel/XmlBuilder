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

    public TextTag(String text)
    {
        this.text = text;
    }

    @Override
    protected void print(Formatter formatter, StringBuilder builder, int indent)
    {
        builder.append(text);
    }
}
