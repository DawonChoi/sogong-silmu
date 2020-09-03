package kr.gsm.model;

import java.util.ArrayList;

public class MyUtil {
	public int totHap() {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}
	
	public int totHap(int s, int e) {
		int sum = 0;
		for(int i = s; i <= e; i++) {
			sum += i;
		}
		return sum;
	}
	
	public int totCnt(int s, int e) {
		int cnt = 0;
		for(int i = s; i <= e; i++) {
			if(i % 3 == 0 && i % 5 == 0)
				cnt++;
		}
		return cnt;
	}
	
	public ArrayList<Integer> totCntList(int s, int e) {
		ArrayList<Integer> clist = new ArrayList<Integer>();
		for(int i = s; i <= e; i++) {
			if(i % 3 == 0 && i % 5 == 0)
				clist.add(i);
		}
		return clist;
	}
		
}
