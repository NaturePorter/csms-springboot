package cn.csms.service.impl;

import cn.csms.entity.Course;
import cn.csms.mapper.CourseMapper;
import cn.csms.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author Promote
 * @since 2021-02-21
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
