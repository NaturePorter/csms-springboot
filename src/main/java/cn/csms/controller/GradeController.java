package cn.csms.controller;


import cn.csms.base.ResultBean;
import cn.csms.base.ResultConst;
import cn.csms.entity.Grade;
import cn.csms.service.GradeService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 年级 前端控制器
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/csms_api")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @GetMapping("grades")
    public ResponseEntity getGrade(){
        List<Grade> grades = gradeService.list();
        return new ResponseEntity<>(ResultBean.ok(ResultConst.GET_GRADES_SUCC, grades), HttpStatus.OK);
    }
}
