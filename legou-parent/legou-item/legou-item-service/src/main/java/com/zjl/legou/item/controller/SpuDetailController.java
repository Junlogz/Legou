package com.zjl.legou.item.controller;

import com.zjl.legou.core.controller.BaseController;
import com.zjl.legou.item.po.SpuDetail;
import com.zjl.legou.item.service.ISpuDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/16 20:31
 */
@RestController
@RequestMapping(value = "/spu-detail")
public class SpuDetailController extends BaseController<ISpuDetailService, SpuDetail> {

}
