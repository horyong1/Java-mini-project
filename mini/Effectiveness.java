package project1st;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Effectiveness {
	// 한국어 or 영어 검사기
	public boolean isAlphaNumeric(String name) {
		boolean err = false;
		String regex = "[a-zA-Z가-힣]*$";   
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		if(m.matches()) {
			err = true; 
		}
		return err;
	}
	
	// 숫자 영어 한글 
	public boolean isId(String id) {
		boolean err = false;
		String str = "...";
		String regex = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$"; 
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(id);
		if(!(id.replace(" ", "").equals(""))&& m.matches()) {
			err=true;
		}
		return err;
		
	}
	//숫자 검사기
	public boolean isNumeric(String Num) {
		boolean err = false;
		String regex = "^[0-9]*$";   
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(Num);
		if(m.matches()) {
			err = true; 
		}
		return err;
	}
	
	
	
	//전화번호 검사기
	public boolean isTel(String tel) {
		boolean err = false;
		String regex = "\\d{3}-\\d{4}-\\d{4}";   
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(tel);
		if(m.matches()) {
			err = true; 
		}
		return err;
	}
	
	//이메일 검사기
	public boolean isValidEmail(String email) {
		  boolean err = false;
		  String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";   
		  Pattern p = Pattern.compile(regex);
		  Matcher m = p.matcher(email);
		  if(m.matches()) {
		   err = true; 
		  }
		  return err;
		 }
	
	//날짜 검사기
	public boolean isDate(String checkDate) {
        try {
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy-MM-dd"); //검증할 날짜 포맷 설정
            dateFormatParser.setLenient(false); //false일경우 처리시 입력한 값이 잘못된 형식일 시 오류가 발생
            dateFormatParser.parse(checkDate); //대상 값 포맷에 적용되는지 확인
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
}
