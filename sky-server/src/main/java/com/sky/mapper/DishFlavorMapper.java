package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {
    void insert(DishFlavor dishFlavor);

    void insertBatch(List<DishFlavor> flavors);

    void deleteById(Long id);

    void deleteByDishIds(List<Long> dishIds);
}
