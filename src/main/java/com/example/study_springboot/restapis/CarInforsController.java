package com.example.study_springboot.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.study_springboot.service.CarInforsService;

@RestController
public class CarInforsController {
    @Autowired
    CarInforsService carInforsService;

 //create
    @GetMapping("/selectInUID")
    public ResponseEntity selectInUID(@RequestBody Map paramMap){  //파라미터쏠 때 요청자도 body로 넣고. 받는 사람도 body타입으로 받기 
        
        Object result = null;
        try {
            
            result = carInforsService.selectInUID(paramMap);
        } catch (Exception e) {
         return ResponseEntity.badRequest().body(result);
        }
        
        return ResponseEntity.ok().body(result); //디버깅에 넣어보기 
    }


    ///selectSearch/YEAR/2020
    ///selectSearch/CAR_NAME/소 
    @GetMapping("/selectSearch/{search}/{words}")
    public ResponseEntity selectSearch(@PathVariable String search,@PathVariable String words){
        Object result = carInforsService.selectSearch(search,words );
        return ResponseEntity.ok().body(result); //디버깅에 넣어보기 
    }
    // /selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID){
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result); //디버깅에 넣어보기 
    }
    //create
    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Map paramMap){  //파라미터쏠 때 요청자도 body로 넣고. 받는 사람도 body타입으로 받기 
        Object result = carInforsService.insert(paramMap); //service로 넘겨줄 때. 
        return ResponseEntity.ok().body(result); //디버깅에 넣어보기 
    }
     //update
     @PutMapping("/update")
    public ResponseEntity update(@RequestBody Map paramMap){  //메쏘드이름 (update)파라미터쏠 때 요청자도 body로 넣고. 받는 사람도 body타입으로 받기 
        Object result = carInforsService.update(paramMap); //service로 넘겨줄 때
        return ResponseEntity.ok().body(result); //디버깅에 넣어보기 
    } 
    
    @GetMapping("/selectAll/{CAR_INFOR_ID}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID){
        Object result = carInforsService.selectAll(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result); //디버깅에 넣어보기 
    }
    
    
    //delete
    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID){
        Object result = carInforsService.delete(CAR_INFOR_ID);
        return ResponseEntity.ok().body(result); //디버깅에 넣어보기 
    }

     //2PC create
    @PostMapping("/insertDouble") //URL
    public ResponseEntity insertDouble(@RequestBody Map paramMap){  //파라미터쏠 때 요청자도 body로 넣고. 받는 사람도 body타입으로 받기 
        Object result = null;
       
        try {
            result = carInforsService.insertDouble(paramMap); //service로 넘겨줄 때. 
        } catch (Exception e) {
             return ResponseEntity.badRequest().body(result);
        }
         return ResponseEntity.ok().body(result);
       //디버깅에 넣어보기 
    }
}
