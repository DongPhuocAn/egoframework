/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.sample.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.VO.TeacherDefaultVO;
import egovframework.example.sample.VO.TeacherVO;
import egovframework.example.sample.service.TeacherService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class TeacherController {

	/** EgovSampleService */
	@Resource(name = "teacherService")
	private TeacherService teacherService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	/**
	 * 글 목록을 조회한다. (pageing)
	 * @param searchTeacherVO - 조회할 정보가 담긴 TeacherDefaultVO
	 * @param model
	 * @return "teacherList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/teacherList.do")
	public String selectTeacherList(@ModelAttribute("searchTeacherVO") TeacherDefaultVO searchTeacherVO, ModelMap model) throws Exception {

	
		/** EgovPropertyService.sample */
		searchTeacherVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchTeacherVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchTeacherVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchTeacherVO.getPageUnit());
		paginationInfo.setPageSize(searchTeacherVO.getPageSize());

		searchTeacherVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchTeacherVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchTeacherVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> teacherList = teacherService.selectTeacherList(searchTeacherVO);
		model.addAttribute("resultList", teacherList);

		int totCnt = teacherService.selectTeacherListTotCnt(searchTeacherVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "teacher/teacherList";
	}
	
	@RequestMapping(value = "/searchTeacherList.do")
	public String searchTeacherList(@ModelAttribute("searchTeacherVO") TeacherDefaultVO searchTeacherVO, ModelMap model) throws Exception {

		if(searchTeacherVO.getPageIndex() > 0) {
			searchTeacherVO.setPageIndex(1);
		}
		/** EgovPropertyService.sample */
		searchTeacherVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchTeacherVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing setting */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchTeacherVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchTeacherVO.getPageUnit());
		paginationInfo.setPageSize(searchTeacherVO.getPageSize());

		searchTeacherVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchTeacherVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchTeacherVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> teacherList = teacherService.selectTeacherList(searchTeacherVO);
		System.out.println(teacherList);
		model.addAttribute("resultList", teacherList);

		int totCnt = teacherService.selectTeacherListTotCnt(searchTeacherVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "teacher/teacherList";
	}

	/**
	 * 글 등록 화면을 조회한다.
	 * @param searchTeacherVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "teacherRegister"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addTeacher.do", method = RequestMethod.GET)
	public String addTeacherView(@ModelAttribute("searchTeacherVO") TeacherDefaultVO searchTeacherVO, Model model) throws Exception {
		model.addAttribute("teacherVO", new TeacherVO());
		return "teacher/teacherRegister";
	}

	/**
	 * 글을 등록한다.
	 * @param teacherVO - 등록할 정보가 담긴 VO
	 * @param searchTeacherVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/teacherList.do"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addTeacher.do", method = RequestMethod.POST)
	public String addTeacher(@ModelAttribute("searchTeacherVO") TeacherDefaultVO searchTeacherVO, TeacherVO teacherVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		// Server-Side Validation
		beanValidator.validate(teacherVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("teacherVO", teacherVO);
			return "teacher/teacherRegister";
		}

		teacherService.insertTeacher(teacherVO);
		status.setComplete();
		return "forward:/teacherList.do";
	}

	/**
	 * 글 수정화면을 조회한다.
	 * @param id - 수정할 글 id
	 * @param searchTeacherVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "teacherRegister"
	 * @exception Exception
	 */
	@RequestMapping("/updateTeacherView.do")
	public String updateTeacherView(@RequestParam("selectedId") String id, @ModelAttribute("searchTeacherVO") TeacherDefaultVO searchTeacherVO, Model model) throws Exception {
		TeacherVO teacherVO = new TeacherVO();
		teacherVO.setId(id);
		// 변수명은 CoC 에 따라 teacherVO
		model.addAttribute(selectTeacher(teacherVO, searchTeacherVO));
		return "teacher/teacherRegister";
	}

	/**
	 * 글을 조회한다.
	 * @param teacherVO - 조회할 정보가 담긴 VO
	 * @param searchTeacherVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("teacherVO") - 조회한 정보
	 * @exception Exception
	 */
	public TeacherVO selectTeacher(TeacherVO teacherVO, @ModelAttribute("searchTeacherVO") TeacherDefaultVO searchTeacherVO) throws Exception {
		return teacherService.selectTeacher(teacherVO);
	}

	/**
	 * 글을 수정한다.
	 * @param teacherVO - 수정할 정보가 담긴 VO
	 * @param searchTeacherVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/teacherList.do"
	 * @exception Exception
	 */
	@RequestMapping("/updateTeacher.do")
	public String updateTeacher(@ModelAttribute("searchTeacherVO") TeacherDefaultVO searchTeacherVO, TeacherVO teacherVO, BindingResult bindingResult, Model model, SessionStatus status)
			throws Exception {

		beanValidator.validate(teacherVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("teacherVO", teacherVO);
			return "teacher/teacherRegister";
		}

		teacherService.updateTeacher(teacherVO);
		status.setComplete();
		return "forward:/teacherList.do";
	}

	/**
	 * 글을 삭제한다.
	 * @param teacherVO - 삭제할 정보가 담긴 VO
	 * @param searchTeacherVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/teacherList.do"
	 * @exception Exception
	 */
	@RequestMapping("/deleteTeacher.do")
	public String deleteTeacher(TeacherVO teacherVO, @ModelAttribute("searchTeacherVO") TeacherDefaultVO searchTeacherVO, SessionStatus status) throws Exception {
		teacherService.deleteTeacher(teacherVO);
		status.setComplete();
		return "forward:/teacherList.do";
	}
	
}
