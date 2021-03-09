package cn.csms.entity;

import java.time.LocalDate;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 考试表
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键值
     */
    private Integer id;

    /**
     * 考试名次
     */
    private String name;

    /**
     * 考试时间
     */
    private LocalDate time;

    /**
     * 备注
     */
    private String remark;

    /**
     * 考试类型,默认1(1为年级统考，2为平时考试)
     */
    private Integer type;

    /**
     * 年级ID
     */
    private String gradeid;

    /**
     * 班级ID
     */
    private String clazzid;


}
