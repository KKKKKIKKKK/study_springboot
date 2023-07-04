package com.example.study_springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.study_springboot.dao.SharedDao;

@Service //1. [스프링]을 잘 관리할 수 있도록 cab을 씌움 
@Transactional

public class CarCompanyService {
    
  @Autowired // 자동으로 연결 필요 
    SharedDao sharedDao; 



    //검색(조건-search : YEAR, CAR_NAME) 
    public Object selectSearch(String search, String words ){
       
        String sqlMapId = "CarCompany.selectSearch"; // CarCompanyMapper.xml파일 상세에서 불러옴
        HashMap<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("search", search );
        dataMap.put("words", words );
         
        Object result = sharedDao.getList(sqlMapId, dataMap); // sharedDao get 할 시 자동으로 파라미터 값이 불러옴 . 
        return result;
    }
    

    // 메쏘드 이름과 dao부를때 이름만 바꾸고 select datail 그대로 이용 
    public Object selectAll(String COMPANY_ID ){
        // Object getOne(String sqlMapId, Object dataMap) 
        String sqlMapId = "CarCompany.selectAll"; // CarCompanyMapper.xml파일 상세에서 불러옴
        HashMap<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("COMPANY_ID", COMPANY_ID );
         
        Object result = sharedDao.getList(sqlMapId, dataMap); // sharedDao get 할 시 자동으로 파라미터 값이 불러옴 . 
        return result;
    }
     public Object selectDetail(String COMPANY_ID ){
        // Object getOne(String sqlMapId, Object dataMap) 
        String sqlMapId = "CarCompany.selectByUID"; // CarCompanyMapper.xml파일 상세에서 불러옴
        HashMap<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("COMPANY_ID", COMPANY_ID );
         
        Object result = sharedDao.getOne(sqlMapId, dataMap); // sharedDao get 할 시 자동으로 파라미터 값이 불러옴 . 
        return result;
    }
    // insert 문 
    public Object insert(Map dataMap){//  controller에서 datamap묶음으로 넘어옴
        String sqlMapId = "CarCompany.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap) ;
        return result;
    }
    
     //update
     public Object update(Map dataMap){//  controller에서 datamap묶음으로 넘어옴
        String sqlMapId = "CarCompany.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }

     //delete
     //클라이언트가 가져오는 키가 딱 1개이기에 여러개 쓸 필요없다. 
     public Object delete(String COMPANY_ID){//  controller에서 datamap묶음으로 넘어옴
        String sqlMapId = "CarCompany.delete";
        HashMap<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("COMPANY_ID", COMPANY_ID );

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }
        //insert문 복사(2PC COMMIT) 
        public Object insertDouble(Map dataMap){//  controller에서 datamap묶음으로 넘어옴
        String sqlMapId = "CarCompany.insert";
        //success 됨
        Object result = sharedDao.insert(sqlMapId, dataMap) ;
        
        //error 됨 
        result  = sharedDao.insert(sqlMapId, dataMap) ;
        return result;
    }



}
