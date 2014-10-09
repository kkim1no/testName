package org.han.dao;

public interface GenericDAO<E, K , L> {
	public void create(E vo)throws Exception;
	
	public E read(K no)throws Exception;
	//조회
	public void update(E vo)throws Exception;
	//수정
	public void delete(K no)throws Exception;
	//삭제
	public L allread()throws Exception;
}
