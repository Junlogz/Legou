package com.zjl.legou.canal.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xpand.starter.canal.annotation.*;
import com.zjl.legou.canal.client.CategoryClient;
import com.zjl.legou.item.po.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/3/24 15:20
 */
@CanalEventListener
public class MyEventListener {

    @Autowired
    private CategoryClient categoryClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * @ListenPoint 自定义监听
     *getAfterColumnsList():之前数据，用于增加、修改
     *getBeforeColumnsList():之后数据 ，用于删除、修改
     *@param eventType 当前操作的类型
     * @param rowData 发生变更的一行数据
     */
    @ListenPoint(
            eventType = {CanalEntry.EventType.INSERT, CanalEntry.EventType.UPDATE, CanalEntry.EventType.DELETE}, //自定义监听类型
            schema = {"legou"},//指定监听的数据库
            table = {"category_"},//指定监控的数据库表 ，不指定则监控数据库中的所有表
            destination = "example"//指定实例地址
    )
    public void onEventCustom(CanalEntry.EventType eventType, CanalEntry.RowData rowData) throws JsonProcessingException {
        //数据库中最新的商品分类
        List<Category> list = categoryClient.list(new Category());
        ObjectMapper objectMapper = new ObjectMapper();
        stringRedisTemplate.boundValueOps("c1").set(objectMapper.writeValueAsString(list));

    }


//    /**
//     * @InsertListenPoint增加数据监听 只有增加后的数据
//     *getAfterColumnsList():之前数据，用于增加、修改
//     *getBeforeColumnsList():之后数据 ，用于删除、修改
//     *@param eventType 当前操作的类型
//     * @param rowData 发生变更的一行数据
//     */
//    @InsertListenPoint
//    public void onEventInsert(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
//        System.out.println("添加的数据监听");
//        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
//        for (CanalEntry.Column column : afterColumnsList) {
//            System.out.println("列名称："+column.getName()+"------------------增加的数据："+column.getValue());
//        }
//
//    }
//
//    /**
//     * @UpdateListenPoint 修改数据监听 有修改前后数据
//     *getAfterColumnsList():之前数据，用于增加、修改
//     *getBeforeColumnsList():之后数据 ，用于删除、修改
//     *@param eventType 当前操作的类型
//     * @param rowData 发生变更的一行数据
//     */
//    @UpdateListenPoint
//    public void onEventUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
//        List<CanalEntry.Column> afterColumnsList = rowData.getAfterColumnsList();
//        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
//        for (CanalEntry.Column column : beforeColumnsList) {
//            System.out.println("列名称："+column.getName()+"------------------修改前的数据："+column.getValue());
//        }
//        for (CanalEntry.Column column : afterColumnsList) {
//            System.out.println("列名称："+column.getName()+"------------------修改后的数据："+column.getValue());
//        }
//    }
//
//    /**
//     * @InsertListenPoint删除数据监听 只有删除前的数据
//     *getAfterColumnsList():之前数据，用于增加、修改
//     *getBeforeColumnsList():之后数据 ，用于删除、修改
//     *@param eventType 当前操作的类型
//     * @param rowData 发生变更的一行数据
//     */
//    @DeleteListenPoint
//    public void onEventDelete(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
//        List<CanalEntry.Column> afterColumnsList = rowData.getBeforeColumnsList();
//        for (CanalEntry.Column column : afterColumnsList) {
//            System.out.println("列名称："+column.getName()+"------------------删除前的数据："+column.getValue());
//        }
//
//    }

}
