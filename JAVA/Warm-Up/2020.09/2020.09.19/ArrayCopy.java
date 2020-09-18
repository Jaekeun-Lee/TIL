package bitcamp015;

import java.util.Vector;

public class ArrayCopy {

	public static Vector<String> moveToVector(String [] datas){
		Vector<String> vc = new Vector<String>(datas.length-1);
		
		//역순으로 저장하기
		for(int i = datas.length-1;i>=0; i--) {
			vc.add(datas[i]);
		}
		
		//순서대로 저장하고 뒤집기
		
		return vc;
	}
	public static void main(String[] args) {
		String [] datas = {"1","2","3","4","5"};
		System.out.println(moveToVector(datas));
	}

}
