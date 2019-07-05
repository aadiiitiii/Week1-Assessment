package com.bawarchi.model;

import java.util.Objects;

public class Dish implements Comparable<Dish> {
	private static int counter = 1;
	private int id;
	private String name;
	private double calories;
	private double price;

	public Dish(int id, String name, double price, double calories) {
		this.id = id;
		this.name = name;
		this.calories = calories;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Dish o) {
		return Integer.valueOf(this.id).compareTo(o.id);
	}

	@Override
	public String toString() {
		return ("Dish id: " + this.id + "Name: " + this.name + " Price: " + this.price + " calories: " + this.calories);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other_dish = (Dish) obj;
		if (id != other_dish.id)
			return false;
		return true;
	}

	public void payment(double amount) {
		if (amount > this.price) {
			double change = amount - this.price;
			System.out.println(
					"========Thanks for your order. Please collect the change=Rs" + change + "================");
		} else if (amount == this.price) {
			System.out.println("========Thanks for your order================");
		} else {
			System.out.println("========Amount paid is less than bill================");
		}
	}

}
