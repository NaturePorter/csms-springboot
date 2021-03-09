package cn.csms.mapper;

import cn.csms.entity.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 考试表 Mapper 接口
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Mapper
public interface ExamMapper extends BaseMapper<Exam> {
    @Select({"<script>",
            "select e.id,e.name,e.type,g.name as gradeid,c.name as clazzid,e.time,e.remark from exam e",
            "left join grade g on e.gradeid = g.id",
            "left join clazz c on g.id = c.gradeid and e.clazzid = c.id",
            "where 1 = 1",
            "<if test='examName != null'>",
            "and e.name like concat ('%','${examName}','%') ",
            "</if>",
            "</script>"})
    IPage<Exam> SelectExams01(Page<Exam> page, String examName);

    @Select({"<script>",
            "select e.id,e.name,e.type,g.name as gradeid,c.name as clazzid,e.time,e.remark from exam e",
            "left join grade g on e.gradeid = g.id",
            "left join clazz c on g.id = c.gradeid and e.clazzid = c.id",
            "where e.gradeid = ${gradeId}",
            "<if test='examName != null'>",
            "and e.name like concat ('%','${examName}','%') ",
            "</if>",
            "</script>"})
    IPage<Exam> SelectExams02(Page<Exam> page, String examName, Integer gradeId);

    @Select({"<script>",
            "select e.id,e.name,e.type,g.name as gradeid,c.name as clazzid,e.time,e.remark from exam e",
            "left join grade g on e.gradeid = g.id",
            "left join clazz c on g.id = c.gradeid and e.clazzid = c.id",
            "where e.gradeid = ${gradeId} and e.clazzid = ${clazzId}",
            "<if test='examName != null'>",
            "and e.name like concat ('%','${examName}','%') ",
            "</if>",
            "</script>"})
    IPage<Exam> SelectExams03(Page<Exam> page, String examName, Integer gradeId, Integer clazzId);

}
