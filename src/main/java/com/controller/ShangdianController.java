package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.CaiwuEntity;
import com.entity.ZhusuEntity;
import com.service.CaiwuService;
import com.service.ZhusuService;
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

import com.entity.ShangdianEntity;

import com.service.ShangdianService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 酒店商店表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-09
*/
@RestController
@Controller
@RequestMapping("/shangdian")
public class ShangdianController {
    private static final Logger logger = LoggerFactory.getLogger(ShangdianController.class);

    @Autowired
    private ShangdianService shangdianService;

    @Autowired
    private CaiwuService caiwuService;

    @Autowired
    private ZhusuService zhusuService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = shangdianService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ShangdianEntity shangdian = shangdianService.selectById(id);
        if(shangdian!=null){
            return R.ok().put("data", shangdian);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShangdianEntity shangdian, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ShangdianEntity> queryWrapper = new EntityWrapper<ShangdianEntity>()
            .eq("name", shangdian.getName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangdianEntity shangdianEntity = shangdianService.selectOne(queryWrapper);
        if("".equals(shangdian.getImgPhoto()) || "null".equals(shangdian.getImgPhoto())){
            shangdian.setImgPhoto(null);
        }
        if(shangdianEntity==null){
            shangdianService.insert(shangdian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShangdianEntity shangdian, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ShangdianEntity> queryWrapper = new EntityWrapper<ShangdianEntity>()
            .notIn("id",shangdian.getId())
            .eq("name", shangdian.getName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangdianEntity shangdianEntity = shangdianService.selectOne(queryWrapper);
        if("".equals(shangdian.getImgPhoto()) || "null".equals(shangdian.getImgPhoto())){
                shangdian.setImgPhoto(null);
        }
        if(shangdianEntity==null){
            shangdianService.updateById(shangdian);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 购买
    */
    @RequestMapping("/receive")
    public R receive(Integer num , Integer id, HttpServletRequest request){
        if(num <= 0){
            return R.error("购买的商品数量不能小于1");
        }
        if(zhusuService.selectOne(new EntityWrapper().eq("yh_types",(Integer) request.getSession().getAttribute("userId"))) == null){
            return R.error("只有入住后才可以购买商品哦");
        }
        ShangdianEntity shangdian = shangdianService.selectById(id);
        CaiwuEntity caiwu = new CaiwuEntity();
        caiwu.setPurpose("购买："+shangdian.getName()+" ，"+num+" 件");
        caiwu.setMaxMoney(shangdian.getMoney()* num);
        caiwu.setExpenditureTime(new Date());
        caiwu.setYhTypes((Integer) request.getSession().getAttribute("userId"));
        caiwuService.insert(caiwu);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        shangdianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

