package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/admin/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping
    public Result<String> addDish(@RequestBody DishDTO dishDTO) {
        log.info("添加菜品：{}", dishDTO.toString());
        dishService.saveDish(dishDTO);
        return Result.success("添加菜品成功");
    }

    @GetMapping(value = "/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("菜品分页查询：{}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }
}
