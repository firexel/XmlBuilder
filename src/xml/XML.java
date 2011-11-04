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

    public static final Formatter FOR_HUMAN = new Formatter()
    {
        @Override
        public void printIndent(StringBuilder builder, int tabs)
        {
            for(int i=0; i<tabs; i++)
                builder.append('\t');
        }

        @Override
        public void printLine(StringBuilder builder)
        {
            builder.append('\n');
        }
    };

    public static final Formatter FOR_MACHINE = new Formatter()
    {
        @Override
        public void printIndent(StringBuilder builder, int tabs)
        {
        }

        @Override
        public void printLine(StringBuilder builder)
        {
        }
    };
}
