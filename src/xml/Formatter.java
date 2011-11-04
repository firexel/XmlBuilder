package xml;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 04.11.11
 * Time: 21:55
 */
public abstract class Formatter
{
    public abstract void printIndent(StringBuilder builder, int tabs);
    public abstract void printLine(StringBuilder builder);
}
