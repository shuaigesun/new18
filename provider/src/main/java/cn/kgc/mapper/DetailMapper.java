package cn.kgc.mapper;


import cn.kgc.vo.Category;
import cn.kgc.vo.Detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DetailMapper {
    public List<Map<String,Object>> find(@Param("categoryId") Integer categoryId, @Param("title") String title);
    public Detail findById(@Param("id") Integer id);
    public Integer update(Detail detail);
    public List<Category> findCategory();
}
