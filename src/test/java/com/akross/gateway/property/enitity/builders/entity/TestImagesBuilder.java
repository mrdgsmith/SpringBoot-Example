package com.akross.gateway.property.enitity.builders.entity;

import com.akross.gateway.property.entity.Image;
import com.akross.gateway.property.entity.Images;

import java.util.List;

public final class TestImagesBuilder {
    private List<Image> image;

    private TestImagesBuilder() {
    }

    public static TestImagesBuilder anImages() {
        return new TestImagesBuilder();
    }

    public TestImagesBuilder withImage(List<Image> image) {
        this.image = image;
        return this;
    }

    public Images build() {
        return new Images(image);
    }
}
