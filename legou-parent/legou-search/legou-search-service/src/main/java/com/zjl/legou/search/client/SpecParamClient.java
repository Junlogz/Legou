package com.zjl.legou.search.client;

import com.zjl.legou.item.api.SpecParamApi;
import com.zjl.legou.item.po.SpecParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/4/6 19:08
 */
@FeignClient(name = "item-service", fallback = SpecParamClient.SpecParamClientFallback.class)
public interface SpecParamClient extends SpecParamApi {

    @Component
    @RequestMapping("/param-fallback") //这个可以避免容器中requestMapping重复
    class SpecParamClientFallback implements SpecParamClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(SpecParamClientFallback.class);
        @Override
        public List<SpecParam> selectSpecParamApi(SpecParam entity) {
            LOGGER.error("异常发生，进入fallback方法");
            return null;
        }
    }

}

