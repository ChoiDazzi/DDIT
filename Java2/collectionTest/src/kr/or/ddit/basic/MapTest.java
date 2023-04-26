package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		
		/*
		 * Map		=> key 값과 value값을 한 쌍으로 관리하는 객체 
		 * 				   	  key값은 중복을 허용하지 않고 순서가 없다. (Set의 특징을 갖는다)
		 * 					  value값은 중복을 허용한다. 
		 * */
		HashMap<String, String> map = new HashMap<>();
		
		//자료 추가 => put(key값, value값)
		map.put("name", "신짱구");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map => " + map);
		
		//자료 수정 => 데이터를 추가할 때 'key값'이 같으면 나중에 추가한 값이 저장된다. 
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		//자료 읽기 => get(key값) 
		//			   => 주어진 'key값'과 짝이 되는 'value'값을 반환한다. 
		
		System.out.println("이름: " + map.get("name"));
		System.out.println("별명: " + map.get("alias")); //null값 나옴 
		
		//자료 삭제 => remover(key값)
		//			   => 주어진 'key값'이 같은 자료를 찾아서 삭제한다. 
		//				=> 반환값: 삭제된 자료의 'value값'이 반환된다. 
		
		String removeTel = map.remove("tel");
		System.out.println("삭제된 데이터: " + removeTel);
		System.out.println("삭제 후 map: " + map);

		map.put("tel", "010-1234-5678");
		
		//key값이 존재하는지 여부를 나타내는 메서드 : containsKey(key값) 
		//=> 해당 'key값'이 있으면 true, 없으면 false 반환 
		
		System.out.println("tel 키 값의 존재 여부: " + map.containsKey("tel"));
		System.out.println("alias 키 값의 존재 여부: " + map.containsKey("alias"));
		System.out.println("==================================");
		//---------------------------------------------------------------------------------
		// Map에 저장된 모든 데이터를 읽어와서 사용하는 방법 
		//1. 방법1: Map의 모든 key값으 읽어와 사용하는 방법 => keySet()메서드 이용하기 
		
		//keySet()메서드 => Map의 모든 key값들을 Set형으로 반환한다. 
		
		Set<String> keySet = map.keySet();
		
		// 방법 1-1 : Iterator 이용하기
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next(); //key 값 구하기 
			String value = map.get(key);
			System.out.println(key+ " : " + value);			
		}
		System.out.println("==================================");
		//방법 1-2 : 향상된 for문 사용하기 
		for (String key2 : keySet) {
			String value2 = map.get(key2);
			System.out.println(key2 + " : " + value2);
		}
		
		//방법2: value값만 읽어와서 처리하기 
		//			=> values()메서드를 이용한다. 
		for (String value3 : map.values()) {
			System.out.println(value3);
		}
		System.out.println("==================================");
		
		//key값은 번호(int)로 하고 value값은 Member의 인스턴스로 하는 Map객체 생성하기  
		HashMap<Integer, Member> memberMap = new HashMap<>();
		memberMap.put(1, new Member(1,"신짱구","010-1234-5678"));
		
		Member mem = new Member(2, "이훈이", "010-2345-6789");
		memberMap.put(2, mem);
		
		System.out.println("map의 개수: " + memberMap.size());
		System.out.println("memberMap => " + memberMap);
		
		
	}
}
