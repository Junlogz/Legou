package com.zjl.legou.admin.controller;

import com.zjl.legou.admin.po.Dept;
import com.zjl.legou.admin.service.IDeptService;
import com.zjl.legou.core.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dept")
public class DeptController extends BaseController<IDeptService, Dept> {

}
