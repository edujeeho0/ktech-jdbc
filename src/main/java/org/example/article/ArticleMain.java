package org.example.article;

public class ArticleMain {
    public static void main(String[] args) {
        // 테스트 단계
        ArticleRepository repo = new ArticleRepository();
        repo.create(new Article(
                "test 1",
                "test content 1"
        ));
    }
}
