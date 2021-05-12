package com.liang.image.service;

import com.liang.image.model.Image;

public interface ImageService {
    Image getImage(int id);

    void addImage(Image image);
}
