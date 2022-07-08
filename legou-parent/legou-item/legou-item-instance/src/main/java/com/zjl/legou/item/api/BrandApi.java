package com.zjl.legou.item.api;

import com.zjl.legou.item.po.Brand;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/27 20:16
 */
@RequestMapping("/brand")
public interface BrandApi {

    @ApiOperation(value="根据ids查询", notes = "根据ids查询")
    @GetMapping("/list-by-ids")
    public List<Brand> selectBrandByIds(@RequestParam("ids") List<Long> ids);

}
