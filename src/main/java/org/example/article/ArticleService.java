package org.example.article;

import java.util.Optional;
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
    public void readArticle() {
        System.out.print("게시물 번호를 입력하세요: ");
        String input = scanner.nextLine();
        try {
            Long id = Long.parseLong(input);
            Optional<Article> optionalArticle = repository.readOne(id);
            if (optionalArticle.isEmpty()) {
                System.out.println("게시물을 찾을 수 없습니다.");
            }
            else {
                Article article = optionalArticle.get();
                System.out.println(article.getTitle());
                System.out.println();
                System.out.println(article.getContent());
            }
        } catch (NumberFormatException ignored) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    // 4. Article 삭제하기
    public void deleteArticle() {
        System.out.print("게시물 번호를 입력하세요: ");
        String input = scanner.nextLine();
        try {
            Long id = Long.parseLong(input);
            if (repository.delete(id)) {
                System.out.println("삭제되었습니다.");
            } else {
                System.out.println("게시물을 찾을 수 없습니다.");
            }
        } catch (NumberFormatException ignored) {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
