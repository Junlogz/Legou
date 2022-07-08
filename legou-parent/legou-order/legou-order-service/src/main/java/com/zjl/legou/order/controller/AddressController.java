package com.zjl.legou.order.controller;

import com.zjl.legou.order.config.TokenDecode;
import com.legou.order.po.Address;
import com.zjl.legou.order.service.IAddressService;
import com.zjl.legou.core.controller.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/21 14:20
 */
@RestController
@RequestMapping(value = "/address")
public class AddressController extends BaseController<IAddressService, Address> {

    @Autowired
    private TokenDecode tokenDecode;

    @ApiOperation(value="查询", notes="根据实体条件查询")
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    @Override
    public List<Address> list(Address entity) {
        Map<String, String> user = null;
        try {
            user = tokenDecode.getUserInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String username = user.get("user_name");
        entity.setUsername(username);
        return service.list(entity);
    }

}