package cn.xw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AnHui OuYang
 * @version 1.0
 */

@RestController
@RequestMapping("/system")
public class SystemController {

    @GetMapping("/hello/{name}")
    public String getHello(@PathVariable(value = "name") String name) {
        return "您好：" + name;
    }

}
