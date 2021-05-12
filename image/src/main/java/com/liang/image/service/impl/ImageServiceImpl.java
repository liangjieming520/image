package com.liang.image.service.impl;

import com.liang.image.mapper.ImageMapper;
import com.liang.image.model.Image;
import com.liang.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public Image getImage(int id) {
        return imageMapper.getImage(id);
    }

    @Override
    public void addImage(Image image) {
        imageMapper.addImage(image);
    }
}
