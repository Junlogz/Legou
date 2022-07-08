package com.zjl.legou.search.client;

import com.zjl.legou.item.api.CategoryApi;
import com.zjl.legou.item.po.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/30 9:49
 */

@FeignClient(name = "item-service", fallback = CategoryClient.CategoryClientFallback.class)
public interface CategoryClient extends CategoryApi {
    @Component
    @RequestMapping("/item/category-fallback") //这个可以避免容器中requestMapping重复
    class CategoryClientFallback implements CategoryClient {

        private static final Logger LOGGER = LoggerFactory.getLogger(CategoryClientFallback.class);

        @Override
        public List<String> queryNameByIds(List<Long> ids) {
            LOGGER.info("异常发生，进入fallback方法");
            return null;
        }
        @Override
        public List<Category> list(Category category) {
            LOGGER.info("异常发生，进入fallback方法");
            return null;
        }
        @Override
        public Category edit(Long id) {
            LOGGER.info("异常发生，进入fallback方法");
            return null;
        }

    }
}

