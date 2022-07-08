package com.zjl.legou.search;

import com.zjl.legou.search.po.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/4/6 19:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class ElasticSearchTest {

//    @Autowired
//    private ElasticsearchRestTemplate esTemplate;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void createIndex() {
        //创建索引
        this.elasticsearchTemplate.createIndex(Goods.class);
        //配置映射
        this.elasticsearchTemplate.putMapping(Goods.class);
//        IndexOperations indexOperations = esTemplate.indexOps(Goods.class);
//        Document document = indexOperations.createMapping();
    }

}