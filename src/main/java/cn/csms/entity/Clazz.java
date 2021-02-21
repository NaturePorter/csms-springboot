package cn.csms.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 班级
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Clazz implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键值
     */
    private Integer id;

    /**
     * 班级名称
     */
    private String name;

    /**
     * 年级ID
     */
    private Integer gradeid;


}
