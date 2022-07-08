package com.zjl.legou.item.controller;

import com.zjl.legou.core.controller.BaseController;
import com.zjl.legou.item.po.Brand;
import com.zjl.legou.item.po.Category;
import com.zjl.legou.item.service.IBrandService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/12 18:52
 */
@RestController
@RequestMapping(value = "/brand")
public class BrandController extends BaseController<IBrandService, Brand> {

    @Override
    public void afterEdit(Brand entity) {
        //生成分类列表 将查询出来的分类id 转为数组
        List<Category> categories = service.selectCategoryByBrand(entity.getId());
        Long[] ids = new Long[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            ids[i] = categories.get(i).getId();
        }
        entity.setCategoryIds(ids);
    }

    @ApiOperation(value="根据ids查询", notes = "根据ids查询")
    @GetMapping("/list-by-ids")
    public List<Brand> selectBrandByIds(@RequestParam("ids") List<Long> ids) {
        return service.selectBrandByIds(ids);
    }
}
