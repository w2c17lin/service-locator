package wang.clin.service.impl.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import wang.clin.service.TemplateOssService;
import wang.clin.service.impl.AbstractTemplateHandlerService;
import wang.clin.service.impl.TemplateHandler;

import java.awt.*;

/**
 * 处理图片数据 第一个handler
 *
 * @author wcLin
 * @since 2020/3/6 上午 10:44
 **/
@Slf4j
@Service
@TemplateHandler(template = "0002")
public class Template0002Handler extends AbstractTemplateHandlerService {

    public Template0002Handler(TemplateOssService templateOssService) {
        super(templateOssService);
    }

    @Override
    protected Image hand(Image image, Object data) {
        log.warn("处理图片 template: {} data: {}",
                "0002", JSON.toJSONString(data));
        return null;
    }

}
