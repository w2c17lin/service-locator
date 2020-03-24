package wang.clin.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * 模板图片处理响应
 *
 * @author wcLin
 * @since 2020/3/4 上午 09:20
 **/
@Data
@Builder
public class TemplateResponseBO {

    /**
     * 处理后上传到oss的图片地址
     */
    private String url;

}
