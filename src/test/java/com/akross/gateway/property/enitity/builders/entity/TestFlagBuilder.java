package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.Flag;

public final class TestFlagBuilder {
    private String flag;

    private TestFlagBuilder() {
    }

    public static TestFlagBuilder aFlag() {
        return new TestFlagBuilder();
    }

    public TestFlagBuilder withFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public Flag build() {
        return new Flag(flag);
    }
}
