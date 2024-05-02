package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.FangjianEntity;
import com.service.FangjianService;
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

import com.entity.FangjianyudingEntity;

import com.service.FangjianyudingService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 房间预定表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-09
*/
@RestController
@Controller
@RequestMapping("/fangjianyuding")
public class FangjianyudingController {
    private static final Logger logger = LoggerFactory.getLogger(FangjianyudingController.class);

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
            page = fangjianyudingService.queryPage(params);
        }else{
            params.put("yhTypes",request.getSession().getAttribute("userId"));
            page = fangjianyudingService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        FangjianyudingEntity fangjianyuding = fangjianyudingService.selectById(id);
        if(fangjianyuding!=null){
            return R.ok().put("data", fangjianyuding);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianyudingEntity fangjianyuding, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<FangjianyudingEntity> queryWrapper = new EntityWrapper<FangjianyudingEntity>()
            .eq("fj_types", fangjianyuding.getFjTypes())
            .eq("yh_types", fangjianyuding.getYhTypes())
            .eq("sfdd_types", fangjianyuding.getSfddTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianyudingEntity fangjianyudingEntity = fangjianyudingService.selectOne(queryWrapper);
        if(fangjianyudingEntity==null){
            fangjianyudingService.insert(fangjianyuding);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangjianyudingEntity fangjianyuding, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<FangjianyudingEntity> queryWrapper = new EntityWrapper<FangjianyudingEntity>()
            .notIn("id",fangjianyuding.getId())
            .eq("fj_types", fangjianyuding.getFjTypes())
            .eq("yh_types", fangjianyuding.getYhTypes())
            .eq("sfdd_types", fangjianyuding.getSfddTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianyudingEntity fangjianyudingEntity = fangjianyudingService.selectOne(queryWrapper);
        if(fangjianyudingEntity==null){
            fangjianyudingService.updateById(fangjianyuding);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审批
    */
    @RequestMapping("/audit")
    public R audit(Integer ids){
        FangjianyudingEntity fangjianyuding = fangjianyudingService.selectById(ids);
        if(fangjianyuding == null){
            return R.error();
        }
        fangjianyuding.setSfddTypes(1);
        fangjianyudingService.updateById(fangjianyuding);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        FangjianyudingEntity fangjianyudingEntity = fangjianyudingService.selectById(ids);
        FangjianEntity fangjian = fangjianService.selectById(fangjianyudingEntity.getFjTypes());
        if(fangjian == null){
            return R.error();
        }
        fangjian.setFjztTypes(3);
        fangjianService.updateById(fangjian);
        fangjianyudingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

