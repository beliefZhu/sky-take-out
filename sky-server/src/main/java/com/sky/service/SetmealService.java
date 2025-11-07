package com.sky.service;

import com.sky.entity.Setmeal;
import com.sky.vo.DishItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SetmealService {
    List<Setmeal> list(Setmeal setmeal);

    List<DishItemVO> getDishItemById(Long id);
}
