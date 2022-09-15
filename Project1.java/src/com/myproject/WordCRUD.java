package com.myproject;

import java.util.Scanner;
import java.util.ArrayList;

public class WordCRUD implements ICRUD{
	ArrayList<Word> list;
	Scanner s;
	
	WordCRUD(Scanner s){
		list = new ArrayList<>();
		this.s=s;
	}
	
	@Override
	public Object add() {
		System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
		int level = s.nextInt();
		String word=s.nextLine();
		System.out.print("뜻 입력 : ");
		String meaning = s.nextLine();
		
		return new Word(0, level, word, meaning);
	}
	
	public void addWord() {
		Word one = (Word)add();
		list.add(one);
		System.out.print("\n새 단어가 단어장에 추가되었습니다.\n\n");
	}
 
	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;   
	} 

	@Override
	public void selectOne(int id) {
		// TODO Auto-generated method stub
	}
	
	public void listAll() {
		System.out.println("-------------------------------");
		for (int i = 0; i<list.size(); i++) {
			System.out.print((i+1) + " ");
			System.out.println(list.get(i).toString());	
		}
		System.out.println("-------------------------------");	
	}
	
	public ArrayList<Integer> idlist(String word) {
		ArrayList<Integer> ilist = new ArrayList<>();
		int j=0;
		System.out.println("-------------------------------");
		for (int i = 0; i<list.size(); i++) {
			String keyword = list.get(i).getWord();
			if (!word.contains(word)) continue;
			System.out.print((j+1) + " ");
			System.out.println(list.get(i).toString());	
			ilist.add(i);
			j++;
		}
		System.out.println("-------------------------------");
		return ilist;	
	}

	public void editWord() {
		System.out.print("=> 수정할 단어 검색: ");
		String keyword=s.next();
		ArrayList<Integer> ilist= this.idlist(keyword);
		System.out.println("=> 수정할 번호 선택: ");
		int number = s.nextInt();
		s.nextLine();
		System.out.print("=> 뜻 입력: ");
		String meaning = s.nextLine();
		Word word = list.get(ilist.get(number-1));
		word.setMeaning(meaning);
		System.out.println("단어가 수정되었습니다. ");		
	}

	public void deleteWord() {
		System.out.println("=> 삭제할 단어 검색: ");
		String keyword=s.next();
		ArrayList<Integer> ilist= this.idlist(keyword);
		System.out.println("=> 삭제할 번호 선택: ");
		int number = s.nextInt();
		s.nextLine();
		System.out.print("=> 정말로 삭제할까요?(y/n) ");
		String answer= s.next();
		if (answer.equalsIgnoreCase("y")) {
			list.remove((int)ilist.get(number-1));
			System.out.println("단어가 삭제되었습니 ");
		}
		else 
			System.out.println("취소되었습니다. ");
	}
}
