package pack4;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex33DtoTest3 {
	private ArrayList<Ex33compDto> dtoto = new ArrayList<Ex33compDto>();

	public void inputData(String datas) { // 에러안뜨게하기위해 주석처리해둠
//		for(int i=0; i< dtoto.length; i++) {
//			StringTokenizer to= new StringTokenizer(dtoto[i], ",");
//			String irum = to.nextToken();
//			int sabun = Integer.parseInt(to.nextToken());
//			int gibon = Integer.parseInt(to.nextToken());
//			int ibsa = Integer.parseInt(to.nextToken());
//			
//			Ex33compDto dd = new Ex33compDto();
//			dd.setIrum(irum);
//			dd.setSabun(sabun);
//			dd.setGibon(gibon);
//			dd.setIbsa(ibsa);
//			dtoto.add(dd);
//		}
	}
	
	public void displaydata() {
		for(Ex33compDto cd: dtoto) {
			int yr= 2024- cd.getIbsa();
			int sudang;
			if (0<= yr && yr <=3) {
				sudang= 150000;
			} else if (4<= 4 && yr <=8) {
				sudang= 450000;
			} else {
				sudang= 100000;
			}
			double ratio;
			if((1500000+sudang) >=3000000) {
				ratio= 0.5;
			} else if((1500000+sudang) >=2000000) {
				ratio= 0.3;
			}else {
				ratio= 0.15;
			}
		int gongje = (1500000+sudang) * (int) ratio;
		int sureong = 1500000 + sudang - gongje;
				
		}
	}
	
	// TODO Auto-generated method stub
	public static void main(String[] args) {
		
	 

	}

}
