package com.telesens.academy.lesson12;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Objects;

public class Entry {
    private long key;
    private String Value;

    public Entry(long key, String Value){
        this.key = key;
        this.Value = Value;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", Value='" + Value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return key == entry.key &&
                Objects.equals(Value, entry.Value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, Value);
    }

    @Test
    public void testSimpleEntry() {
        System.out.println("start 'testSimpleEntry'");
        long key = 12L;
        String value = "demoValue";

        Entry entry = new Entry(key, value);
        Entry entryEqual = new Entry(key, value);

        Assert.assertEquals(key, entry.getKey());
        Assert.assertEquals(value, entry.getValue());

        Assert.assertEquals(entry, entryEqual);
    }

    }



