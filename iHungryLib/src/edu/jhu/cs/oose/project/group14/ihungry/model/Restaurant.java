package edu.jhu.cs.oose.project.group14.ihungry.model;

/**
 * One subclass of Person
 * 
 * @author group14
 * 
 */

public class Restaurant extends Person {

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String id, String name, ContactInfo ci) {
		super(id, name, ci);
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String id, String name, ContactInfo ci, Menu menu) {

	}

	public Restaurant(String id, String name, ContactInfo ci, Menu menu,
			Album album) {

	}

	public Menu getMenu() {
		return null;
	}
	
	public Album getAlbum(){
		return null;
	}
}
