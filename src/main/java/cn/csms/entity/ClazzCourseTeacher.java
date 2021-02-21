package cn.csms.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 班级-课程-教师
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ClazzCourseTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键值
     */
    private Integer id;

    /**
     * 班级ID
     */
    private Integer clazzid;

    /**
     * 课程ID
     */
    private Integer courseid;

    /**
     * 教师ID
     */
    private Integer teacherid;


}
