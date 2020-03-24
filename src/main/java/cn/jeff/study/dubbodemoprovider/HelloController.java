package cn.jeff.study.dubbodemoprovider;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author swzhang
 * @date 2020/03/24
 */
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public ResponseEntity<String> read(@RequestParam(name = "word") Integer word) {
        return ResponseEntity.ok(helloService.getOneWord(word));
    }
}
