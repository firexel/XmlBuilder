package xml;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: alex
 * Date: 03.11.11
 * Time: 9:01
 */
public class XmlTagBuilder implements TagBuilder
{
    private Tag tag;
    private XmlTagBuilder parentBuilder;

    public XmlTagBuilder(String name)
    {
        tag = new Tag();
        tag.name = name;
    }

    private XmlTagBuilder(Tag tag, XmlTagBuilder parentBuilder)
    {
        this.tag = tag;
        this.parentBuilder = parentBuilder;
    }

    public TagBuilder attr(String name, String value)
    {
        Attribute attribute = new Attribute();
        attribute.name = name;
        attribute.value = value;
        tag.attributes.add(attribute);
        return this;
    }

    public TagBuilder attrs(Map<String, ?> attrs)
    {
        for(String key : attrs.keySet())
        {
            Object value = attrs.get(key);
            if(value != null)
                attr(key, value.toString());
            else
                attr(key, "null");
        }
        return this;
    }

    public TagBuilder child(String name)
    {
        Tag child = new Tag();
        child.name = name;
        tag.childs.add(child);
        return new XmlTagBuilder(child, this);
    }

    public TagBuilder childs(Map<String, ?> attrs)
    {
        for(String key : attrs.keySet())
        {
            Object value = attrs.get(key);
            String string = "null";
            if(value != null)
                string = value.toString();

            child(key).text(string);
        }
        return this;
    }

    public TagBuilder text(String text)
    {
        TextTag textTag = new TextTag(text);
        tag.childs.add(textTag);
        return this;
    }

    public TagBuilder cdata(String text)
    {
        CDataTag cDataTag = new CDataTag(text);
        tag.childs.add(cDataTag);
        return this;
    }

    public TagBuilder close()
    {
        return parentBuilder;
    }

    public String print(Formatter formatter)
    {
        StringBuilder builder = new StringBuilder();
        tag.print(formatter, builder);
        return builder.toString();
    }

    @Override
    public String toString()
    {
        return tag.toString();
    }
}
