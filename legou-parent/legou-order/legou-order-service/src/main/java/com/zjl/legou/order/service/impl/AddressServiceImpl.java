package com.zjl.legou.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.legou.order.po.Address;
import com.zjl.legou.order.service.IAddressService;
import com.zjl.legou.core.service.impl.CrudServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/5/21 14:19
 */
@Service
public class AddressServiceImpl extends CrudServiceImpl<Address> implements IAddressService {

    @Override
    public List<Address> list(Address entity) {
        //根据⽤户名查询⽤户收货地址
        QueryWrapper<Address> queryWrapper = Wrappers.<Address>query();
        if (StringUtils.isNotEmpty(entity.getUsername())) {
            queryWrapper.eq("username_", entity.getUsername());
        }
        return getBaseMapper().selectList(queryWrapper);
    }

}
