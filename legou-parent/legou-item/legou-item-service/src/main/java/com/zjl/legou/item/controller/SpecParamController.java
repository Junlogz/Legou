package com.zjl.legou.item.controller;

import com.zjl.legou.core.controller.BaseController;
import com.zjl.legou.item.po.SpecParam;
import com.zjl.legou.item.service.ISpecParamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/15 18:26
 */
@RestController
@RequestMapping(value = "/param")
public class SpecParamController extends BaseController<ISpecParamService, SpecParam> {

    @ApiOperation(value="查询", notes="根据实体条件查询参数")
    @PostMapping(value = "/select-param-by-entity")
    public List<SpecParam> selectSpecParamApi(@RequestBody SpecParam entity) {
        return service.list(entity);
    }

}
