package com.zjl.legou.search.po;

import com.zjl.legou.item.po.Brand;
import com.zjl.legou.item.po.Category;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/4/20 19:15
 */
@Data
public class SearchResult {
    private Long total; //总行数
    private Long totalPage; //总页数
    private List items; //当前页数据
    private List<Category> categories;
    private List<Brand> brands;
    private List<Map<String, Object>> specs;

    public SearchResult() {
    }

    public SearchResult(Long total, Long totalPage, List items, List<Category>
            categories, List<Brand> brands, List<Map<String, Object>> specs) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
        this.categories = categories;
        this.brands = brands;
        this.specs = specs;
    }
}
