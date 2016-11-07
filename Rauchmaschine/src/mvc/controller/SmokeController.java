/*
 * 
 */
package mvc.controller;

import java.io.IOException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.json.JSONException;

import mvc.model.SmokeModel;
import mvc.view.SmokeView;

public class SmokeController {

	private SmokeView _view;
	private SmokeModel _model;

	public SmokeController(){
		this._model = new SmokeModel();
		this._view = new SmokeView();
		startTasks();
		addListener();
	}

	public void showView(){
		this._view.setVisible(true);
	}

	private void addListener(){
		this._view.setSollTemperaturListener(new SollTemperaturListener());
	}

	private void startTasks(){
		ControllHeating heatingControll = new ControllHeating();
		heatingControll.start();
	}

	
	/**
	 * 
	 */
	class SollTemperaturListener implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			Integer SollWert = Integer.valueOf(_view.getSollTemperatur());
			_view.setSollTemperatur(Integer.toString(SollWert));

		}
	}

	

	class ControllHeating extends Thread{
		public void run(){

			while(true){
				try {
					Double actualTemp = 0.0;
					actualTemp = _model.getTemperatureFromVZ();
					_view.setIstTemperatur(Double.toString(actualTemp));
					_view.setHeizungswert(_model.controllHeating(actualTemp,_view.getSollTemperatur()));
				} catch (IOException | JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

