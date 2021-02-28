package cn.csms.controller;


import cn.csms.base.ResultBean;
import cn.csms.base.ResultConst;
import cn.csms.entity.Clazz;
import cn.csms.entity.Grade;
import cn.csms.service.ClazzService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 班级 前端控制器
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/csms_api")
public class ClazzController {

    @Autowired
    ClazzService clazzService;

    @GetMapping("clazzs")
    public ResponseEntity getGrade(int id){
        LambdaQueryWrapper<Clazz> queryWrapper = Wrappers.<Clazz>lambdaQuery().eq(Clazz::getGradeid, id);
        List<Clazz> clazzs = clazzService.list(queryWrapper);
        return new ResponseEntity<>(ResultBean.ok(ResultConst.GET_GRADES_SUCC, clazzs), HttpStatus.OK);
    }

}
