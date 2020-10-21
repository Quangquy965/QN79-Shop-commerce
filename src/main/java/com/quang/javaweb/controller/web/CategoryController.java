package com.quang.javaweb.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quang.javaweb.dto.ProductDTO;
import com.quang.javaweb.service.IProductService;

@Controller(value = "CategoryControllerOfWeb")
public class CategoryController {
//	
//	@Autowired
//	private ICategoryService categoryService;
//	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "trang-chu/san-pham", method = RequestMethod.GET)
	public ModelAndView showCategory(@RequestParam("page") int page,
									@RequestParam("limit") int limit,
									@RequestParam(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("web/menu/category");
		ProductDTO model = new ProductDTO();	
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(productService.GetDataProductsById(id,pageable));
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);		
		return mav;
	}

}
