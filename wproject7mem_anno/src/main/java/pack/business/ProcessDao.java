package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.business.DataDto;
import pack.mybatis.SqlMapConfig;

public class ProcessDao implements Processinter{
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<DataDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<DataDto> list = null;
		
		try {
			SqlMapperinter inter = (SqlMapperinter)sqlSession.getMapper(SqlMapperinter.class);
			list = inter.selectDataAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err: "+e);
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
	@Override
	public DataDto selectPart(String id) {
		SqlSession sqlSession = factory.openSession();
		DataDto dto = null;
		
		try {
			SqlMapperinter inter = (SqlMapperinter)sqlSession.getMapper(SqlMapperinter.class);
			dto = inter.selectDataPart(id);
		} catch (Exception e) {
			System.out.println("selectPart err: "+e);
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return dto;
	}
	@Override
	public boolean insertData(DataFormBean form) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		
		try {
			SqlMapperinter inter = (SqlMapperinter)sqlSession.getMapper(SqlMapperinter.class);
			if(inter.insertData(form) >0) b=true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("insertData err: "+e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	@Override
	public boolean updateData(DataFormBean form) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		
		try {
			SqlMapperinter inter = (SqlMapperinter)sqlSession.getMapper(SqlMapperinter.class);
			
			// 비밀번호 비교후 수정여부판단
			DataDto dto = inter.selectDataPart(form.getId());
			if(dto.getPasswd().equals(form.getPasswd())) {//디비비번 =? 클라이언트가입력한비번 
				//수정처리
				if(inter.updateData(form) > 0) {
					b = true;
					sqlSession.commit();
				}
				
			}
		} catch (Exception e) {
			System.out.println("updateData err: "+e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
	@Override
	public boolean deleteData(String id) {
		boolean b = false;
		SqlSession sqlSession = factory.openSession();
		
		try {
			SqlMapperinter inter = (SqlMapperinter)sqlSession.getMapper(SqlMapperinter.class);
			
			int cou = inter.deleteData(id);
			if(cou >0 ) b = true;
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("deleteData err: "+e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return b;
	}
}
