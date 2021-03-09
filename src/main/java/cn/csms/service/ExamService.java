package cn.csms.service;

import cn.csms.entity.Exam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 考试表 服务类
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
public interface ExamService extends IService<Exam> {

    /**
     * 查询考试列表
     * @param page 分页对象
     * @param examName 考试名次
     * @param gradeId 年级id
     * @param clazzId 班级id
     * @return 返回考试列表
     */
    IPage<Exam> SelectExams(Page<Exam> page, String examName, String gradeId, String clazzId);
}
