package com.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ListSorting {

	private List<Movie> data = new ArrayList<Movie>();
	public List<Movie> getData() {
		return data;
	}
	public ListSorting() {
		MoviesInterface fn = Movie::new;      
		data.add(fn.apply("Test1", "true", "9.1"));
		data.add(fn.apply("Test2", "false", "8.2"));
		data.add(fn.apply("Test3", "true", "8.8"));
		data.add(fn.apply("Test4", "true", "6.6"));
		data.add(fn.apply("Test5", "true", "5.8"));
		data.add(fn.apply("Test6", "false", "4.2"));
		data.add(fn.apply("Test7", "true", "9.0"));
		data.add(fn.apply("Test8", "true", "9.7"));
		data.add(fn.apply("Test9", "true", "5.6"));
		data.add(fn.apply("Test10", "false", "8.7"));
		
	}
	public static void main(String[] args) {
//		
		Supplier<ListSorting> fn = ListSorting::new;
		ListSorting ls = fn.get();
		// comparing first basing on starred and then rating.
		ls.getData().sort(Comparator.comparing(Movie::getStarred).reversed().thenComparing(Movie::getRating)/*.reversed()*/);
		
		Comparator<Movie> comparator = (o1,o2) -> {
			return o1.getRating().compareTo(o2.getRating());
			
		};
		ls.getData().forEach(System.out::println);
		System.out.println("*****************");
		ls.getData().sort(comparator);
		ls.getData().forEach(System.out::println);
		
//		List<String> collect = ls.getData().stream().sorted((s1, s2) -> {
//			
//		}
//				).filter(x->!x.isEmpty()).peek(System.out::println).collect(Collectors.toList());
		
//		ls.getData().forEach(System.out::println);
	}
	interface MoviesInterface {
		Movie apply(String name, String starred, String rating);
	}
	
	class Movie {
		public Movie(String name, String starred, String rating) {
			this.name = name;
			this.starred = starred;
			this.rating = rating;
		}
		public String toString() {
			return name + " " + starred + " " + rating;
		}
		private String name;
		private String starred;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStarred() {
			return starred;
		}
		public void setStarred(String starred) {
			this.starred = starred;
		}
		public String getRating() {
			return rating;
		}
		public void setRating(String rating) {
			this.rating = rating;
		}
		private String rating;
	}

}
