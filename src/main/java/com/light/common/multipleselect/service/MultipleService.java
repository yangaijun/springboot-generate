package com.light.common.multipleselect.service;

import com.light.common.multipleselect.MultipleResult;
import com.light.common.multipleselect.MultipleSelect;
import com.light.common.multipleselect.Page;
import com.light.common.multipleselect.mapper.MultipleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
@Service
public class MultipleService {
	@Autowired
	private MultipleMapper mapper;

    public MultipleResult multipleSelect(MultipleSelect param) {
    	MultipleResult result = new MultipleResult(); 
    	result.setRecords(mapper.mulSelect(param));
    	
    	if (param.getStart() != null && param.getEnd() != null) {
    		Integer total = mapper.countMulSelect(param);
			result.setTotal(total);
			result.setSize(param.getEnd());
			result.setCurrent(param.getStart() / param.getEnd() + 1);
    	}

    	return result;
    }
}
