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

public class SangpumCrud {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gojpa");
		
		// EntityManager : thread 단위로 작업
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();	// 트랜잭션 처리가 목적 insert,update,delete에서 필요
		
		// 자료 추가
		/*
		try {
			transaction.begin();
			SangpumTable sangtab = new SangpumTable(5, "냉면", 3, 6000);
			em.persist(sangtab);	// persist하면 추가됨
			transaction.commit();
		} catch (Exception e) {
			System.out.println("insert err : " + e);
			transaction.rollback();
			return;
		}
		*/
		
		// 자료 수정
		/*
		try {
			transaction.begin();
			SangpumTable sangtab = em.find(SangpumTable.class, "5");
			if(sangtab == null) {
				System.out.println("해당 자료 없음");
				transaction.rollback();
			}else {
				String newName = "마스크";
				sangtab.setSang(newName);
				transaction.commit();
			}
		} catch (Exception e) {
			System.out.println("Update err : " + e);
			transaction.rollback();
			return;
		}
		*/
		
		// 자료 삭제
		try {
			transaction.begin();
			
			int findCode = 5;
			SangpumTable sangtab = em.find(SangpumTable.class, findCode);
			if(sangtab == null) {
				System.out.println("해당 자료 없음");
				transaction.rollback();
			}else {
				em.remove(sangtab);
				System.out.printf("자료 삭제됨 : %s", findCode);
				transaction.commit();
			}
		} catch (Exception e) {
			System.out.println("Delete err : " + e);
			transaction.rollback();
			return;
		}
		
		// JPA를 사용한 DML 처리
		try {
			System.out.println("전체 자료 읽기 1");
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<SangpumTable> query = cb.createQuery(SangpumTable.class);
			
			// 조회의 시작점을 의미하는 Root 객체 생성
			Root<SangpumTable> root = query.from(SangpumTable.class);
			query.select(root);   // JPQL?
			List<SangpumTable> resultList = em.createQuery(query).getResultList();

			for(SangpumTable st:resultList) {
				System.out.println(st.getCode() + " " + st.getSang() + " " + 	// SangpumTable의 getter를 갖다 씀
									st.getSu() + " " + st.getDan());
			}
			
			System.out.println("\n전체 자료 읽기 2");
			// TypedQuery를 이용해 JPQL 사용
			
			/*
			TypedQuery<SangpumTable> queryql = em.createQuery("select s from SangpumTable s", SangpumTable.class);
			List<SangpumTable> list = queryql.getResultList();
			*/
			// 위 두줄을 한줄로 표현
			List<SangpumTable> list = em.createQuery("select s from SangpumTable s", SangpumTable.class).getResultList();
			
			for(SangpumTable st:list) {
				System.out.println(st.getCode() + " " + st.getSang() + " " + 	// SangpumTable의 getter를 갖다 씀
									st.getSu() + " " + st.getDan());
			}
			
			System.out.println("\n부분 자료 읽기 1");
			int findId = 1;		// String findId = "1";		pk 칼람이 대상
			SangpumTable sangtab = em.find(SangpumTable.class, findId);
			if(sangtab == null) {
				System.out.println("자료 없음");
			}else {
				System.out.printf("%s %s %s %s\n", 
						sangtab.getCode(), sangtab.getSang(), sangtab.getSu(), sangtab.getDan());
			}
			
			System.out.println("\n부분 자료 읽기 2");
			TypedQuery<SangpumTable> typedQuery = em.createQuery(
					query.where(cb.equal(root.get("sang"), "장갑")));
			List<SangpumTable> resultList2 = typedQuery.getResultList();
			for(SangpumTable sangtab2:resultList2) {
				System.out.printf("%s %s %s %s\n",
						sangtab2.getCode(), sangtab2.getSang(), sangtab2.getSu(), sangtab2.getDan());
			}
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close(); 	// 필수
		}
	}

}
