package controller;

import java.util.List;

import model.Proportion;

/**
 * Action interface 
 * 
 * @author ovsyannikovda
 *
 */
public interface Action {
	
	/**
	 * Calculation method
	 * 
	 * @return
	 * 			Returns calculation result
	 */
	public List<String> getResult();
	
	/**
	 * Proportional conversion
	 * 
	 * @return
	 * 			Conversion data
	 */
	public List<Proportion> getConvData();

}
