package wang.clin.service;

import wang.clin.pojo.TemplateRequestBO;
import wang.clin.pojo.TemplateResponseBO;

/**
 * @author wcLin
 * @since 2020/3/4 上午 09:10
 **/
public interface TemplateService {

    /**
     * 开始执行处理请求
     *
     * @param request 请求对象
     * @return 处理完成的对象
     */
    TemplateResponseBO hand(TemplateRequestBO request);

}
