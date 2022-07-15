package project1st;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Effectiveness {
	// ÇÑ±¹¾î or ¿µ¾î °Ë»ç±â
	public boolean isAlphaNumeric(String name) {
		boolean err = false;
		String regex = "[a-zA-Z°¡-ÆR]*$";   
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		if(m.matches()) {
			err = true; 
		}
		return err;
	}
	
	// ¼ıÀÚ ¿µ¾î ÇÑ±Û 
	public boolean isId(String id) {
		boolean err = false;
		String str = "...";
		String regex = "^[0-9|a-z|A-Z|¤¡-¤¾|¤¿-¤Ó|°¡-ÆR]*$"; 
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(id);
		if(!(id.replace(" ", "").equals(""))&& m.matches()) {
			err=true;
		}
		return err;
		
	}
	//¼ıÀÚ °Ë»ç±â
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
	
	
	
	//ÀüÈ­¹øÈ£ °Ë»ç±â
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
	
	//ÀÌ¸ŞÀÏ °Ë»ç±â
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
	
	//³¯Â¥ °Ë»ç±â
	public boolean isDate(String checkDate) {
        try {
            SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyy-MM-dd"); //°ËÁõÇÒ ³¯Â¥ Æ÷¸Ë ¼³Á¤
            dateFormatParser.setLenient(false); //falseÀÏ°æ¿ì Ã³¸®½Ã ÀÔ·ÂÇÑ °ªÀÌ Àß¸øµÈ Çü½ÄÀÏ ½Ã ¿À·ù°¡ ¹ß»ı
            dateFormatParser.parse(checkDate); //´ë»ó °ª Æ÷¸Ë¿¡ Àû¿ëµÇ´ÂÁö È®ÀÎ
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
}
