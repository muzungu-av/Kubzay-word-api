package ru.kubzay.restgatewayapi.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Сопоставляем путь URI (в анотации) со страницей.
 * Страницы (публичные) могут лежать в папках static/ или public/ - эту часть пути не нужно указывать в return.
 * Это не путь файловой системы, а зарегестрированный в SpringBoot ресурс по умолчанию.
 *
 * Приватные страницы (см WebPageConfig) маппим указывая "/private/private.html"
 *
 * Следующие ресурсы регистрируются по-умолчанию:
 * /META-INF/resources/
 * /resources/
 * /static/
 * /public/
 *
 * смотри SpringSecurityConfig метод configure(WebSecurity web), где указываем какие ресурсы не фильтровать
 * по Security фильтру (JwtCsrfFilter), тогда к ним не нужна будет авторизация.
 *
 * https://www.baeldung.com/spring-mvc-static-resources
 */

@Controller
public class WebPageController {

    @RequestMapping("/static")
    public String publicPage() {
        return "static.html";
    }

    @RequestMapping("/private")
    public String privatePage() {
        return "/private/private.html";
    }

/* по-умолчанию /index.html маппится к "/" */
//    @RequestMapping("/")
//    public String homePage() {
//        return "index.html";
//    }
}
