package com.kero99.wp.common.entity;

import java.util.List;

public class PageResult<E> {
	private Long total;
	private List<E> rows;
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<E> getRows() {
		return rows;
	}
	public void setRows(List<E> rows) {
		this.rows = rows;
	}
	
}
