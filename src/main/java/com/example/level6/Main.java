package com.example.level6;

public class Main {
    public static void main(String[] args) {
        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuList(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuList(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuList(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuList(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 음료 메뉴 생성
        Menu drinkMenu = new Menu("Drinks");
        drinkMenu.addMenuList(new MenuItem("Coke", 2.0, "시원한 콜라"));
        drinkMenu.addMenuList(new MenuItem("Cider", 2.0, "시원한 사이다"));

        // 디저트 메뉴 생성
        Menu dessertMenu = new Menu("Desserts");
        dessertMenu.addMenuList(new MenuItem("Ice Cream", 1.5, "달콤한 바닐라 아이스크림"));

        // Kiosk에 메뉴 추가
        Kiosk kiosk = new Kiosk();
        kiosk.addMenu(burgerMenu);
        kiosk.addMenu(drinkMenu);
        kiosk.addMenu(dessertMenu);

        // 키오스크 실행
        kiosk.start();
    }
}
