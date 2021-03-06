package cn.csms.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 年级-课程
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class GradeCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键值
     */
    private Integer id;

    /**
     * 年级ID
     */
    private Integer gradeid;

    /**
     * 课程ID
     */
    private Integer courseid;


}
