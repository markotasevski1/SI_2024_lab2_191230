package org.example;

import java.util.List;

class Item {
    String name;
    String barcode; //numerical
    int price;
    float discount;

    public Item(String name, String code, int price, float discount) {
        this.name = name;
        this.barcode = code;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getPrice() {
        return price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBarcode(String code) {
        this.barcode = code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){
        if (allItems == null){ // 1
            throw new RuntimeException("allItems list can't be null!"); // 3
        }

        float sum = 0; // 2

        for (int i = 0; i < allItems.size(); i++){ // 4
            Item item = allItems.get(i);
            if (item.getName() == null || item.getName().length() == 0){ // 5
                item.setName("unknown"); // 6
            }
            if (item.getBarcode() != null){ // 7
                String allowed = "0123456789"; // 8
                char chars[] = item.getBarcode().toCharArray();//9
                for (int j = 0; j < item.getBarcode().length(); j++){ // 10
                    char c = item.getBarcode().charAt(j); // 11
                    if (allowed.indexOf(c) == -1){ //12
                        throw new RuntimeException("Invalid character in item barcode!"); // 13
                    }
                }
                if (item.getDiscount() > 0){ //14
                    sum += item.getPrice()*item.getDiscount(); // 15
                }
                else { //16
                    sum += item.getPrice();
                }
            }
            else { //17
                throw new RuntimeException("No barcode!");
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){ //18
                sum -= 30;
            }
        }
        if (sum <= payment){ //19
            return true;
        }
        else { //20
            return false;
        }
    }
}