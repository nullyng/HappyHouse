package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.model.dto.CodeDto;
import com.ssafy.happyhouse.model.mapper.CodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeServiceImpl implements CodeService{

    @Autowired
    private CodeMapper codeMapper;

    @Override
    // * 시도
    // 11* 구군
    // 11111* 동
    public List<CodeDto> getCodeDtoList(String regcode) {
        int index = regcode.indexOf('*');
        if(index == 0){
            return codeMapper.getSidoList();
        }else if(index == 2){
            return codeMapper.getGugunList(regcode.substring(0, index));
        }else if(index == 5){
            return codeMapper.getDongList(regcode.substring(0, index));
        }else{
            return new ArrayList<>();
        }
    }
}
