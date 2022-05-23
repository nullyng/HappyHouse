package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.model.dto.CodeDto;

import java.util.List;

public interface CodeService {
    List<CodeDto> getCodeDtoList(String regcode);
}
