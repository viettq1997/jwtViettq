package com.iist.vse900.controller;

import com.iist.vse900.controller.base.BaseController;
import com.iist.vse900.domain.model.Category;
import com.iist.vse900.service.CategoriesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Api(description = "Controller thao tác với Category")
@RequestMapping(value = "/category")
public class CategoriesController extends BaseController {

    @Autowired
    CategoriesService categoriesService;


    @GetMapping(value = "/list")
    @ApiOperation("Lấy ra danh sách tất cả Category")
    public ResponseEntity list() {
        List<Category> list = categoriesService.getAll();
        return buildResultJson(200, "success", list);
    }

    @GetMapping(value = "/listByType")
    @ApiOperation("Lấy ra danh sách Category theo type")
    public ResponseEntity listByType(@RequestParam @ApiParam("Kiểu của Category") String type) {
        List<Category> list = categoriesService.getCategoryByType(type);
        return buildResultJson(200, "success", list);
    }

    @PostMapping(value = "/save")
    @ApiOperation("Lưu Category vào database")
    public ResponseEntity save(@RequestBody Category category) {
        boolean result = categoriesService.save(category);
        return buildResultJson(200, null, null);
    }

    @PostMapping(value = "/delete")
    @ApiOperation("Xóa Category")
    public ResponseEntity delete(@RequestParam @ApiParam("id của Category cần xóa") Long id) {
        boolean result = categoriesService.delete(id);
        return buildResultJson(200, null, null);
    }
}
