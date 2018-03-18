package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.internousdev.alatanapizza.dto.ProductSearchDTO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.internousdev.alatanapizza.util.DBConnector;


/**
 * @author internousdev
 * @author kei-kenmochi
 *
 */
public class ProductSearchDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();


	/**
	 * 全ての商品を検索
	 *
	 * @return ProductsearchDTOList
	 */
//	public ArrayList<ProductSearchDTO> allProductInfo() {
	public ArrayList<ProductDTO> allProductInfo() {
//		ArrayList<ProductSearchDTO> searchDTOList = new ArrayList<ProductSearchDTO>();
		ArrayList<ProductDTO> searchDTOList = new ArrayList<ProductDTO>();
		String sql = "SELECT * FROM product_info";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
//				ProductSearchDTO searchDTO = new ProductSearchDTO();
				ProductDTO dto = new ProductDTO();
				dto.setId(rs.getInt("id"));
	             dto.setProduct_id(rs.getInt("product_id"));
	             dto.setProduct_name(rs.getString("product_name"));
	             dto.setProduct_name_kana(rs.getString("product_name_kana"));
	             dto.setProduct_description(rs.getString("product_description"));
	             dto.setCategory_id(rs.getInt("category_id"));
	             dto.setMsize_price(rs.getInt("msize_price"));
	             dto.setLsize_price(rs.getInt("lsize_price"));
	             dto.setPrice(rs.getInt("price"));
	             dto.setImage_file_path(rs.getString("image_file_path"));
	             dto.setImage_file_name(rs.getString("image_file_name"));
	             dto.setRelease_date(rs.getString("release_date"));
	             dto.setRelease_company(rs.getString("release_company"));
	             dto.setRegist_date(rs.getDate("regist_date"));
	             dto.setUpdate_date(rs.getDate("update_date"));
	             dto.setStock(rs.getInt("stock"));
	             searchDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}



	/**
	 *商品を検索(カテゴリー「全ての商品」を選んだ場合)
	 *
	 * @param serchWord
	 * @return searchDTOList
	 */
	public ArrayList<ProductDTO> bySearchWordAllCategory(String searchWordHiragana, String searchWord) {
		ArrayList<ProductDTO> searchDTOList = new ArrayList<ProductDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String searchWordLike = "%" + searchWord + "%";
		String searchWordHiraganaLike = "%" + searchWordHiragana + "%";

		  String sql = "SELECT * FROM product_info WHERE product_name LIKE ?"
		  		+ " OR product_name_kana LIKE ?"
		  		+ " OR product_description LIKE ?";

//	       String sql = "SELECT * FROM product_info WHERE product_name LIKE \'%" + searchWord + "%\'"
//					+ " OR product_name_kana LIKE \'%" + searchWordHiragana + "%\'"
//						+ " OR product_description LIKE \'%" + searchWord + "%\'"
//						+ " AND category_id=\'" + categoryId + "\'";


		try {
//			String sql = "SELECT * FROM product_info WHERE product_name LIKE \'%" + searchWord + "%\' OR product_name_kana LIKE \'%"
//					+ searchWordHiragana + "%\' OR product_description LIKE \'%" + searchWord + "%\'";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, searchWordLike);
			ps.setString(2, searchWordHiraganaLike);
			ps.setString(3, searchWordLike);
//			if (categoryId != 1) {
//				ps.setInt(4, categoryId);
//			}
			ResultSet rs = ps.executeQuery();
			System.out.println(ps);
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setId(rs.getInt("id"));
	             dto.setProduct_id(rs.getInt("product_id"));
	             dto.setProduct_name(rs.getString("product_name"));
	             dto.setProduct_name_kana(rs.getString("product_name_kana"));
	             dto.setProduct_description(rs.getString("product_description"));
	             dto.setCategory_id(rs.getInt("category_id"));
	             dto.setMsize_price(rs.getInt("msize_price"));
	             dto.setLsize_price(rs.getInt("lsize_price"));
	             dto.setPrice(rs.getInt("price"));
	             dto.setImage_file_path(rs.getString("image_file_path"));
	             dto.setImage_file_name(rs.getString("image_file_name"));
	             dto.setRelease_date(rs.getString("release_date"));
	             dto.setRelease_company(rs.getString("release_company"));
	             dto.setRegist_date(rs.getDate("regist_date"));
	             dto.setUpdate_date(rs.getDate("update_date"));
	             dto.setStock(rs.getInt("stock"));
	             searchDTOList.add(dto);

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return searchDTOList;

	}


	/*
	 * 商品を検索（「全ての商品」以外を指定した場合)
	 */
	public ArrayList<ProductDTO> bySearchWord(String searchWordHiragana, String searchWord, int categoryId) {
		ArrayList<ProductDTO> searchDTOList = new ArrayList<ProductDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		  String sql = "SELECT * FROM product_info WHERE (product_name LIKE \'%" + searchWord + "%\'"
		  		+ " OR product_name_kana LIKE \'%" + searchWordHiragana + "%\'"
		  				+ " OR product_description LIKE \'%" + searchWord + "%\')"
		  				+ " AND category_id=?";

		try {
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, searchWord);
//			ps.setString(2, searchWordHiragana);
//			ps.setString(3, searchWord);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setId(rs.getInt("id"));
	             dto.setProduct_id(rs.getInt("product_id"));
	             dto.setProduct_name(rs.getString("product_name"));
	             dto.setProduct_name_kana(rs.getString("product_name_kana"));
	             dto.setProduct_description(rs.getString("product_description"));
	             dto.setCategory_id(rs.getInt("category_id"));
	             dto.setMsize_price(rs.getInt("msize_price"));
	             dto.setLsize_price(rs.getInt("lsize_price"));
	             dto.setPrice(rs.getInt("price"));
	             dto.setImage_file_path(rs.getString("image_file_path"));
	             dto.setImage_file_name(rs.getString("image_file_name"));
	             dto.setRelease_date(rs.getString("release_date"));
	             dto.setRelease_company(rs.getString("release_company"));
	             dto.setRegist_date(rs.getDate("regist_date"));
	             dto.setUpdate_date(rs.getDate("update_date"));
	             dto.setStock(rs.getInt("stock"));
	             searchDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}

	/**
	 * カテゴリのみで検索
	 *
	 * @param categoryId
	 * @return searchDTOList
	 */
	public ArrayList<ProductDTO> byProductCategory(int categoryId) {
		ArrayList<ProductDTO> searchDTOList = new ArrayList<ProductDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT*FROM product_info WHERE category_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductDTO dto= new ProductDTO();
				dto.setId(rs.getInt("id"));
	             dto.setProduct_id(rs.getInt("product_id"));
	             dto.setProduct_name(rs.getString("product_name"));
	             dto.setProduct_name_kana(rs.getString("product_name_kana"));
	             dto.setProduct_description(rs.getString("product_description"));
	             dto.setCategory_id(rs.getInt("category_id"));
	             dto.setMsize_price(rs.getInt("msize_price"));
	             dto.setLsize_price(rs.getInt("lsize_price"));
	             dto.setPrice(rs.getInt("price"));
	             dto.setImage_file_path(rs.getString("image_file_path"));
	             dto.setImage_file_name(rs.getString("image_file_name"));
	             dto.setRelease_date(rs.getString("release_date"));
	             dto.setRelease_company(rs.getString("release_company"));
	             dto.setRegist_date(rs.getDate("regist_date"));
	             dto.setUpdate_date(rs.getDate("update_date"));
	             dto.setStock(rs.getInt("stock"));
	             searchDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}



	/*
	 * 複数検索
	 */
	public ArrayList<ProductDTO> byWords(String[] serchWords, String[] keywords, int categoryId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ProductDTO> searchDTOList = new ArrayList<ProductDTO>();
		String sql = "SELECT * FROM product_info WHERE ";

		for (int s = 0; s < serchWords.length; s++) {
			if (s != 0) {
				sql = sql + " AND (product_name LIKE '%" + keywords[s] + "%' OR product_name_kana LIKE '%"
						+ serchWords[s] + "%' OR product_description LIKE '%" + keywords[s] + "%') ";

			} else {
				sql = sql + " (product_name LIKE '%" + keywords[s] + "%' OR product_name_kana LIKE '%"
			                  + serchWords[s]+ "%' OR product_description LIKE '%" + keywords[s] + "%') ";

			}
		}

		if (categoryId > 1) {
			sql = sql + "AND category_id=?";
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if (categoryId > 1) {
				ps.setInt(1, categoryId);
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductDTO dto= new ProductDTO();
				dto.setId(rs.getInt("id"));
	             dto.setProduct_id(rs.getInt("product_id"));
	             dto.setProduct_name(rs.getString("product_name"));
	             dto.setProduct_name_kana(rs.getString("product_name_kana"));
	             dto.setProduct_description(rs.getString("product_description"));
	             dto.setCategory_id(rs.getInt("category_id"));
	             dto.setMsize_price(rs.getInt("msize_price"));
	             dto.setLsize_price(rs.getInt("lsize_price"));
	             dto.setPrice(rs.getInt("price"));
	             dto.setImage_file_path(rs.getString("image_file_path"));
	             dto.setImage_file_name(rs.getString("image_file_name"));
	             dto.setRelease_date(rs.getString("release_date"));
	             dto.setRelease_company(rs.getString("release_company"));
	             dto.setRegist_date(rs.getDate("regist_date"));
	             dto.setUpdate_date(rs.getDate("update_date"));
	             dto.setStock(rs.getInt("stock"));
	             searchDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}

	/*
	 * 複数検索(「全ての商品」を選んだ場合)
	 */
	public ArrayList<ProductDTO> byWordsAllCategory(String[] serchWords, String[] keywords) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ProductDTO> searchDTOList = new ArrayList<ProductDTO>();
		String sql = "SELECT * FROM product_info WHERE ";

		for (int s = 0; s < serchWords.length; s++) {
			if (s != 0) {
				sql = sql + " AND (product_name LIKE '%" + keywords[s] + "%' OR product_name_kana LIKE '%"
						+ serchWords[s] + "%' OR product_description LIKE '%" + keywords[s] + "%') ";

			} else {
				sql = sql + " (product_name LIKE '%" + keywords[s] + "%' OR product_name_kana LIKE '%"
			                  + serchWords[s]+ "%' OR product_description LIKE '%" + keywords[s] + "%') ";

			}
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductDTO dto= new ProductDTO();
				dto.setId(rs.getInt("id"));
	             dto.setProduct_id(rs.getInt("product_id"));
	             dto.setProduct_name(rs.getString("product_name"));
	             dto.setProduct_name_kana(rs.getString("product_name_kana"));
	             dto.setProduct_description(rs.getString("product_description"));
	             dto.setCategory_id(rs.getInt("category_id"));
	             dto.setMsize_price(rs.getInt("msize_price"));
	             dto.setLsize_price(rs.getInt("lsize_price"));
	             dto.setPrice(rs.getInt("price"));
	             dto.setImage_file_path(rs.getString("image_file_path"));
	             dto.setImage_file_name(rs.getString("image_file_name"));
	             dto.setRelease_date(rs.getString("release_date"));
	             dto.setRelease_company(rs.getString("release_company"));
	             dto.setRegist_date(rs.getDate("regist_date"));
	             dto.setUpdate_date(rs.getDate("update_date"));
	             dto.setStock(rs.getInt("stock"));
	             searchDTOList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}
}