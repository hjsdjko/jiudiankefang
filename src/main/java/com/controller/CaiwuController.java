package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.CaiwuEntity;

import com.service.CaiwuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 财务表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-09
*/
@RestController
@Controller
@RequestMapping("/caiwu")
public class CaiwuController {
    private static final Logger logger = LoggerFactory.getLogger(CaiwuController.class);

    @Autowired
    private CaiwuService caiwuService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = null;
        if(request.getSession().getAttribute("role").equals("管理员")){
            page = caiwuService.queryPage(params);
        }else{
            params.put("yhTypes",request.getSession().getAttribute("userId"));
            page = caiwuService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        CaiwuEntity caiwu = caiwuService.selectById(id);
        if(caiwu!=null){
            return R.ok().put("data", caiwu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody CaiwuEntity caiwu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<CaiwuEntity> queryWrapper = new EntityWrapper<CaiwuEntity>()
            .eq("yh_types", caiwu.getYhTypes())
            .eq("purpose", caiwu.getPurpose())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaiwuEntity caiwuEntity = caiwuService.selectOne(queryWrapper);
            caiwu.setExpenditureTime(new Date());
        if(caiwuEntity==null){
            caiwuService.insert(caiwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody CaiwuEntity caiwu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<CaiwuEntity> queryWrapper = new EntityWrapper<CaiwuEntity>()
            .notIn("id",caiwu.getId())
            .eq("yh_types", caiwu.getYhTypes())
            .eq("purpose", caiwu.getPurpose())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        CaiwuEntity caiwuEntity = caiwuService.selectOne(queryWrapper);
                caiwu.setExpenditureTime(new Date());
        if(caiwuEntity==null){
            caiwuService.updateById(caiwu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        caiwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

