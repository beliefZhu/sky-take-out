package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.result.Result;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/admin")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping(value = "/dish")
    public Result<String> addDish(@RequestBody DishDTO dishDTO) {
        log.info("添加菜品：{}", dishDTO.toString());
        dishService.saveDish(dishDTO);
        return Result.success("添加菜品成功");
    }
}
