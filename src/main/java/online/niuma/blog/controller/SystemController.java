package online.niuma.blog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Slf4j
@Controller
public class SystemController {

    @GetMapping({"/", "index"})
    public String index() {
        log.info("request utl: / or /index");
        return "page/index";
    }
}
