package com.acts;

import java.util.*;
import java.util.List;

public class ShoppingCart {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Item> store = new ArrayList<> ();
		List<Item> cart = new ArrayList<> ();
		
		Item a1 = new Item("Apple" , 80);
		Item a2 = new Item("Shampoo", 150);
		Item a3 = new Item("Milk", 70);
		Item a4 = new Item("Oil",180);
		
		
		store.add(a1);
		store.add(a2);
		store.add(a3);
		store.add(a4);
		
		//System.out.println(store);
		
		
		//menu driven program
		
		int choice=0;
		
		do 
		{
			//displaying items
		for(Item i:store) {
			System.out.println("Press "+i.getItemId() + " for selecting "+ i.getName());
		}
		//stop code
		System.out.println("Press 0 to stop shopping and generate bill");
		
		choice = sc.nextInt();
		
		//adding item in cart
		Item purchasedItem = checkId(choice, store);
		if(purchasedItem != null) {
			cart.add(purchasedItem);
		}
		
		
		
		
		}while(choice !=0 );
		//displaying cart
		//System.out.println(cart);
		
		generateBill(cart);

	}
	
	public static Item checkId(int choice, List<Item> arr) {
		
		Item res = null;
		
		for(Item i: arr) {
			if(i.getItemId() == choice) {
				res = i;
				return res;
			}
		}
		
		return res;
	}
	
	public static void generateBill(List<Item> arr) {
		//Collections.sort(arr);  //attempting sort
		for(Item i : arr) {
			System.out.println(i.getName() + "    " + i.getPrice());
		}
		
		double price = 0.0;
		final double DISCOUNT=0.2;
		final double CGST=0.08;
		
		for(Item i : arr) {
			price += i.getPrice();
		}
		
		double discount = price * DISCOUNT;
		double cgst = price * CGST;
		
		double finalAmt = price + cgst - discount;
		
		String s ="\n*****************************"
				+"\nPrice:          "+price
				+"\nCGST:           "+cgst
				+"\nDiscount:       "+discount
				+"-------------------------------"
				+"\nFinal Amount:   "+finalAmt
				+"\n*****************************";
		
		System.out.println(s);
	}

}
