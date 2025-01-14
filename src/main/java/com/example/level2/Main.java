package com.example.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // MenuItem 객체 생성
        MenuItem shackBurger = new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem smokeShack = new MenuItem("SmokeShack  ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem cheeseburger = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem hamburger = new MenuItem("Hamburger   ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        // List에 MenuItem 객체 추가
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(shackBurger);
        menuItems.add(smokeShack);
        menuItems.add(cheeseburger);
        menuItems.add(hamburger);

        // Scanner 선언
        Scanner sc = new Scanner(System.in);

        // 전체 반복
        while (true) {
            // 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuItems.toArray().length; i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i).name + " | W " + menuItems.get(i).price + " | " + menuItems.get(i).explanation);
            }
            System.out.println("0. 종료");

            // 숫자 입력
            System.out.print("번호를 입력하세요.: ");
            String number = sc.next();

            // 입력된 숫자에 따른 처리
            if ("1".equals(number)) {
                System.out.println("선택한 메뉴 : 이름 : ShackBurger, 가격 : 6.9, 설명 : 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            } else if ("2".equals(number)) {
                System.out.println("선택한 메뉴 : 이름 : SmokeShack, 가격 : 8.9, 설명 : 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            } else if ("3".equals(number)) {
                System.out.println("선택한 메뉴 : 이름 : Cheeseburger, 가격 : 6.9, 설명 : 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            } else if ("4".equals(number)) {
                System.out.println("선택한 메뉴 : 이름 : Hamburger, 가격 : 5.4, 설명 : 비프패티를 기반으로 야채가 들어간 기본버거");
            } else if ("0".equals(number)) {
                // 0을 입력하면 반복문 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("0~4를 입력해 주세요.");
            }
        }
    }
}