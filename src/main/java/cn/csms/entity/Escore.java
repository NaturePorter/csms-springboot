package cn.csms.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 考试成绩表
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Escore implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键值
     */
    private Integer id;

    /**
     * 考试ID
     */
    private Integer examid;

    /**
     * 学生ID
     */
    private Integer studentid;

    /**
     * 班级ID
     */
    private Integer clazzid;

    /**
     * 课程ID
     */
    private Integer courseid;

    /**
     * 成绩
     */
    private Integer score;


}
