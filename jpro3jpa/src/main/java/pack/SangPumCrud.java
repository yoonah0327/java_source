package pack;

import java.util.List;

import domain.SangpumTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class SangPumCrud {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		
		// EntityManager : thread 단위로 작업
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		// 자료추가
		/*try {
			transaction.begin();
			SangpumTable sangtab = new SangpumTable(6, "도시락", 3, 6000);
			em.persist(sangtab);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("ins err: "+ e);
			transaction.rollback();
			return;
		}
		*/
		// 자료 수정
		/*
		try {
			transaction.begin();
			SangpumTable sangtab = em.find(SangpumTable.class, "6"); // 우선 자료를 읽어와야한다
			if(sangtab == null) {
				System.out.println("해당 자료 없음");
			} else {
				String newName = "마스크"; // 자료 수정
				sangtab.setSang(newName);  // 자료 밀어주기 
				transaction.commit(); // 업데이트
			}
		} catch (Exception e) {
			System.out.println("up err: "+e);
			transaction.rollback();
			return;
		}
		*/
		// 자료 삭제
		try {
			transaction.begin();
			
			int findCode = 6;
			SangpumTable sangtab = em.find(SangpumTable.class, findCode); // 자료읽기
			if(sangtab == null) {
				System.out.println("해당 자료 없음");
				transaction.rollback();
			} else {
				em.remove(sangtab); // 읽어둔자료 제거
				System.out.printf("자료 삭제됨: %s", findCode);
				transaction.commit(); 
			}
		} catch (Exception e) {
			System.out.println("del err: "+ e);
			transaction.rollback();
			return;
		}
		
		// JPA를 사용한 DML 처리
		try {
			System.out.println("전체 자료 읽기1");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<SangpumTable> query = cb.createQuery(SangpumTable.class);
			
			// 조회의 시작점을 의미하는 root 객체 생성 
			Root<SangpumTable> root = query.from(SangpumTable.class);
			query.select(root);
			List<SangpumTable> resultList = em.createQuery(query).getResultList();
			
			for(SangpumTable st: resultList) {
				System.out.println(st.getCode()+ " "+ st.getSang()+ " "+
						st.getSu()+ " "+ st.getDan());
			}
			
			System.out.println("\n전체 자료 읽기2"); // jpql? 
			// TypedQuery를 이용해 JPQL 사용
			/*
			TypedQuery<SangpumTable> queryq1 = em.createQuery("select s from SangpumTable s", SangpumTable.class);
			// 이건 sql아님! jpql임!
			List<SangpumTable> list = queryq1.getResultList();
			*/
			// 위 두 줄을 한줄로 표현
			List<SangpumTable> list = em.createQuery("select s from SangpumTable s", SangpumTable.class).getResultList();
			for(SangpumTable st: list) {
				System.out.println(st.getCode()+ " "+ st.getSang()+ " "+
						st.getSu()+ " "+ st.getDan());
			}
			
			System.out.println("\n부분 자료 읽기1");
			int findId = 1 ; // String으로 해도 괜찮음! pk칼럼이 대상
			SangpumTable sangtab = em.find(SangpumTable.class, findId);
			if(sangtab == null) {
				System.out.println("자료없음");
			} else {
				System.out.printf("%s %s %s %s \n", sangtab.getCode(), sangtab.getSang(), sangtab.getSu(), sangtab.getDan() );
			}
			
			System.out.println("\n부분 자료 읽기2");
			TypedQuery<SangpumTable> typedQuery = em.createQuery(query.where(cb.equal(root.get("sang"), "장갑")));
			List<SangpumTable> resultList2 = typedQuery.getResultList();
			for(SangpumTable sangtab2: resultList2) {
				System.out.printf("%s %s %s %s \n", 
						sangtab2.getCode(), sangtab2.getSang(), sangtab2.getSu(), sangtab2.getDan() );
			}
		} catch (Exception e) {
			System.out.println("err: " +e);
		} finally {
			em.close();
			emf.close(); // entity는 필수!  
		}

	}

}
