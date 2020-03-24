package wang.clin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wang.clin.service.TemplateOssService;

import java.awt.*;

/**
 * @author wcLin
 * @since 2020/3/4 上午 09:15
 **/
@Slf4j
@Service
public class TemplateOssServiceImpl implements TemplateOssService {

    @Override
    public String upload(Image image) {
        log.warn("上传图片 url: http://www.baidu.com");
        return "http://www.baidu.com";
    }

    @Override
    public Image download(String url) {
        log.warn("下载图片 url: {}", url);
        return null;
    }

}
