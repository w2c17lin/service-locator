package wang.clin.service.impl;

import wang.clin.pojo.TemplateRequestBO;
import wang.clin.pojo.TemplateResponseBO;
import wang.clin.service.TemplateHandlerService;
import wang.clin.service.TemplateOssService;

import java.awt.*;

/**
 * @author wcLin
 * @since 2020/3/4 上午 09:19
 **/
public abstract class AbstractTemplateHandlerService implements TemplateHandlerService {

    private TemplateOssService templateOssService;

    protected AbstractTemplateHandlerService(TemplateOssService templateOssService) {
        this.templateOssService = templateOssService;
    }

    @Override
    public TemplateResponseBO hand(TemplateRequestBO request) {
        /* 下载模板图片 */
        Image image = templateOssService.download(request.getTemplateUrl());
        /* 调用实现类处理画图动作 */
        Image result = hand(image, request.getData());
        /* 将结果上传到对象存储 */
        String url = templateOssService.upload(result);
        /* 返回处理结果图片地址 */
        return TemplateResponseBO.builder().url(url).build();
    }

    /**
     * 具体实现类来实现画图动作
     *
     * @param image 模板图片
     * @param data  模板数据
     */
    protected abstract Image hand(Image image, Object data);

}
