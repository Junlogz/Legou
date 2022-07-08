package com.zjl.legou.search;

import com.zjl.legou.item.po.Spu;
import com.zjl.legou.search.client.SpuClient;
import com.zjl.legou.search.dao.GoodsDao;
import com.zjl.legou.search.po.Goods;
import com.zjl.legou.search.service.IndexService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;


/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/4/19 19:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class ESLoadDataTest {
    @Autowired
    private IndexService indexService;
    @Autowired
    private SpuClient spuClient;
    @Autowired
    private GoodsDao goodsDao;
    @Test
    public void loadData() {
        List<Spu> spus = spuClient.selectAll();
        // spu转为goods
        List<Goods> goods = spus.stream().map(spu ->
                        this.indexService.buildGoods(spu))
                        .collect(Collectors.toList());
            // 把goods放入索引库
        goodsDao.saveAll(goods);
    }
}