package ru.netherdon.netheragriculture.misc;

import java.util.*;

public class TranslationBuilder
{
    private final String namespace;
    private final Deque<String> path = new LinkedList<>();

    public TranslationBuilder(String namespace)
    {
        this.namespace = namespace;
    }

    public TranslationBuilder push(String path)
    {
        this.path.add(path);
        return this;
    }

    public TranslationBuilder pop()
    {
        this.path.removeLast();
        return this;
    }

    public String build()
    {
        return TranslationHelper.key(this.namespace, this.path);
    }

    public String build(String value)
    {
        this.push(value);
        String key = this.build();
        this.pop();
        return key;
    }
}
