package egovframework.example.sample.service;

import java.util.List;

import egovframework.example.sample.VO.ShopDefaultVO;

public interface ShopService {
	
	List<?> selectProductLineList(ShopDefaultVO vo) throws Exception;
	
	int selectProductLineListTotCnt(ShopDefaultVO vo);
	
}
