package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startGrocery(){
        int choice;
        do {
            System.out.println("Operasyon seçimi yapın. (0 = çıkış, 1 = ekle, 2 = çıkar) ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 :
                    System.out.println("Eklenmesini istediğin elemanı gir");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    printSorted();
                    break;
                case 2 :
                    System.out.println("Çıkarılmasını istediğin elemanı gir");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    printSorted();
                    break;
            }
        }
        while (choice != 0);

        scanner.close();
    }

    public static void removeItems(String itemsToRemove){
        String[] splitItems = itemsToRemove.split(",");
        for(String item: splitItems){
            item = item.trim();
            if(!chechItemsInList(item)){
                System.out.println("Girilen item listede yok: " + item);
            } else {
                groceryList.remove(item);
            }
        }
        sortItems();
    }

    public static void addItems(String itemsToAdd){
        String[] splitItems = itemsToAdd.split(",");
        for(String item : splitItems){
            item = item.trim();
            if(chechItemsInList(item)){
                System.out.println("Girilen item listede var: " + item);
            } else {
                groceryList.add(item);
            }
        }
        sortItems();
    }

    private static boolean chechItemsInList(String item){
        return groceryList.contains(item);
    }

    public static void printSorted(){
        sortItems();
        System.out.println("Pazar listesi: ");
        for(String item: groceryList){
            System.out.println(item);
        }
    }

    private static void sortItems(){
        Collections.sort(groceryList);
    }
}
