package org.han.util;

public class PageMaker {

	private int page;
	private int cnt;
	private int lineCount;
	private int perPage;
	private int first;
	private int last;
	
	//������, Overloading
	
	//���޹��� param�� String Ÿ���� �� Int type���� parse
	public static int getNumber(String str){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			
			//������ �߻� �� ��� ������ 1�� return
			return 1;
		}
	}
	
	//param�� ���� ��
	//public PageMaker(int page) �� 1 �ֱ�
	public PageMaker(){
		this(1);
	}
	
	//param���� page ������, 
	//public PageMaker(int page, int cnt==0)
	public PageMaker(int page){
		this(page, 0);
	}
	
	//param�� String type�� �� getNumber�� ����ȯ
	//public PageMaker(int page, int cnt==0)
	public PageMaker(String pageStr){
		this(getNumber(pageStr),0);
	}
	
	//param�� 2���� �� 
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
		//RowNum ���� 
	}
	
	
	
	public int getRowNum(){
		//Math.ceil ���� �� �� �ø�
		//�� Data Count �ϱ�? 
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






