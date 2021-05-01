package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/example")
@Slf4j
public class ExampleRestController {

    @RequestMapping(value = "/test/get/{paramOne}", method = RequestMethod.GET)
    public ResponseEntity<String> exampleGetRequest(@PathVariable String paramOne,
                                                    @RequestParam(required = false) Long paramTwo,
                                                    @RequestParam() String paramThree) {
//        http://localhost:8085/example/test/get/mess1?paramTwo=273&paramThree=mess3
        log.info("start handle request \"exampleGetRequest\" with " +
                "params: paramOne = " + paramOne + ", paramTwo = " + paramTwo + ", paramThree = " + paramThree);
        return ResponseEntity.status(200).body("Все Отлично Гет запрос обработан");
    }

    @RequestMapping(value = "/test/get/{paramOne}", method = RequestMethod.POST)
    public ResponseEntity<String> examplePostRequest(@PathVariable String paramOne,
                                                    @RequestParam(required = false) Long paramTwo,
                                                    @RequestParam() String paramThree,
                                                    @RequestParam() String paramFour) {
//        http://localhost:8085/example/test/get/mess1?paramTwo=273&paramThree=mess3
        log.info("start handle request \"examplePostRequest\" with " +
                "params: paramOne = " + paramOne + ", paramTwo = " + paramTwo + ", paramThree = " + paramThree +
                ", paramFour = " + paramFour);
        return ResponseEntity.badRequest().body("Все Отлично Пост запрос обработан");
    }


}
