package com.systex.hw3.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LotteryService {
	
	public static ArrayList<Integer> generateLotteryNum(HashSet<Integer> excludeNumberSet) {

		ArrayList<Integer> lottery = new ArrayList<>();

		while (lottery.size() < 6) {
			int luckNumber = (int) (Math.random() * 49 + 1);
			if (!excludeNumberSet.contains(luckNumber)) {
				lottery.add(luckNumber);
			}
		}
		return lottery;
	}

	public static HashSet<Integer> parseExcludeNum(String excludeNumString, HashSet<Integer> excludeNumberSet) {
		String[] numberStrings = excludeNumString.split(" ");
		for (String num : numberStrings) {
			try {
				excludeNumberSet.add(Integer.parseInt(num.trim()));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("您所輸入的排除數字似乎有非數字的值");
			}
			
		}
		return excludeNumberSet;
	}

}
