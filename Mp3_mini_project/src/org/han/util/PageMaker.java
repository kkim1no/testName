package org.han.util;

public class PageMaker {

	private int page;
	private int cnt;
	private int lineCount;
	private int perPage;
	private int first;
	private int last;
	
	//생성자, Overloading
	
	//전달받은 param이 String 타입일 때 Int type으로 parse
	public static int getNumber(String str){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			
			//에러가 발생 할 경우 무조건 1을 return
			return 1;
		}
	}
	
	//param이 없을 때
	//public PageMaker(int page) 에 1 넣기
	public PageMaker(){
		this(1);
	}
	
	//param으로 page 받으면, 
	//public PageMaker(int page, int cnt==0)
	public PageMaker(int page){
		this(page, 0);
	}
	
	//param이 String type일 때 getNumber로 형변환
	//public PageMaker(int page, int cnt==0)
	public PageMaker(String pageStr){
		this(getNumber(pageStr),0);
	}
	
	//param이 2개일 때 
	//PageMaker(int page, int cnt, int lineCount==10, int perPage==10)
	public PageMaker(int page, int cnt) {
		this(page, cnt, 10,10);
	}
	
	public PageMaker(int page, int cnt, int lineCount, int perPage) {
		super();
		this.page = page;
		//Page Number
		this.cnt = cnt;
		//Data Count 
		this.lineCount = lineCount;
		//View Page Count
		this.perPage = perPage;
		//Data Count in a page
		
		this.first = 1;
		this.last = 10;
		//RowNum 범위 
	}
	
	
	
	public int getRowNum(){
		//Math.ceil 지정 된 수 올림
		//총 Data Count 하기? 
		return (  ( (int)(Math.ceil(page/(double)perPage)) ) * (perPage * lineCount))  +1;
		
	}
	
	public int getRnFirst(){
		
		return getRnLast() - perPage;
	}
	
	public int getRnLast(){
		
		return (page * perPage);
	}
	

	@Override
	public String toString() {
		return "PageMaker [page=" + page + ", cnt=" + cnt + ", lineCount="
				+ lineCount + ", perPage=" + perPage + "]";
	}
	
	public static void main(String[] args) {

		PageMaker maker = new PageMaker(12);
		System.out.println(maker.getRowNum());
	}
	
	
	//Get_Setter	
	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getLineCount() {
		return lineCount;
	}

	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
}






