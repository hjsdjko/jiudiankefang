package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.FangjianyudingEntity;
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

import com.entity.FangjianEntity;

import com.service.FangjianService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 房间表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-09
*/
@RestController
@Controller
@RequestMapping("/fangjian")
public class FangjianController {
    private static final Logger logger = LoggerFactory.getLogger(FangjianController.class);

    @Autowired
    private FangjianService fangjianService;

    @Autowired
    private FangjianyudingService fangjianyudingService;
    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = fangjianService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        FangjianEntity fangjian = fangjianService.selectById(id);
        if(fangjian!=null){
            return R.ok().put("data", fangjian);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianEntity fangjian, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<FangjianEntity> queryWrapper = new EntityWrapper<FangjianEntity>()
            .eq("name", fangjian.getName())
            .eq("thewhere", fangjian.getThewhere())
            .eq("fjlx_types", fangjian.getFjlxTypes())
            .eq("fjzt_types", fangjian.getFjztTypes())
            .eq("fangjian_content", fangjian.getFangjianContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianEntity fangjianEntity = fangjianService.selectOne(queryWrapper);
        if("".equals(fangjian.getImgPhoto()) || "null".equals(fangjian.getImgPhoto())){
            fangjian.setImgPhoto(null);
        }
        if(fangjianEntity==null){
            fangjian.setFjztTypes(3);
            fangjianService.insert(fangjian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangjianEntity fangjian, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<FangjianEntity> queryWrapper = new EntityWrapper<FangjianEntity>()
            .notIn("id",fangjian.getId())
            .eq("name", fangjian.getName())
            .eq("thewhere", fangjian.getThewhere())
            .eq("fjlx_types", fangjian.getFjlxTypes())
            .eq("fjzt_types", fangjian.getFjztTypes())
            .eq("fangjian_content", fangjian.getFangjianContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianEntity fangjianEntity = fangjianService.selectOne(queryWrapper);
        if("".equals(fangjian.getImgPhoto()) || "null".equals(fangjian.getImgPhoto())){
                fangjian.setImgPhoto(null);
        }
        if(fangjianEntity==null){
            fangjianService.updateById(fangjian);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 预约
    */
    @RequestMapping("/subscribe")
    public R subscribe(Integer ids, HttpServletRequest request){
        if(ids == null){
            return R.error("请选择房屋信息");
        }
        FangjianEntity fangjian = fangjianService.selectById(ids);
        if(fangjian==null){
            return R.error();
        }
        if(fangjian.getFjztTypes() == 1){
            return R.error("这个房间已经被预约过了");
        }
        FangjianyudingEntity fangjianyuding = new FangjianyudingEntity();
        fangjianyuding.setFjTypes(ids);
        fangjianyuding.setCreateTime(new Date());
        fangjianyuding.setSfddTypes(2);
        fangjianyuding.setYhTypes((Integer) request.getSession().getAttribute("userId"));
        fangjian.setFjztTypes(1);
        Wrapper<FangjianyudingEntity> queryWrapper = new EntityWrapper<FangjianyudingEntity>()
                .eq("fj_types", fangjianyuding.getFjTypes())
                .eq("yh_types", fangjianyuding.getYhTypes())
                .eq("sfdd_types", fangjianyuding.getSfddTypes())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianyudingEntity fangjianyudingEntity = fangjianyudingService.selectOne(queryWrapper);
        if(fangjianyudingEntity==null){
            fangjianService.updateById(fangjian);
            fangjianyudingService.insert(fangjianyuding);
            return R.ok();
        }else {
            return R.error(511,"这个房间已经被预定了哦");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        fangjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

