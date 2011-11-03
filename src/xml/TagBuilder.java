package xml;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 03.11.11
 * Time: 11:03
 */
public interface TagBuilder extends TextTagBuilder
{
    TagBuilder child(String name);
    TextTagBuilder child(String name, String text);
    TagBuilder attr(String name, String value);
}
