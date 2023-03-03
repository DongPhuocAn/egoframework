package egovframework.example.sample.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.VO.ShopDefaultVO;
import egovframework.example.sample.service.ShopService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@RestController
public class ShopController {

	@Resource(name = "shopService")
	private ShopService shopService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	
	@RequestMapping(value = "/productLineList.do")
	public ResponseEntity<List<?>> selectProductLineList( ShopDefaultVO searchProductLineVO, ModelMap model) throws Exception {

		if(searchProductLineVO.getPageIndex() > 0) {
			searchProductLineVO.setPageIndex(1);
		}
	
//		/** EgovPropertyService.sample */
//		searchProductLineVO.setPageUnit(propertiesService.getInt("pageUnit"));
//		searchProductLineVO.setPageSize(propertiesService.getInt("pageSize"));
//
		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchProductLineVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchProductLineVO.getPageUnit());
		paginationInfo.setPageSize(searchProductLineVO.getPageSize());

		searchProductLineVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchProductLineVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchProductLineVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> productLineList = shopService.selectProductLineList(searchProductLineVO);
		//model.addAttribute("resultList", productLineList);

//		int totCnt = shopService.selectProductLineListTotCnt(searchProductLineVO);
//		paginationInfo.setTotalRecordCount(totCnt);
		//model.addAttribute("paginationInfo", paginationInfo);
		
		
		return new ResponseEntity<List<?>>(productLineList, HttpStatus.OK);
	}
	
	
}
