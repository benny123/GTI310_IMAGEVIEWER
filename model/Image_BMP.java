package model;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image_BMP extends Image{
	
	private File file;
	private BufferedImage monImage;
	private BufferedImage bufferedImage;
	private int rgb; // tableau pour contenir les couleurs de chaque pixels
	
	public Image_BMP(File file) {
		this.file = file;
	}
	 
	@Override
	public BufferedImage draw() {
		
		/**
		 * Create a BufferedImage object to match the display's RGB requirements. 
		 * @return A BufferedImage representing the image file, or null if
		 * something went wrong.
		 */
		
		// POUR ROBERT  : CECI N'EST PAS BON CAR LE PROF NE VEUT PAS QU'ON UTILISE LA CLASSE IMAGEIO 
		try{
			//lire le fichier .bmp
			monImage = ImageIO.read(file);
			//prend les dimensions
			int height =  monImage.getHeight();
			int width = monImage.getWidth();
		
			System.out.println("HEIGHT : "+monImage.getHeight()+"WIDTH : "+monImage.getWidth()+" TYPE : ");
			
			//crée le tableau avec les espaces nécessaires
			int[] tabCouleur = new int[width*height];
		
			for(int y=0;y<height-1;y++)
			{
				for(int x=0;x<width-1;x++)
				{
					System.out.println(monImage.getRGB(x,y));
					int rgb = monImage.getRGB(x,y); 
					int alpha = (rgb >>24 ) & 0xFF; 
					int rouge = (rgb >>16 ) & 0xFF; 
					int vert = (rgb >> 8 ) & 0xFF; 
					int bleu = rgb & 0xFF; 
					 
					/** Construction d'un pixel : */ 
					rgb = (alpha<<24)+(rouge<<16)+(vert<<8)+bleu; 
					System.out.println("apres "+rgb);
					tabCouleur[x*y] = rgb;
				}
			}
			bufferedImage = new BufferedImage(height,width,BufferedImage.TYPE_4BYTE_ABGR);
			bufferedImage.setRGB(0, 0, width, height, tabCouleur, 0, width);
			return bufferedImage;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getHeight() {
		return monImage.getHeight();
		//return 0;
	}

	@Override
	public int getWidth() {
		return monImage.getWidth();
		//return 0;
	}

}
