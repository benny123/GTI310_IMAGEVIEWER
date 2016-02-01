package controller;

import java.io.File;

import javax.swing.JMenu;
import javax.swing.JOptionPane;

import model.Image;
import model.Image_BMP;

public class BMP_Factory implements ImageFactory{
	
	/** Singleton instance to the ProxyFactory */
	private static ImageFactory _instance = null;
	
	/** Hides the constructor from outside the class. */
	private BMP_Factory() {};

	@Override
	public Image build(File file) {
		//crée l'instance Image_BMP
		Image_BMP bmp_file = new Image_BMP(file);
		
		// TODO Auto-generated method stub
		return bmp_file;
	}
	
	public static ImageFactory getInstance() {
		if(_instance == null)
			_instance = new BMP_Factory();
		return _instance;
	}
}
