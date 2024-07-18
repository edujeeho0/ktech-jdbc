package org.example.article;

import java.util.Scanner;

public class ArticleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArticleService service = new ArticleService(scanner);
        // 사용자한테 어떤 기능을 사용할지를 반복해서 물어본다.
        while (true) {
            System.out.println("기능을 선택하세요");
            System.out.println("1. 작성하기");
            System.out.println("2. 전체 조회하기");
            System.out.println("3. 게시글 읽기");
            System.out.println("q. 종료");
            String input = scanner.nextLine();
            if (input.equals("q")) break;
            switch (Integer.parseInt(input)) {
                case 1 -> service.createArticle();
                case 2 -> service.readAllArticles();
                case 3 -> service.readArticle();
            }
            System.out.println();
        }
        System.out.println("Bye!!!");
    }
}
