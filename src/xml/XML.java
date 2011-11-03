package xml;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 03.11.11
 * Time: 9:05
 */
public class XML
{
    public static TagBuilder build(String name)
    {
        return new XmlTagBuilder(name);
    }
}
