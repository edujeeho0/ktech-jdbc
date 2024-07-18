package org.example.article;

public class ArticleMain {
    public static void main(String[] args) {
        // 테스트 단계
        ArticleRepository repo = new ArticleRepository();
        /*repo.create(new Article(
                "test 2",
                "test content 2"
        ));
        repo.create(new Article(
                "test 3",
                "test content 3"
        ));
        repo.create(new Article(
                "test 4",
                "test content 4"
        ));
        repo.create(new Article(
                "test 5",
                "test content 5"
        ));*/
        for (Article article : repo.readAll()) {
            System.out.println(article);
        }
    }
}
