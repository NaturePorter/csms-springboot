package cn.csms.controller;


import cn.csms.aspect.WebLog;
import cn.csms.base.ResultBean;
import cn.csms.base.ResultConst;
import cn.csms.entity.Exam;
import cn.csms.entity.User;
import cn.csms.service.ExamService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 考试表 前端控制器
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@RestController
@RequestMapping("/csms_api")
public class ExamController {
    @Autowired
    ExamService examService;

    @GetMapping("/exams")
    @WebLog("获取考试列表")
    public ResponseEntity getExams(@RequestParam(name = "query", required = false) String examName,
                                   @RequestParam(name = "gradeId", required = false, defaultValue = "0") String gradeId,
                                   @RequestParam(name = "clazzId", required = false ,defaultValue = "0") String clazzId,
                                   @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        IPage<Exam> page = examService.SelectExams(new Page<>(pageNum, pageSize), examName, gradeId, clazzId);
        JSONObject resp = new JSONObject().fluentPut("total", page.getTotal());
        resp.put("exams", page.getRecords());
        return new ResponseEntity<>(ResultBean.ok(ResultConst.GET_EXAMS_SUUC, resp), HttpStatus.OK);
    }

}
