package com.ahead.dao;

import java.util.List;

import com.ahead.bean.Tiaojian;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ahead.bean.Goods;

public interface GoodsDao {
	@Select("select *from goods")
	public List<Goods> SelectAll();
	@Select("select * from goods where typesId =#{0}")
	public List<Goods> SelectByTypes(int typesId);

	@Select("select*from goods where name like #{0}")
	public List<Goods> SelectByName(String name);

	//假定一页显示4条数据
//SELECT * FROM goods LIMIT (页数-1)*每页显示的数量，每页显示的数量
	@Select("SELECT * FROM goods limit #{row},#{nums}")
	public List<Goods> SelectByPage(@Param("row")int row, @Param("nums")int nums);
//查询总共有多少行数据
//@Select("select count(id) from goods")
//public int SelectMaxRow();

	//asc升序 desc降序
	@Select("<script>select*from goods order by price <if test='isdesc==1'>desc</if></script> ")//动态SQL
	public List<Goods> SelectOrder(@Param("isdesc")int isdesc);//0表示升序，1表示降序

	//用户需要使用的查询条件，查询才有（SQL语句会根据条件的变化而变化）
	@Select("<script>"
			+ "select * from Goods where 1=1"
			+"<if test='tj.name!=null and tj.name!=\"\"'> and name like #{tj.name} </if>"
			+"<if test='tj.typesId!=null'> and typesId = #{tj.typesId} </if>"
			+ "<if test='tj.isDesc!=null'> order by price </if>"
			+ "<if test='tj.isDesc==1'> desc </if>"
			+" limit #{tj.row},#{tj.nums}"
			+"</script>")
	public List<Goods> Select (@Param("tj") Tiaojian tj);

	@Select("<script>"
			+ "select count(id) from Goods where 1=1"
			+"<if test='tj.name!=null and tj.name!=\"\"'> and name like #{tj.name} </if>"
			+"<if test='tj.typesId!=null'> and typesId = #{tj.typesId} </if>"

			+"</script>")
	public int SelectMaxRow(@Param("tj")Tiaojian tj);//查询总共有多少行数据

}