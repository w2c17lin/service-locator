package wang.clin.service.impl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TemplateHandler {

    /**
     * 模板ID
     */
    String template();

    /**
     * 处理器对应spring容器里面的bean名字
     * 没有就默认按照spring命名规则首字母小写
     */
    String service() default "";
}
