package com.example.level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // 필드
    private List<Menu> menus;

    //생성자
    public Kiosk() {
        this.menus = new ArrayList<>();
    }

    // 메서드
    // 리스트 getter
    public List<Menu> getMenus () {
        return new ArrayList<>(menus);
    }

    // 리스트 setter
    public void setMenus(List<Menu> menus) {
        this.menus = new ArrayList<>(menus);
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        // 스캐너 선언
        Scanner sc = new Scanner(System.in);
        // 반복문 시작
        while (true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            // 숫자 입력 받기
            System.out.print("메뉴 번호를 선택하세요: ");
            int choice = sc.nextInt();

            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= menus.size()) {
                Menu choiceMenu = menus.get(choice - 1);

                while (true) {
                    choiceMenu.openMenu();
                    System.out.print("메뉴 번호를 선택하세요: ");
                    int choice2 = sc.nextInt();

                    if (choice2 == 0) {
                        System.out.println("MAIN MENU로 돌아갑니다.");
                        break;
                    } else if (choice2 > 0 && choice2 <= choiceMenu.getMenuItems().size()) {
                        MenuItem choiceMenuItem = choiceMenu.getMenuItems().get(choice2 - 1);
                        System.out.println("선택한 메뉴: " + choiceMenuItem);
                    } else {
                        System.out.println("잘못된 값을 입력하였습니다.");
                    }
                }
            } else {
                System.out.println("잘못된 값을 입력하였습니다.");
            }
        }
    }
}
