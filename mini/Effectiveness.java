package project1st;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Effectiveness {
	// �ѱ��� or ���� �˻��
	public boolean isAlphaNumeric(String name) {
		boolean err = false;
		String regex = "[a-zA-Z��-�R]*$";   
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		if(m.matches()) {
			err = true; 
		}
		return err;
	}
	
	// ���� ���� �ѱ� 
	public boolean isId(String id) {
		boolean err = false;
		String str = "...";
		String regex = "^[0-9|a-z|A-Z|��-��|��-��|��-�R]*$"; 
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(id);
		if(!(id.replace(" ", "").equals(""))&& m.matches()) {
			err=true;
		}
		return err;
		
	}
	//���� �˻��
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
	
	
	
	//��ȭ��ȣ �˻��
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
	
	//�̸��� �˻��
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
	
	//��¥ �˻��
	public boolean isDate(String checkDate) {
        try {
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy-MM-dd"); //������ ��¥ ���� ����
            dateFormatParser.setLenient(false); //false�ϰ�� ó���� �Է��� ���� �߸��� ������ �� ������ �߻�
            dateFormatParser.parse(checkDate); //��� �� ���˿� ����Ǵ��� Ȯ��
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
}
