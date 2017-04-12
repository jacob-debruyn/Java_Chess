
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MouseAdapterListener extends MouseAdapter {

	public int clickCounter = 0;
	public int xOld;
	public int yOld;
	public void mousePressed(MouseEvent e){
		 JPanel cellPanel = (JPanel)e.getSource();
		 
		
		 String name = cellPanel.getName();
		 int value = Integer.parseInt(name);
		 int y = value/6;
		 int x = value-(y*6); 
		
		 clickCounter++;
		 
		 if(clickCounter == 1){
			int player = MainDisplayTest.player;
			int isCurrentPiece = MainDisplayTest.game.players[player].isPlayersPiece(y,x);
			if(isCurrentPiece==-1){	
				clickCounter = 0;
				//MainDisplayTest.view.openInMoveWindow(0,0,MainDisplayTest.player);
			}
			  
			MainDisplayTest.view.openInMoveWindow(y,x,MainDisplayTest.player);
			xOld = x;
			yOld = y;	
		 }
		 if(clickCounter == 2){
			 
			 clickCounter = 0;
			 if(checkMoveRisk(x,y))MainDisplayTest.updateMove(xOld,yOld,x,y);;
		 }	
	}
	public boolean checkMoveRisk(int x, int y){
		
		int toSelection[] = new int[2];
		int player = MainDisplayTest.player;
		int playerSelect;
		if(player==0)playerSelect=1;
		else playerSelect=0;
		
		int isCurrentPiece = MainDisplayTest.game.players[player].isPlayersPiece(yOld,xOld);
		
		if(isCurrentPiece>=0){	
			toSelection[0] = y;
			 toSelection[1] = x;
			 if(MainDisplayTest.game.players[player].validMove(isCurrentPiece, toSelection)){
				 for(int a=0;a<6;a++){
					for(int b=0;b<6;b++){
						int isPiece = MainDisplayTest.game.players[playerSelect].isPlayersPiece(a,b);
						
						if(isPiece>=0){
							
							toSelection[0] = y;
							toSelection[1] = x;
							//have non jump valid check for risk
							if(MainDisplayTest.game.players[playerSelect].validMove(isPiece, toSelection)){
								int dialogButton = JOptionPane.YES_NO_OPTION;
								int dialogResult = JOptionPane.showConfirmDialog (null, "Your piece is at risk of being taken, Continue anyway?","Warning",dialogButton);
								if(dialogResult == JOptionPane.YES_OPTION)return true;
								if(dialogResult == JOptionPane.NO_OPTION){

									MainDisplayTest.updateMove(xOld,yOld,xOld,yOld);
									return false;
								}
							}
							
						}
						
					}
				 }
			 }
		}
		return true;
	}
}
