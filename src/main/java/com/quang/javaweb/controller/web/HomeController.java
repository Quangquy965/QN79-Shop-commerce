package com.quang.javaweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.quang.javaweb.dto.CategoryDTO;
import com.quang.javaweb.service.ICategoryService;
import com.quang.javaweb.service.IProductService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {

		CategoryDTO category = new CategoryDTO();
		ModelAndView mav = new ModelAndView("web/home");
		category.setListResult(categoryService.findAll(null));
		mav.addObject("category", category);
		mav.addObject("productHighLight", productService.GetDataProducts(2));
		mav.addObject("productNews", productService.GetDataProducts(1));

		return mav;
	}

	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	public ModelAndView loginPage() {

		ModelAndView mav = new ModelAndView("login");

		return mav;
	}

	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView registrationPage() {
		ModelAndView mav = new ModelAndView("registration");
		return mav;
	}

	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {

		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}

	
	@RequestMapping(value = "/trang-chu/tin-tuc", method = RequestMethod.GET)
	public ModelAndView newsPage() {

		ModelAndView mav = new ModelAndView("web/menu/news");

		return mav;
	}
	@RequestMapping(value = "/trang-chu/lien-he", method = RequestMethod.GET)
	public ModelAndView contacPage() {

		ModelAndView mav = new ModelAndView("web/menu/contact");

		return mav;
	}
//	@RequestMapping(value = "/trang-chu/newProduct", method = RequestMethod.GET)
//	public ModelAndView newProductsPage() {
//
//		ModelAndView mav = new ModelAndView("web/product/NewProduct");
//		mav.addObject("productNew", productService.GetDataNewProduct());
//		
//		return mav;
//	}
//	@RequestMapping(value = "/trang-chu/highLight", method = RequestMethod.GET)
//	public ModelAndView highLightProductsPage() {
//
//		ModelAndView mav = new ModelAndView("web/product/HighLight");
//		mav.addObject("productHighLight", productService.GetDataHighLight());
//
//		return mav;
//	}
	@RequestMapping(value = "/trang-chu/xem-truoc", method = RequestMethod.GET)
	public ModelAndView perViewPage() {

		ModelAndView mav = new ModelAndView("web/perview");

		return mav;
	}
}
