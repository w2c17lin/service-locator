package wang.clin.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * 模板图片处理请求
 *
 * @author wcLin
 * @since 2020/3/4 上午 09:20
 **/
@Data
@Builder
public class TemplateRequestBO {

    /**
     * 模板编号
     */
    private String template;

    /**
     * 模板图片地址
     */
    private String templateUrl;

    /**
     * 模板数据
     */
    private Object data;

}
