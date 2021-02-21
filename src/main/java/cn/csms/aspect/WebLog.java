package cn.csms.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//运行时使用
@Retention(RUNTIME)
//注解用于方法
@Target({ METHOD })
//注解包含在JavaDoc中
@Documented
public @interface WebLog {

    String value() default "";

}
