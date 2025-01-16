package rastreador.spring.project_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-word")
public class HelloWordController {

    @GetMapping
    public String helloWord(){
    return "hello word";
    }


}
