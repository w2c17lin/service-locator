package wang.clin;

import com.alibaba.fastjson.JSON;
import wang.clin.pojo.TemplateRequestBO;
import wang.clin.pojo.TemplateResponseBO;
import wang.clin.service.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

    private TemplateService templateService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public Application(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Override
    public void run(String... args) {
        TemplateRequestBO request = TemplateRequestBO.builder().template("0002")
                .templateUrl("http://www.google.com").data("test data").build();
        TemplateResponseBO response = templateService.hand(request);
        log.warn("处理结果 response: {}", JSON.toJSONString(response));
    }
}
