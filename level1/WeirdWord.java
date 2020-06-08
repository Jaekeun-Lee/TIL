package programmers.level1;

public class WeirdWord {
	public String solution(String s) {
        String answer = "";
        s = s.toLowerCase();               // 다 소문자로 변환
        String tmp[] = s.split(" ",-1);       // 공백 기준으로 나누어 tmp 배열에 저장
        for(int i = 0;i < tmp.length; i++) {
            String s2 = tmp[i];
            if(s2.equals(" ")) continue;
            for(int index = 0; index < s2.length(); index++) {
                if(index % 2 == 0) {
                    answer += (s2.charAt(index)+"").toUpperCase();   
                    continue;
                }
                else{
                    answer += (s2.charAt(index)+"").toLowerCase();
                }
            }
            answer += " ";
        }
        answer = answer.substring(0, answer.length()-1);
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
