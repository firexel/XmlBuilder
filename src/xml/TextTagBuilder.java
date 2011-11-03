package xml;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 03.11.11
 * Time: 11:10
 */
public interface TextTagBuilder
{
    TextTagBuilder attr(String name, String value);
    String prettyPrint();
    TagBuilder close();
}
