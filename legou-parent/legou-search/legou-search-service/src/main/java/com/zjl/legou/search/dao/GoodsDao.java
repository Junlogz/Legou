package com.zjl.legou.search.dao;

import com.zjl.legou.search.po.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/4/6 19:16
 */
public interface GoodsDao extends ElasticsearchRepository<Goods, Long> {
}
