import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ok", "ok");
		Main tmp = new Main();
		Map<String, String> test1 = tmp.test(map);
		System.out.println(test1);
		tmp.test2(test1);
	}
	
	public Map<String, String> test(Map<String, String> map){
		map = new HashMap<String, String>();
		map.put("test", "test");
		return map;
	}
	
	public void test2(Map<String, String> map){
		map.put("test", "test");
	}
	
}
