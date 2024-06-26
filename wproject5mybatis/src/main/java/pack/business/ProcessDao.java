package pack.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pack.business.DataDto;
import pack.mybatis.SqlMapConfig;

public class ProcessDao {
	// 필요없어서 뺌. (jpro7mybatis와 다른점)
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectDataAll() throws SQLException{
		SqlSession sqlSession = factory.openSession(); //세션열기
		List list = sqlSession.selectList("selectDataAll");
		sqlSession.close();//세션닫기
		return list;
	}
	public DataDto selectPart(String para) throws SQLException{
		SqlSession sqlSession = factory.openSession(); //세션열기
		DataDto dto = sqlSession.selectOne("selectDataById", para);
		sqlSession.close();//세션닫기
		return dto;
	}
	
	public void insData(DataForm form) throws SQLException{
		SqlSession sqlSession = factory.openSession(); //transation 수동처리
		sqlSession.insert("insertData", form);
		sqlSession.commit(); //수동! 커밋이라고 적어야 적은값이 반영되어 콘솔창에 뜬다.
		sqlSession.close();//세션닫기
		
	}
	
	public void upData(DataForm form) throws SQLException{
		SqlSession sqlSession = factory.openSession(true); //transation 자동처리. 상단과 달리 commit 불요.
		sqlSession.insert("updateData", form);
		sqlSession.close();//세션닫기
	}
	
	//void일때 반환값없어서 개발자 확인이 어렵. del는 보이게 해보자. boolean, int 등 자유롭게 가.
	public boolean delData(int para) {
		boolean result = false;
		SqlSession sqlSession = factory.openSession();
		
		try {
			int cou = sqlSession.delete("deleteData", para);
			if(cou > 0) result = true;
			
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("delData err: "+ e);
			sqlSession.rollback();
		}finally {
			if(sqlSession != null) sqlSession.close();
		}
		return result;
	}
}
