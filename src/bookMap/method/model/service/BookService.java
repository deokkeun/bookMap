package bookMap.method.model.service;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BookService {

	Scanner sc = new Scanner(System.in);
	List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> favorites = new ArrayList<Map<String,Object>>();
	static int count = 0;
	
	public void display() {
		
		int input = 0;
		do {
		
		System.out.println(" - 도서 목록 프로그램 V1 - ");

		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 조회");
		System.out.println("3. 도서 수정");
		System.out.println("4. 도서 삭제");
		System.out.println("5. 즐겨찾기 추가");
		System.out.println("6. 즐겨찾기 취소");
		System.out.println("0. 프로그램 종료");
		
		System.out.print("번호 입력 : ");
		
		try {
			input = sc.nextInt();
		} catch(Exception e) {
			System.out.println("입력이 잘못되었습니다.");
			e.printStackTrace();
		}
		
		switch(input) {
		case 1: addBook(); break;
		case 2: selectBook(); break;
		case 3: updateBook(); break;
		case 4: removeBook(); break;
		case 5: addFavorites(); break;
		case 6: removeFavorites(); break;
		default : System.out.println("번호 번호가 범위안에 없습니다.");;
		}
		
		} while(input != 0);
	}
	
	
	public void addBook() {
		
		System.out.println("\n - 도서 목록 등록 - ");
		
		System.out.print("도서 제목 : ");
		String title = sc.next();
		System.out.print("작가 : ");
		String author = sc.next();
		System.out.print("가격 : ");
		String price = sc.next();
		System.out.print("출판사 : ");
		String publisher = sc.next();
		
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("keyTitle", title);
		map.put("keyAuthor", author);
		map.put("keyPrice", price);
		map.put("keyPublisher", publisher);
		
		if(list.add(map)) {
			System.out.println("도서 목록 등록이 추가되었습니다.\n");
		} else {
			System.out.println("도서 목록 등록이 실패하였습니다.\n");
		}
	}
	
	public void selectBook() {
		System.out.println("\n - 도서 목록 조회 - ");
		
		if(list.isEmpty()) {
			System.out.println("도서 목록이 비어있습니다.");
		} else {
			
			for(Map<String, Object> output : list) {
				System.out.print(output.get("keyTitle") + "  ");
				System.out.print(output.get("keyAuthor") + "  ");
				System.out.print(output.get("keyPrice") + "  ");
				System.out.print(output.get("keyPublisher") + "  ");
				System.out.println();
			}
			System.out.println();
		}
	}
	
	
	public void updateBook() {
		System.out.println("\n - 도서 목록 수정 - ");
		selectBook();
		
		System.out.println("수정을 원하는 도서의 제목을 입력해주세요!");
		System.out.print("제목 : ");
		String name = sc.next();
		
		if(list.isEmpty()) {
			System.out.println("도서 목록이 비어있습니다.");
		} else {
			for(int i = 0; i < list.size(); i++) {
				if(name.equals(list.get(i).get("keyTitle"))) {

					System.out.println("도서 목록 수정을 시작합니다!");
					
					System.out.print("도서 제목 : ");
					String title = sc.next();
					System.out.print("작가 : ");
					String author = sc.next();
					System.out.print("가격 : ");
					String price = sc.next();
					System.out.print("출판사 : ");
					String publisher = sc.next();
					
					Map<String, Object> map = new TreeMap<String, Object>();
					map.put("keyTitle", title);
					map.put("keyAuthor", author);
					map.put("keyPrice", price);
					map.put("keyPublisher", publisher);
					
					Map<String, Object> temp = list.set(i, map);
					System.out.println(temp.get("keyTitle") + "의 도서 내용이 수정되었습니다.");
					
				}
					
			}
		}
	}
	
	
	
	public void removeBook() {
		System.out.println("\n - 도서 목록 제거 - ");
		selectBook();
		
		System.out.println("제거를 원하는 도서의 제목을 입력해주세요!");
		System.out.print("제목 : ");
		String name = sc.next();
		
		if(list.isEmpty()) {
			System.out.println("도서 목록이 비어있습니다.");
		} else {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).get("keyTitle").equals(name)) {
					Map<String, Object> re = list.remove(i);
					System.out.println(re.get("keyTitle") + "의 도서 내용이 삭제되었습니다.\n");
				}
			}
		}
	}
	
	
	public void addFavorites() {
		
	}
	
	
	public void removeFavorites() {
		
	}
	
	
	public void fileWriter() {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("text.txt");
			
			fw.write(favorites.toString());
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				fw.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
