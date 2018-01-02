package com.dyz.gameserver.pojo;

import java.util.List;

public class PageModel{
	private List currentPageDatas;// 当前页数据
	private int pageCount = 1;// 总页数
	private int dataCount = 0;// 数据总数
	private int pageNo = 1;// 当前页码
	private int pageSize = 10;// 每页显示条数
	private int begin = 0;// 数据库分页开始位置
	private String  keywords;

	public List getCurrentPageDatas() {
		return currentPageDatas;
	}

	public void setCurrentPageDatas(List currentPageDatas) {
		this.currentPageDatas = currentPageDatas;
	}

	public int getPageCount() {
		if (dataCount / pageSize != 0) {
			pageCount = dataCount / pageSize;
			if (dataCount % pageSize != 0) {
				pageCount++;
			}
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if (pageNo != 0) {
			this.pageNo = pageNo;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize != 0) {
			this.pageSize = pageSize;
		}
	}

	public int getBegin() {
		// 通过当前页码和每页显示条数，计算开始位置。
	    if (begin>0) {
	        return begin;
        }
		this.begin = (this.pageNo - 1) * this.pageSize;
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	   
}
