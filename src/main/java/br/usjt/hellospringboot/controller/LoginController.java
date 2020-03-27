package br.usjt.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import br.usjt.hellospringboot.model.Temperatura;
import br.usjt.hellospringboot.model.Usuario;
import br.usjt.hellospringboot.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	@GetMapping(value = { "/login", "/" })
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject(new Usuario());
		return mv;
	}

	@Configuration
	public class AppConfig implements WebMvcConfigurer {
		@Bean
		public Temperatura getTemperatura() {
			return new Temperatura();
		}

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new LocaleChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/login",
					"/", "/fazerLogin");
		}
	}

	@PostMapping("/fazerLogin")
	public String fazerLogin(Usuario usuario) {
		if (loginService.logar(usuario)) {
			return "redirect:alunos";
		} else {
			return "login";
		}
	}
}
