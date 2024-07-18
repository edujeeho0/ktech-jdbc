package org.example.article;

import java.util.Scanner;

// Service - 본질적인 기능(비즈니스 로직)
// 저장할 데이터를 모아서 전달하거나
// 조회된 데이터를 원하는 형태로 재가공한다.
public class ArticleService {
    private final ArticleRepository repository;
    private final Scanner scanner;

    public ArticleService(Scanner scanner) {
        this.repository = new ArticleRepository();
        this.scanner = scanner;
    }

    // 1. 사용자한테서 새로 생성할 Article 데이터 받기
    public void createArticle() {
        System.out.print("제목을 입력하세요: ");
        String title = scanner.nextLine();
        System.out.print("내용을 입력하세요: ");
        String content = scanner.nextLine();
        repository.create(new Article(
                title,
                content
        ));
    }

    // 2. 전체 Article 데이터를 표시하기
    public void readAllArticles() {
        for(Article article: repository.readAll()) {
            System.out.println(String.format(
                    "%d. %s",
                    article.getId(),
                    article.getTitle()
            ));
        }
    }

    // 3. 하나의 Article 데이터 표시하기
    // 4. Article 삭제하기
}
