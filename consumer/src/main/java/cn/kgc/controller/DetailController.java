package cn.kgc.controller;

import cn.kgc.service.DetailService;
import cn.kgc.vo.Category;
import cn.kgc.vo.Detail;
import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class DetailController {
    @Resource
    private DetailService detailService;
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    @RequestMapping("/findCategory.do")
    public List<Category> findCategory(){
        return detailService.findCategory();
    }
    @RequestMapping("/find.do")
    public PageInfo<Map<String,Object>> find(Integer categoryId, String title, Integer pageNo){
        return detailService.find(categoryId,title,pageNo);
    }
    @RequestMapping("/findId.do")
    public HashMap<Object,Object> findId(Integer id){
        Detail detail=detailService.findById(id);
        List<Category> category=detailService.findCategory();
        HashMap<Object,Object>map=new HashMap<Object, Object>();
        map.put("detail",detail);
        map.put("category",category);
        return map;
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(Detail detail){
        detail.setUpdateDate(new Date());
        Integer flag=detailService.update(detail);
        if(flag>0){


            return "{\"ok\":\"ok\"}";
        }else {
            return "2";
        }
    }
}
