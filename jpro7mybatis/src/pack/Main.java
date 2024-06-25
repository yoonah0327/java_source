package pack;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		ProcessDao dao = ProcessDao.getInstance();//싱글톤패턴
		
		try {
			// MyBatis framework 사용
			/*
			System.out.println("sangdata 추가");
			DataDto dataDto = new DataDto();
			dataDto.setCode("100");
			dataDto.setSang("바나나");
			dataDto.setSu("5");
			dataDto.setDan("5000");
			
			dao.insData(dataDto); 
			//commit 안썼을때 콘솔창확인해보면 안들어간것을 확인가. 
			//그이유: 수동이기에. 따라서 수동일경우 commit 요. 
			*/
			/*
			System.out.println("sangdata 수정");
			DataDto dataDto = new DataDto();
			dataDto.setCode("100");
			dataDto.setSang("뚱바");
			dataDto.setSu("7"); //update sangdata set sang=#{sang} where code=#{code}
			
			dao.upData(dataDto); 
			*/
			System.out.println("sangdata 삭제");
			boolean b = dao.delData(100);
			
			if(b) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			System.out.println("sangdata 전체자료 읽기");
			List<DataDto> list = dao.selectDataAll();
			System.out.println(list.size());
			
			for(DataDto s:list) {
				System.out.println(s.getCode()+ " "+s.getSang()+ " "+s.getSu()+ " "+s.getDan()+ " ");
				
			}
			
			System.out.println("\nsangdata 전체자료 읽기");
			DataDto dto = dao.selectPart("1");
			System.out.println(dto.getCode()+ " "+dto.getSang()+ " "+dto.getSu()+ " "+dto.getDan()+ " ");
			
		} catch (Exception e) {
			System.out.println("err: "+ e.getMessage());
		}
		
		

	}

}
