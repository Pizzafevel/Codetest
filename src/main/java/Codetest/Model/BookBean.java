package Codetest.Model;

import lombok.Data;

@Data
public class BookBean {
	private int id;
	private String name;
	private double price;
	private int quantity;
	private boolean is_delete;
	
}
