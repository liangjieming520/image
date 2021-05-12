package com.liang.image.mapper;

import com.liang.image.model.Image;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageMapper {

    Image getImage(int id);

    void addImage(Image image);
}
