package egovframework.example.sample.service.impl;

import java.util.List;

import egovframework.example.sample.VO.ProductlinesVO;
import egovframework.example.sample.VO.ProductsVO;
import egovframework.example.sample.VO.ShopDefaultVO;
import egovframework.example.sample.VO.TeacherDefaultVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("shopMapper")
public interface ShopMapper {

	List<?> selectProductLineList(ShopDefaultVO vo) throws Exception;
	
	int selectProductLineListTotCnt(ShopDefaultVO vo);

	
}
