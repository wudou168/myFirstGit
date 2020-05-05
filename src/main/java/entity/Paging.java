package entity;

public class Paging {

	private  int currPage; 
	private int pageSize;
	private int totalRecords;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Paging() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paging(int currPage, int pageSize, int totalRecords) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalRecords = totalRecords;
	}
	
	public int getTotalPages() {
		int totalPages = 0;
		if(currPage>0 && pageSize>0 && totalRecords>=0) {
			if(totalRecords%pageSize == 0 ) {
				totalPages = totalRecords/pageSize;
			}else {
				totalPages = totalRecords/pageSize+1;
			}
		}
		return totalPages;
	}
}
