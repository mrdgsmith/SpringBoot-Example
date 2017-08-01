package com.akross.gateway.property.builders.entity;

import com.akross.gateway.property.entity.EpcFrontPage;
import com.akross.gateway.property.entity.EpcFrontPages;

import java.util.List;

public final class TestEpcFrontPagesBuilder {
    private List<EpcFrontPage> epcFrontPage;

    private TestEpcFrontPagesBuilder() {
    }

    public static TestEpcFrontPagesBuilder anEpcFrontPages() {
        return new TestEpcFrontPagesBuilder();
    }

    public TestEpcFrontPagesBuilder withEpcFrontPage(List<EpcFrontPage> epcFrontPage) {
        this.epcFrontPage = epcFrontPage;
        return this;
    }

    public EpcFrontPages build() {
        return new EpcFrontPages(epcFrontPage);
    }
}
