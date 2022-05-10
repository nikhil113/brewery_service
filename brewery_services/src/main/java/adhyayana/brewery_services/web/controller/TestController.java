package adhyayana.brewery_services.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/welcome")
public class TestController {

    @GetMapping
    public ResponseEntity<String> welcome(){
        System.out.println("coming inside test controller");
        return ResponseEntity.ok().body("Welcome !!!!");
    }

}
