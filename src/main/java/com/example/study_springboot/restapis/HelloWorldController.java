package com.example.study_springboot.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboot.service.HelloWorldService;

//2023-06-30(Springboot 첫번째 수업)
@Controller
public class HelloWorldController {
    
    @Autowired //service 자동화 
     HelloWorldService helloWorldService = new HelloWorldService() ;
    @GetMapping("/helloWorld")
    public int helloWorld() {
        return 0;
    }

    // helloWorldGetRequest?Name=yojulab (request로 보낼때 변수의 값) 해킹 시 문제
    // helloWorldGetRequest/yojulab/U-01 (url위치값으로 판단 후 'name'으로 여김)
    @GetMapping("/helloWorldGetRequest/{name}/{Id}")
    public int helloWorldGetRequest(@PathVariable String name, @PathVariable String Id) {
        return 0;
    }

    // ?serviceKey=nG3dMLSg8pN%2Badkz4rs%2F4XaJF6ZtjpRZgbH%2BPh6hWd2DJBGmH62jFSpNgv30uUmgqYlqVtdoDlbiBH1F3S2Pfw%3D%3D&currentPage=1&perPage=10&SN=1
    // &currentPage=1
    // &perPage=10
    // &SN=1
    // /ResponseEntity<Object>
    /// helloWorldResponse/1/10/1
    @GetMapping("/helloWorldResponse/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponse(@PathVariable String currentPage,
            @PathVariable String perPage, @PathVariable String SN) {
        // "spm_row": 471,"SN": 1,"CMPNM": "로이유통","RDNMADR": null
        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMDR", null);
        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/helloWorldResponseList/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseList(@PathVariable String currentPage,
            @PathVariable String perPage, @PathVariable String SN) {
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3
        ArrayList arrayList = new ArrayList<>() ; 
        HashMap <String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMDR", null);
        arrayList.add(resultMap); 

        resultMap = new HashMap<String,Object>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMDR", 3);
        arrayList.add(resultMap); 

        return ResponseEntity.ok().body(arrayList);
    }



   
    
 /// helloWorldResponseWithService/1/10/1
    @GetMapping("/helloWorldResponseWithService/{currentPage}/{perPage}/{SN}")
    public ResponseEntity<Object> helloWorldResponseWithService(@PathVariable String currentPage,
            @PathVariable String perPage, @PathVariable String SN) {
                ArrayList arrayList = new ArrayList<>() ;  // arraylist 인스턴스화 
                // helloworld 인스턴스화 
                arrayList = HelloWorldService.fakeSelect(currentPage ,perPage) ; 

        return ResponseEntity.ok().body(arrayList);
    }

}
