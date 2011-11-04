package xml;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 03.11.11
 * Time: 11:03
 */
public interface TagBuilder extends TextTagBuilder
{
    TagBuilder attrs(Map<String, ?> attrs);
    TagBuilder close();
    TagBuilder child(String name);
    TagBuilder childs(Map<String, ?> attrs);
    TagBuilder text(String text);
    TagBuilder cdata(String text);
    TagBuilder attr(String name, String value);
    String print(Formatter formatter);
}
