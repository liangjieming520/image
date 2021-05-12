package com.liang.image.model;

import java.util.Arrays;

public class Image {

    private int id;
    private byte[] image;

    public Image() {
    }

    public Image(int id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
