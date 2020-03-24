package wang.clin.service;

import java.awt.*;

/**
 * 模板图片上传服务
 *
 * @author wcLin
 * @since 2020/3/4 上午 09:14
 **/
public interface TemplateOssService {

    /**
     * 从对象存储上传图片地址
     *
     * @param image 图片数据
     */
    String upload(Image image);

    /**
     * 从对象存储下载图片
     *
     * @param url 图片地址
     */
    Image download(String url);

}
