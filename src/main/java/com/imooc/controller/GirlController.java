package com.imooc.controller;


import com.imooc.aspect.HttpAspect;
import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
@Autowired
private GirlRepository girlRepository;
@Autowired
private GirlService girlService;

/*
*查询所有女生列表
 */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
    }
/*
添加女生
 */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
       return girlRepository.save(girl);
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id")Integer id){
    return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id")Integer id,@RequestParam("cupSize") String cupSize,
                           @RequestParam("age")Integer age
    ){
    Girl girl =new Girl();
    girl.setId(id);
    girl.setCupSize(cupSize);
    girl.setAge(age);
   return girlRepository.save(girl);
    }
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id")Integer id){
    girlRepository.delete(id);
    }
    @PostMapping(value = "/girls/age")
    public List<Girl> girlListByAge(@RequestParam("age")Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

}
