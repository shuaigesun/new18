package cn.kgc.service;


import cn.kgc.vo.Category;
import cn.kgc.vo.Detail;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface DetailService {
    public PageInfo<Map<String,Object>> find(Integer categoryId, String title, Integer pageNo);
    public Detail findById(Integer id);
    public Integer update(Detail detail);
    public List<Category> findCategory();
}
