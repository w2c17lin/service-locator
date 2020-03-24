package wang.clin.service.impl;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import wang.clin.pojo.TemplateRequestBO;
import wang.clin.pojo.TemplateResponseBO;
import wang.clin.service.TemplateHandlerService;
import wang.clin.service.TemplateService;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wcLin
 * @since 2020/3/4 上午 09:10
 **/
@Slf4j
@Service
public class TemplateServiceImpl implements TemplateService {

    /**
     * 处理器的包名位置
     */
    private static final String HANDLER_PACKAGE = "wang.clin.service.impl.handler";
    /**
     * 处理器容器
     */
    private Map<String, String> handlers;
    /**
     * spring app 上下文
     */
    private ApplicationContext applicationContext;


    public TemplateServiceImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.handlers = new ConcurrentHashMap<>();
        this.register();
    }

    @Override
    public TemplateResponseBO hand(TemplateRequestBO request) {
        return getHandler(request.getTemplate()).hand(request);
    }

    /**
     * 从spring容器获取对应模板处理器
     *
     * @param template 模板编码
     */
    private TemplateHandlerService getHandler(String template) {
        return Optional.ofNullable(handlers.get(template)).filter(StrUtil::isNotBlank)
                .map(v -> (TemplateHandlerService) applicationContext.getBean(v))
                .orElseThrow(() -> new NoSuchBeanDefinitionException(template));
    }

    /**
     * 注册指定包下面的所有处理器
     */
    private void register() {
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(
                HANDLER_PACKAGE, TemplateHandler.class);
        for (Class<?> clazz : classes) {
            TemplateHandler annotation = clazz.getAnnotation(TemplateHandler.class);
            String service = annotation.service(); // 获取自定义spring bean名字
            /* 没有自定义bean名字的使用spring bean命名规则生成名字 */
            String serviceName = StrUtil.isNotBlank(service) ? service
                    : StrUtil.lowerFirst(clazz.getSimpleName());
            handlers.put(annotation.template(), serviceName);
        }
    }


}
