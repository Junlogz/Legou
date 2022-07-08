package com.zjl.legou.search.client;

import com.zjl.legou.item.api.BrandApi;
import com.zjl.legou.item.po.Brand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/27 20:19
 */
@FeignClient(name = "item-service", fallback = BrandClient.BrandClientFallback.class)
public interface BrandClient extends BrandApi {

    @Component
    @RequestMapping("/brand-fallback") //这个可以避免容器中requestMapping重复
    class BrandClientFallback implements BrandClient {

        private static final Logger LOGGER = LoggerFactory.getLogger(BrandClientFallback.class);
        @Override
        public List<Brand> selectBrandByIds(List<Long> ids) {
            LOGGER.info("异常发生，进入fallback方法");
            return null;
        }

    }

}
