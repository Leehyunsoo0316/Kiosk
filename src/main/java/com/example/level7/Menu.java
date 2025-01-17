package com.example.level7;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    // 필드
    private String categoryName; // 카테고리
    private List<MenuItem> menuItems = new ArrayList<>(); // 메뉴 리스트

    // 생성자
    public Menu (String categoryName) {
        this.categoryName = categoryName;
    }

    // 메서드
    // 카테고리 getter
    public String getCategoryName () {
        return categoryName;
    }

    // 리스트 getter
    public List<MenuItem> getMenuItems () {
        return menuItems;
    }

    // 카테로리 setter
    public void setCategoryName (String categoryName) {
        this.categoryName = categoryName;
    }

    // 리스트에 메뉴 추가
    public void addMenuList (MenuItem item) {
        menuItems.add(item);
    }

    // 리스트에서 항목 삭제
    public void removeMenuList (int a) {
        menuItems.remove(a);
    }

    // 리스트 초기화
    public void clearMenuList () {
        menuItems.clear();
    }

    // 카테고리 메뉴 출력
    public void openMenu () {
        System.out.println("[ " + getCategoryName().toUpperCase() + " ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i+1) + ". " + menuItems.get(i));
        }
        System.out.println("0. 뒤로가기");
    }
}
