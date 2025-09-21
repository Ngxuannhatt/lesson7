package oop_exemples;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Lesson7 {
	
	public static boolean isLeapYear(int year) {
		if((year % 400) == 0 || (year % 4 == 0 && year % 100 !=0)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int dayOfWeek(int year, int month, int day) {
		LocalDate date = LocalDate.of(year, month, day);
		//Lấy thứ trong tuần
		DayOfWeek dayOfWeek = date.getDayOfWeek();
        //Chuyển thứ thành giá trị (1=Monday, 7=Sunday)
        int dayValue = dayOfWeek.getValue();
        return dayValue;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập năm bạn muốn in lịch: ");
		int year = sc.nextInt();
		int[] dayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(isLeapYear(year)) {
			dayOfMonth[2]=29;
		}
		System.out.println();
		System.out.printf("%63s", "LỊCH NĂM " + year + "\n");
		System.out.println();
		for(int i=1;i<=12;i+=4) {
			System.out.printf("%15s%30s%30s%30s\n", "Tháng " + i, "Tháng " + (i + 1), "Tháng " + (i + 2), "Tháng " + (i + 3));
			System.out.println();
			String header = "T2 T3 T4 T5 T6 T7 CN";
			System.out.printf("%21s%30s%30s%30s", header, header, header, header);
			System.out.println();
			
			int startDayS1 = dayOfWeek(year, i, 1);
			int startDayS2 = dayOfWeek(year, i + 1, 1);
			int startDayS3 = dayOfWeek(year, i + 2, 1);
			int startDayS4 = dayOfWeek(year, i + 3, 1);
			
			int d1 = 1, d2 = 1, d3 = 1, d4 = 1;

			for (int week = 0; week < 6; week++) { // tối đa 6 tuần một tháng

				for (int j = 1; j <= 7; j++) { // 7 ngày trong tuần
					if ((week == 0 && j < startDayS1) || d1 > dayOfMonth[i]) {
						System.out.printf("%3s", " ");
					} else {
						System.out.printf("%3d", d1++);
					}
				}
				System.out.print("         ");
				
				for (int j = 1; j <= 7; j++) {
					if ((week == 0 && j < startDayS2) || d2 > dayOfMonth[i + 1]) {
						System.out.printf("%3s", " ");
					} else {
						System.out.printf("%3d", d2++);
					}
				}
				System.out.print("         ");

				for (int j = 1; j <= 7; j++) {
					if ((week == 0 && j < startDayS3) || d3 > dayOfMonth[i + 2]) {
						System.out.printf("%3s", " ");
					} else {
						System.out.printf("%3d", d3++);
					}
				}
				System.out.print("         ");
				
				for (int j = 1; j <= 7; j++) { // 7 ngày trong tuần
					if ((week == 0 && j < startDayS4) || d4 > dayOfMonth[i + 3]) {
						System.out.printf("%3s", " ");
					} else {
						System.out.printf("%3d", d4++);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
