package com.example.level6;

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
        Menu orderMenu = new Menu("OrderMenu");
        orderMenu.addMenuList(new MenuItem("Orders", 0, "장바구니 확인 후 주문합니다."));
        orderMenu.addMenuList(new MenuItem("Cancel", 0, "진행중인 주문을 취소 합니다."));
        Menu shoppingCart = new Menu("ShoppingCart");

        // 반복문 시작
        while (true) {
            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            // order메뉴에 값이 있으면 추가로 출력(없으면 출력하지 않음)
            if (!shoppingCart.getMenuItems().isEmpty()) {
                System.out.println("[ " + orderMenu.getCategoryName() + " ]");
                for (int j = 0; j < orderMenu.getMenuItems().size(); j++) {
                    System.out.println((j + 1 + menus.size()) + ". " + orderMenu.getMenuItems().get(j));
                }
            }

            // 숫자 입력 받기
            System.out.print("메뉴 번호를 선택하세요: ");
            int choice = sc.nextInt();

            // 입력 받은 숫자에 따른 로직
            // 0을 입력받으면 프로그램 종료
            if (choice == 0) {
                // 0을 입력받으면 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (choice > 0 && choice <= menus.size()) {
                // 입력 받은 숫자가 0보다 크고 menus의 크기보다 크면 선택한 메뉴로 접근
                Menu choiceMenu = menus.get(choice - 1);

                // 선택한 메뉴 반복문 시작
                while (true) {
                    choiceMenu.openMenu();
                    System.out.print("메뉴 번호를 선택하세요: ");
                    int choice2 = sc.nextInt();

                    // 0을 입력받으면 MAINMENU로 돌아가기
                    if (choice2 == 0) {
                        // 0을 입력받으면 MAINMENU로 돌아가기
                        System.out.println("MAIN MENU로 돌아갑니다.");
                        break;
                    } else if (choice2 > 0 && choice2 <= choiceMenu.getMenuItems().size()) {
                        // 올바른 메뉴를 고르면 선택한 메뉴를 장바구니에 추가하는 메뉴 출력
                        MenuItem choiceMenuItem = choiceMenu.getMenuItems().get(choice2 - 1);
                        while (true) {
                            System.out.println("선택한 메뉴: " + choiceMenuItem);
                            System.out.println("1. 확인      2. 취소");
                            System.out.print("위 메뉴를 장바구니에 추가하시겠습니까?: ");
                            int orderChoice = sc.nextInt();

                            if (orderChoice == 1) {
                                // 1을 입력하면 장바구니에 추가
                                System.out.println("장바구니에 추가 되었습니다.");
                                shoppingCart.addMenuList(choiceMenu.getMenuItems().get(choice2 - 1));
                                break;
                            } else if (orderChoice == 2) {
                                // 2를 입력하면 돌아가기
                                System.out.println("취소 되었습니다.");
                                break;
                            } else {
                                // 그 외에 값을 입력하면 다시 입력
                                System.out.println("잘못된 값을 입력하였습니다.");
                            }
                        }
                    } else {
                        System.out.println("잘못된 값을 입력하였습니다.");
                    }
                }
            } else if (choice == 4 && !shoppingCart.getMenuItems().isEmpty()) {
                // 장바구니에 추가된 메뉴가 있고 4번 메뉴를 골랐다면 장바구니에 메뉴들을 확인하고 주문
                System.out.println("아래와 같이 주문 하시겠습니까?");
                for (int a = 0; a < shoppingCart.getMenuItems().size(); a++) {
                    System.out.println(shoppingCart.getMenuItems().get(a));
                }
                // 장바구니에 있는 메뉴 가격의 총합 구하기
                double sumPrice = 0;
                for (int b = 0; b < shoppingCart.getMenuItems().size(); b++) {
                    sumPrice = sumPrice + shoppingCart.getMenuItems().get(b).getPrice();
                }

                while (true) {
                    System.out.println("[ Total ]");
                    System.out.println("W " + sumPrice);
                    System.out.println("1. 주문       2. 메뉴판");
                    System.out.print("메뉴를 번호를 선택하세요: ");
                    int orderNum = sc.nextInt();

                    if (orderNum == 1) {
                        // 주문을 하면 총액을 출력하고 장바구니 초기화
                        System.out.println("주문이 완료되었습니다. 금액은 W " + sumPrice + " 입니다.");
                        shoppingCart.clearMenuList();
                        break;
                    } else if (orderNum == 2) {
                        // 메뉴판으로 돌아가기
                        System.out.print("메뉴판으로 돌아갑니다.");
                        break;
                    } else {
                        // 잘못된 값
                        System.out.println("잘못된 값을 입력하였습니다.");
                    }
                }
            } else if (choice == 5 && !shoppingCart.getMenuItems().isEmpty()) {
                // 장바구니에 추가된 메뉴가 있고 5번 메뉴를 골랐다면 장바구니에 메뉴들을 확인하고 삭제
                while (true) {
                    for (int c = 0; c < shoppingCart.getMenuItems().size(); c++) {
                        System.out.println((c+1) + ". " + shoppingCart.getMenuItems().get(c));
                    }
                    System.out.println("0. 뒤로 가기");
                    System.out.print("몇번 메뉴를 취소 하시겠습니까?: ");
                    int cancelNum = sc.nextInt();
                    if (cancelNum == 0) {
                        // 0을 입력하면 메뉴로 돌아가기
                        System.out.println("뒤로 돌아갑니다.");
                        break;
                    } else if (cancelNum > 0 && cancelNum <= shoppingCart.getMenuItems().size()) {
                        // 고른 메뉴 장바구니에서 삭제
                        shoppingCart.removeMenuList(cancelNum-1);
                        System.out.println(cancelNum + "번 메뉴가 취소 되었습니다.");
                    } else {
                        // 잘못된 값
                        System.out.println("잘못된 값을 입력하였습니다.");
                    }
                }
            } else {
                // 잘못된 값
                System.out.println("잘못된 값을 입력하였습니다.");
            }
        }
    }
}
