package com.example.study_springboot.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.study_springboot.dao.SharedDao;

@Service //1. [스프링]을 잘 관리할 수 있도록 cab을 씌움 
public class CarInforsService {
    @Autowired // 자동으로 연결 필요 
    SharedDao sharedDao; 
    public Object selectDetail(String CAR_INFOR_ID ){
        // Object getOne(String sqlMapId, Object dataMap) 
        String sqlMapId = "CarInfors.selectByUID"; // carInforMapper.xml파일 상세에서 불러옴
        HashMap<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID );
         
        Object result = sharedDao.getOne(sqlMapId, dataMap); // sharedDao get 할 시 자동으로 파라미터 값이 불러옴 . 
        return result;
    }

}
