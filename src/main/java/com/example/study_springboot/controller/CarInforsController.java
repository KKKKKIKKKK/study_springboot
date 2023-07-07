package com.example.study_springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.study_springboot.service.CarInforsService;

// 데이터만 리턴하는 형식일땐 controller 사용
@Controller
@RequestMapping("/carInfor")
public class CarInforsController {
    @Autowired
    CarInforsService carInforsService;

    @GetMapping("/selectInUID")
    public ResponseEntity selectInUID(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carInforsService.selectInUID(paramMap);
        } catch (Exception e) {
            return ResponseEntity.ok().body(result);       
        }
        return ResponseEntity.ok().body(result);   
    }


    // /selectSearch?search=YEAR&words=2020
    // /selectSearch/CAR_NAME/소
    @GetMapping("/selectSearch")
    public ModelAndView selectSearch(@RequestParam Map params
                                    , ModelAndView modelAndView) {
        Object result = carInforsService.selectSearch(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);
        modelAndView.setViewName("/WEB-INF/views/carinfors/list.jsp");
        return modelAndView;
    }

    @GetMapping("/selectAll/{CAR_INFOR_ID}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectAll(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // /selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // create
    @PostMapping("/insert") // 원래는 url 부분에 단어를 넣어주지 않는다.
    public ResponseEntity insert(@RequestBody Map paramMap) {
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // update
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Map paramMap) {
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // delete
    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.delete(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result);
    }

    // 2PC create
    @PostMapping("/insertDouble") // 원래는 url 부분에 단어를 넣어주지 않는다.
    public ResponseEntity insertDouble(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = carInforsService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }
}