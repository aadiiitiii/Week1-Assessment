package com.bawarchi.client;

import java.util.*;

import com.bawarchi.comparators.CaloriesGTComparator;
import com.bawarchi.comparators.CaloriesLTComparator;
import com.bawarchi.comparators.PriceGTComparator;
import com.bawarchi.comparators.PriceLTComparator;
import com.bawarchi.model.Dish;

public class Restaurant {

	public static void main(String[] args) {
		List<Dish> list = new ArrayList<>();
		populateData(list);
		System.out.println("=================Welcome======================");
		System.out.println("Please choose from the below options");
		System.out.println("1 => To sort the dishes in the increasing order of calories");
		System.out.println("2 => To sort the dishes in the decreasing order of calories");
		System.out.println("3 => To sort the dishes in the increasing order of price");
		System.out.println("4 => To sort the dishes in the decreasing order of price");
		System.out.println("===============================================");

		Scanner sc = new Scanner(System.in);
		int sortType = sc.nextInt();
		sc.nextLine();
		switch (sortType) {
		case 1: {
			Collections.sort(list, new CaloriesLTComparator());
			break;
		}
		case 2: {
			Collections.sort(list, new CaloriesGTComparator());
			break;
		}
		case 3: {
			Collections.sort(list, new PriceLTComparator());
			break;
		}
		case 4: {
			Collections.sort(list, new PriceGTComparator());
			break;
		}
		}
		Iterator<Dish> it = list.iterator();
		System.out.println("Please select the Dish Id and hit enter");
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
		System.out.println("================================================");
		int orderId = sc.nextInt();
		sc.nextLine();
		Iterator<Dish> it1 = list.iterator();
		Dish orderDish = null;
		while (it1.hasNext()) {
			orderDish = it1.next();
			if (orderDish.getId() == orderId) {
				break;
			}
		}
		System.out.println("You have selected " + orderDish.getName());
		System.out.println("Please enter your name: ");
		String name = sc.nextLine();
		System.out.println("Please pay the bill of " + orderDish.getPrice());
		double amountGiven = sc.nextInt();
		orderDish.payment(amountGiven);
		sc.close();
	}

	public static void populateData(List<Dish> dish) {
		dish.add(new Dish(5, "Neer-Dosa", 50, 100));
		dish.add(new Dish(2, "Idli-Vada", 40, 200));
		dish.add(new Dish(4, "Roti-Curry", 100, 250));
		dish.add(new Dish(1, "Dosa", 50, 300));
		dish.add(new Dish(3, "Pulav", 80, 330));
	}

}
