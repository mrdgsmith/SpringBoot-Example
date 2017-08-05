package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.Flag;
import com.akross.gateway.property.entity.Flags;

import java.util.List;

public final class TestFlagsBuilder {
    private List<Flag> flag;

    private TestFlagsBuilder() {
    }

    public static TestFlagsBuilder aFlags() {
        return new TestFlagsBuilder();
    }

    public TestFlagsBuilder withFlag(List<Flag> flag) {
        this.flag = flag;
        return this;
    }

    public Flags build() {
        return new Flags(flag);
    }
}
