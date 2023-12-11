package com.light.common.multipleselect.mapper;

import com.light.common.multipleselect.MultipleSelect;

import java.util.List;
import java.util.Map;
 
public interface MultipleMapper {
    public List<Map<String, Object>> mulSelect(MultipleSelect param);
    public Integer countMulSelect(MultipleSelect param);
}
