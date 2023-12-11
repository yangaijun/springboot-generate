package com.light.common.multipleselect;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class MultipleResult {
	private List<Map<String, Object>> records;
	private Integer current;
	private Integer size;
	private Integer total;
}
