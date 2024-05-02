package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.CaiwuEntity;
import com.entity.FangjianEntity;
import com.entity.FangjianyudingEntity;
import com.service.CaiwuService;
import com.service.FangjianService;
import com.service.FangjianyudingService;
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

import com.entity.ZhusuEntity;

import com.service.ZhusuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 住宿表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-09
*/
@RestController
@Controller
@RequestMapping("/zhusu")
public class ZhusuController {
    private static final Logger logger = LoggerFactory.getLogger(ZhusuController.class);

    @Autowired
    private CaiwuService caiwuService;

    @Autowired
    private ZhusuService zhusuService;

    @Autowired
    private FangjianService fangjianService;

    @Autowired
    private FangjianyudingService fangjianyudingService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = null;
        if(request.getSession().getAttribute("role").equals("管理员")){
            page = zhusuService.queryPage(params);
        }else{
            params.put("yhTypes",request.getSession().getAttribute("userId"));
            page = zhusuService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ZhusuEntity zhusu = zhusuService.selectById(id);
        if(zhusu!=null){
            return R.ok().put("data", zhusu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhusuEntity zhusu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        if(zhusu.getFinishTime().getTime() <= new Date().getTime()){
            return R.error("住宿结束时间不能小于一天");
        }
        FangjianyudingEntity fangjianyuding = fangjianyudingService.selectById(zhusu.getFjTypes());
        if(fangjianyuding == null){
            return R.error();
        }
        FangjianEntity fangjian = fangjianService.selectById(fangjianyuding.getFjTypes());
        if(fangjian == null){
            return R.error();
        }
        zhusu.setYhTypes(fangjianyuding.getYhTypes());
        zhusu.setInitiateTime(new Date());
        zhusu.setZhuangt(1);
        zhusu.setFjTypes(fangjianyuding.getFjTypes());
        Wrapper<ZhusuEntity> queryWrapper = new EntityWrapper<ZhusuEntity>()
            .eq("fj_types", zhusu.getFjTypes())
            .eq("yh_types", zhusu.getYhTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhusuEntity zhusuEntity = zhusuService.selectOne(queryWrapper);

        Long tian =  (((zhusu.getFinishTime().getTime() - zhusu.getInitiateTime().getTime())/(24*60*60*1000)));

        CaiwuEntity caiwu = new CaiwuEntity();
        caiwu.setExpenditureTime(new Date());
        caiwu.setMaxMoney(fangjian.getMoney() * tian);
        caiwu.setYhTypes(fangjianyuding.getYhTypes());
        caiwu.setPurpose("支付 "+fangjian.getName()+" 房间的房费");
        caiwuService.insert(caiwu);

        if(zhusuEntity==null){
            zhusuService.insert(zhusu);
            fangjian.setFjztTypes(2);
            fangjianService.updateById(fangjian);
            fangjianyuding.setSfddTypes(3);
            fangjianyudingService.updateById(fangjianyuding);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhusuEntity zhusu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        if(zhusu.getFinishTime().getTime() <= new Date().getTime()){
            return R.error("住宿结束时间不能小于一天");
        }
        //根据字段查询是否有相同数据
        Wrapper<ZhusuEntity> queryWrapper = new EntityWrapper<ZhusuEntity>()
            .notIn("id",zhusu.getId())
            .eq("fj_types", zhusu.getFjTypes())
            .eq("yh_types", zhusu.getYhTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhusuEntity zhusuEntity = zhusuService.selectOne(queryWrapper);
        zhusu.setInitiateTime(new Date());
        if(zhusuEntity==null){
            zhusuService.updateById(zhusu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/tuifang")
    public R tuifang(Integer ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        ZhusuEntity zhusu = zhusuService.selectById(ids);
        FangjianEntity fangjian = fangjianService.selectById(zhusu.getFjTypes());

        if(fangjian == null){
            return R.error();
        }
        fangjian.setFjztTypes(3);
        zhusu.setZhuangt(2);
        fangjianService.updateById(fangjian);
        zhusuService.updateById(zhusu);
        fangjianyudingService.deleteById(zhusu.getFjTypes());
        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(Integer ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        ZhusuEntity zhusu = zhusuService.selectById(ids);
        FangjianEntity fangjian = fangjianService.selectById(zhusu.getFjTypes());
        if(fangjian == null){
            return R.error();
        }
        if(fangjian.getFjztTypes() != 3){
            fangjian.setFjztTypes(3);
            fangjianService.updateById(fangjian);
        }

        zhusuService.deleteById(ids);
        if(zhusu.getFjTypes() != null){
            fangjianyudingService.deleteById(zhusu.getFjTypes());
        }
        return R.ok();
    }
}

