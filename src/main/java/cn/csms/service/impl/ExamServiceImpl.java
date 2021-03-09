package cn.csms.service.impl;

import cn.csms.entity.Exam;
import cn.csms.mapper.ExamMapper;
import cn.csms.service.ExamService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考试表 服务实现类
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    @Autowired
    ExamMapper examMapper;

    @Override
    public IPage<Exam> SelectExams(Page<Exam> page, String examName, String gradeId, String clazzId) {
        if ("0".equals(gradeId) && "0".equals(clazzId)){
            return examMapper.SelectExams01(page, examName);
        } else if (!"0".equals(gradeId) && "0".equals(clazzId)){
            return examMapper.SelectExams02(page, examName, Integer.parseInt(gradeId));
        } else {
            return examMapper.SelectExams03(page, examName, Integer.parseInt(gradeId), Integer.parseInt(clazzId));
        }
    }
}
