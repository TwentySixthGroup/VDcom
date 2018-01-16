package view;

import java.util.List;

import model.Proportion;

/**
 * View interface
 * 
 * @author ovsyannikovda
 */
public interface ViewInterface {
	
	/**
	 * View input data
	 */
	void inputInitdata();
	
	/**
	 * View search data
	 */
	void inputSearchData();
	
	/**
	 * View result data
	 * 
	 * @param initData
	 * 					Input data
	 * @param findData
	 * 					Search data
	 */
	void resultData(List<Proportion> initData, List<Proportion> findData);

}
