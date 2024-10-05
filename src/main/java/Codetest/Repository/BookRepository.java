package Codetest.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Codetest.Model.BookBean;





public class BookRepository {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	
	public int insertBook(BookBean book) throws Exception {
		String sql = "INSERT INTO book(name, price, quantity) VALUES (? , ?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, book.getName());
			ps.setDouble(2, book.getPrice());
			ps.setInt(3, book.getQuantity());
			return ps.executeUpdate();
		}catch(Exception e) {
			System.out.println("Book Insert Error: " + e.getMessage());
			throw e;
		}
	}
		
	

	public List<BookBean> getAll(){
		List<BookBean> books = new ArrayList<BookBean>();
		
		String sql = "SELECT * FROM book";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BookBean book = new BookBean();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				books.add(book);
			}
		}catch(Exception e) {
			System.out.println("Book Display Error: " + e.getMessage());
		}
		
		return books;
	}
	    
	    public int editBook(BookBean book) {
			int result = 0;
			String sql ="UPDATE book SET name = ? , price = ? , quantity = ? WHERE id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, book.getName());
				ps.setDouble(2, book.getPrice());
				ps.setInt(3, book.getQuantity());
				ps.setInt(4 , book.getId());
				result = ps.executeUpdate();		
				
			}catch(Exception e) {
				result = 0;
				System.out.println("Book Edit Error: " + e.getMessage());
			}
			
			return result;
		}
		
	    public int softdeleteBook(int id) {
			int result = 0;
			String sql ="UPDATE book SET is_delete = 1 WHERE id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				//ps.setBoolean(1, book.is_delete());
				
				ps.setInt(1 , id);
				result = ps.executeUpdate();		
				
			}catch(Exception e) {
				result = 0;
				System.out.println("Book Edit Error: " + e.getMessage());
			}
			
			return result;
		}
	    
	    public List<BookBean> getDeletedBooks() {
	        List<BookBean> books = new ArrayList<BookBean>();
	        String sql = "SELECT * FROM book WHERE is_delete = 1"; // Fetch only deleted books
	        try {
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                BookBean book = new BookBean();
	                book.setId(rs.getInt("id"));
	                book.setName(rs.getString("name"));
	                book.setPrice(rs.getDouble("price"));
	                book.setQuantity(rs.getInt("quantity"));
	                books.add(book);
	            }
	        } catch (Exception e) {
	            System.out.println("Error fetching deleted books: " + e.getMessage());
	        }
	        return books;
	    }
	    public int restoreBook(int id) {
	        int result = 0;
	        String sql = "UPDATE book SET is_delete = 0 WHERE id = ?"; // Restore the book by setting is_delete to 0
	        try {
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            result = ps.executeUpdate(); // Execute the update query
	        } catch (Exception e) {
	            System.out.println("Book Restore Error: " + e.getMessage());
	        }
	        return result;
	    }

	    
	    public BookBean getById(int id) {
			BookBean book = null;
			String sql = "SELECT * FROM book WHERE id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					book = new BookBean();
					book.setId(rs.getInt("id"));
					book.setName(rs.getString("name"));
					book.setPrice(rs.getDouble("price"));
					book.setQuantity(rs.getInt("quantity"));
				}
			}catch(Exception e) {
				System.out.println("Book Get By One Error: " + e.getMessage());
			}
			
			return book;
		}
	    public List<BookBean> getBookAll(){
			List<BookBean> books = new ArrayList<BookBean>();
			
			String sql = "SELECT * FROM book where is_delete = false";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					BookBean book = new BookBean();
					book.setId(rs.getInt("id"));
					book.setName(rs.getString("name"));
					book.setPrice(rs.getDouble("price"));
					book.setQuantity(rs.getInt("quantity"));
					books.add(book);
				}
			}catch(Exception e) {
				System.out.println("Book Display Error: " + e.getMessage());
			}
			
			return books;
		}
	}

