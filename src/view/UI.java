package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.Action;
import controller.Controller;
import model.Proportion;

public class UI implements ViewInterface {
	
	private Scanner in;

	public UI() {
		this.in = new Scanner(System.in);
	}

	@Override
	public void inputInitdata() {

		List<Proportion> initData = new ArrayList<>();
		List<Proportion> findData = new ArrayList<>();
			
		initData.add(new Proportion(1024, "byte", 1, "kilobyte"));
		initData.add(new Proportion(2, "bar", 12, "ring"));
		initData.add(new Proportion(16.8, "ring", 2, "pyramid"));
		initData.add(new Proportion(4, "hare", 1, "cat"));
		initData.add(new Proportion(5, "cat", 0.5, "giraffe"));
		initData.add(new Proportion(1, "byte", 8, "bit"));
		initData.add(new Proportion(15, "ring", 2.5, "bar"));
		findData.add(new Proportion(1, "pyramid", 0, "bar"));
		findData.add(new Proportion(1, "giraffe", 0, "hare"));
		findData.add(new Proportion(0.5, "byte", 0, "cat"));
		findData.add(new Proportion(2, "kilobyte", 0, "bit"));	

		System.out.println("Тестовые входные данные:\n");
		for(Proportion p : initData) {
			System.out.println(p.getA() + p.getV() + " = " + p.getB() + p.getW());
		}
		System.out.println("\nТестовые данные расчёта:\n");
		for(Proportion p : findData) {
			System.out.println(p.getA() + p.getV() + " = " + "?" + p.getW());
		}
		
		System.out.println("\nShow result?\n 1 - Yes, 2 - No");
		int answer = in.nextInt();
		if (answer == 1) {
			resultData(initData, findData);
		} else {
			System.exit(0);
		}
		
		
	}

	@Override
	public void inputSearchData() {
		
		List<Proportion> findData = new ArrayList<>();
		int answer = 1;
		double a;
		String V, W;
		System.out.println("Ввод пропорции для расчёта:\nзначение1 тип1 = тип2\nПример: 1024 byte = kilobyte");
		while(answer != 2) {
			System.out.println("Введите значение1");
			a = in.nextDouble();
			System.out.println("Введите тип1");
			V = in.next();
			System.out.println("Введите тип2");
			W = in.next();
			findData.add(new Proportion(a, V, 0, W));
			System.out.println("Продолжить ввод?\n1 - Да | 2 - Нет");
			answer = in.nextInt();
		}
	}

	@Override
	public void resultData(List<Proportion> initData, List<Proportion> findData) {
		Action action = new Controller(initData, findData);
		List<String> s = action.getResult();
		System.out.println("\nРезультат расчёта:\n");
		for(String c : s) {
			System.out.println(c);
		}
	}
}
