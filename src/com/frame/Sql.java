package com.frame;

public class Sql {
	// static : ������ ���� �ʰ� ���ÿ� ����Ŭ�������� ����Ҽ� �ִ� �����϶� ���
	public static String insertUser = "INSERT INTO TB_USER VALUES (?,?,?)";
	public static String updateUser = "UPDATE TB_USER SET PWD =? , NAME = ? WHERE ID = ?";
	public static String deleteUser = "DELETE FROM TB_USER WHERE ID = ?";
	public static String selectAllUser = "SELECT * FROM TB_USER";
	public static String selectUser = selectAllUser+" WHERE ID = ?";
	
	public static String insertpro = "INSERT INTO TB_PRODUCT VALUES (?,?,?)";
	public static String updatepro = "UPDATE TB_PRODUCT "
	         + " SET NAME = ?, PRICE = ? "
	         + " WHERE ID = ?";
	public static String deletetpro = "DELETE FROM TB_PRODUCT WHERE ID = ?";
    public static String selectAllpro = "SELECT * FROM TB_PRODUCT"
	         + " ORDER BY ID";
    public static String selectpro = "SELECT * FROM TB_PRODUCT"
	         + " WHERE ID = ?";
	
}
