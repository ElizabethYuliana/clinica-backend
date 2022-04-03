package com.clinica.core.common;

import com.clinica.dto.mapper.GenericMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public GenericMapper genericMapper;

}
