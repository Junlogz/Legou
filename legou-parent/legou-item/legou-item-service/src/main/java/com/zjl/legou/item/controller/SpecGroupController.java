package com.zjl.legou.item.controller;

import com.zjl.legou.core.controller.BaseController;
import com.zjl.legou.core.po.ResponseBean;
import com.zjl.legou.item.po.SpecGroup;
import com.zjl.legou.item.service.ISpecGroupService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/15 17:48
 */
@RestController
@RequestMapping(value = "/group")
public class SpecGroupController extends BaseController<ISpecGroupService, SpecGroup> {

    @ApiOperation(value = "保存规格参数", notes = "保存规格参数")
    @PostMapping("/save-group")
    public ResponseBean saveGroup(@RequestBody List<SpecGroup> specGroup) throws Exception{
        ResponseBean rm = new ResponseBean();
        try {
            if (specGroup != null && specGroup.size() > 0 ) {
                service.saveGroup(specGroup.get(0).getCid(), specGroup);
            }
        }catch (Exception e) {
            e.printStackTrace();
            rm.setSuccess(false);
            rm.setMsg("保存失败");
        }
        return rm;
    }
}
