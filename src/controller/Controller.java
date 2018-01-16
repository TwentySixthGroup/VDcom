package controller;

import java.util.ArrayList;
import java.util.List;

import model.Proportion;

/**
 * Class of proportional calculation 
 * 
 * @author ovsyannikovda
 *
 */
public class Controller implements Action {
	
	private List<Proportion> findData;
	private List<Proportion> initData;
	

	/**
	 * Constructor
	 * 
	 * @param initData
	 * 					Input data
	 * @param findData
	 * 					Find data
	 */
	public Controller(List<Proportion> initData, List<Proportion> findData) {
		this.initData = initData;
		this.findData = findData;
	}

	@Override
	public List<String> getResult() {
		List<String> result = new ArrayList<>();
		List<Proportion> findList = this.findData;
		List<Proportion> propList = getConvData();
		double s;
		String r;
		for (Proportion f : findList) {
			for(Proportion p : propList) {
				if(f.getV().equals(p.getV())) {
					s = p.getB();
					r = p.getW();
					for(Proportion p1 : propList) {
						if(f.getW().equals(p1.getW())) {
							result.add(f.getA() + f.getV() + " = " + (f.getA() * p1.getB() * s) + f.getW());
						} else if(f.getW().equals(p1.getV())) {
							if(p1.getW().equals(r)) {
								result.add(f.getA() + f.getV() + " = " + (s / p1.getB()) + f.getW());
							} else {
								result.add("Недостаточно исходных данных для решения пропорции");
							}
							break;
						}
					}
				} 
			}
		}
		return result;
	}

	@Override
	public List<Proportion> getConvData() {
		List<Proportion> action = initData;
		List<Proportion> convData = new ArrayList<>();
		double a,b;
		String V, W;
		
		for(int i = 0; i < action.size(); i++) {
			a = action.get(i).getA();
			V = action.get(i).getV();
			b = action.get(i).getB();
			W = action.get(i).getW();
			
			if(a < b) {
				if (a == 1) {
					convData.add(new Proportion(a, V, b, W));
				} else {
					double d = b/a;
					convData.add(new Proportion(a/=a, V, d, W));
				}
			} else {
				if (b == 1) {
					convData.add(new Proportion(b, W, a, V));
				} else {
					double d = a/b;
					convData.add(new Proportion(b /= b, W, d, V));
				}
			}
		}
		return convData;
	}
}
