package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/{id}/say",method = RequestMethod.GET)
    public String say(@PathVariable("id")Integer id){
     return "id:"+ id;
        //   return girlProperties.getCupSize();
    }

    @RequestMapping(value = "/say1",method = RequestMethod.GET)
    public String say1(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
        return "id:"+ myId;
        //   return girlProperties.getCupSize();
    }
}
