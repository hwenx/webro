package org.jbros.webro.common.models;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Paging {
	private Integer totalCount;
	private Integer offset = 10;
	private Integer page;
	private Integer pageNum;

	public Paging() {
		
	}
	
	public Paging(Integer page, Integer totalCount){
		setPage((page - 1) * offset);
		setTotalCount(totalCount);
		
	}
	
    public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page ;
	}
	
	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		if (pageNum == null || pageNum < 0) {
			pageNum = 1;
		}
		
		this.pageNum = pageNum;
		this.page = (this.pageNum - 1) * 10;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
