package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.VO.ProductlinesVO;
import egovframework.example.sample.VO.ShopDefaultVO;
import egovframework.example.sample.service.ShopService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Service("shopService")
public class ShopServiceImpl extends EgovAbstractServiceImpl implements ShopService {

	@Resource(name="shopMapper")
	private ShopMapper shopMapper;
	
	/** ID Generation */
	@Resource(name = "egovIdGnrServiceTeacher")
	private EgovIdGnrService egovIdGnrService;

	@Override
	public List<?> selectProductLineList(ShopDefaultVO vo) throws Exception {
		return shopMapper.selectProductLineList(vo);
	}

	@Override
	public int selectProductLineListTotCnt(ShopDefaultVO vo) {
		return shopMapper.selectProductLineListTotCnt(vo);
	}
	
	

}
