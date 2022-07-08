package com.zjl.legou.item.api;

import com.zjl.legou.item.po.SpuDetail;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/4/6 18:36
 */
@RequestMapping(value = "/spu-detail")
public interface SpuDetailApi {

    /**
     * 加载
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value="加载", notes="根据ID加载")
    @GetMapping("/edit/{id}")
    public SpuDetail edit(@PathVariable Long id);

}
