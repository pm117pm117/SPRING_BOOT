package com.example.demo.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List; // List를 import
import com.example.demo.model.domain.Article; // Article 클래스 import
import com.example.demo.model.service.BlogService; // BlogService import

@Controller
public class BlogController {

    private final BlogService blogService; // final로 선언된 필드

    // @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService; // blogService 초기화
    }

    @GetMapping("/article_list") // 게시판 링크 지정
    public String article_list(Model model) {
        List<Article> list = blogService.findAll(); // 게시판 리스트
        model.addAttribute("articles", list); // 모델에 추가
        return "article_list"; // .HTML 연결
    }

    
}
