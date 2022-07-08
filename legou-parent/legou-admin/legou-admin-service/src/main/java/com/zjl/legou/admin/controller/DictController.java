package com.zjl.legou.admin.controller;

import com.zjl.legou.admin.po.Dict;
import com.zjl.legou.admin.service.IDictService;
import com.zjl.legou.core.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dict")
public class DictController extends BaseController<IDictService, Dict> {


}
