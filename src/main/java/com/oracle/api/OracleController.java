package com.oracle.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oracle")
public class OracleController {


    @GetMapping
    @RequestMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello from Oracle Controller!");
    }
}
