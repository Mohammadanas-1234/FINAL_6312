// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/************************************************************/
/**
 * 
 */
public class Genre {

	public Genre(String genreName, String description, int genreId) {
		super();
		this.genreName = genreName;
		this.description = description;
		this.genreId = genreId;
	}

	public Genre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private String genreName;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private int genreId;

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public static List<String> bookGenreList = new ArrayList<>();

	public static void initialzeBookData() {
		bookGenreList.add("horror");
		bookGenreList.add("comics");
		bookGenreList.add("Adventure");
		bookGenreList.add("fantasy");
		bookGenreList.add("Action");
	}

	/**
	 * @param list2
	 * @return IV. A book cannot have more than 5 genres.
	 */
	public boolean getAllBooks(List<Book> bookGenreList) {
		boolean flag = true;
		for (Book book : bookGenreList) {
			if (book.getGenre().size() > 5) {
				flag = false;
			}
		}
		return flag;
	}
}
