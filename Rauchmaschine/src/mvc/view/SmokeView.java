package mvc.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;


public class SmokeView extends JFrame{

	private static final long serialVersionUID = 1L;

	private JLabel lblUberschrift = new JLabel("Rauchmaschine V0.9");
	private JLabel lblSollTemperatur = new JLabel("Wert einstellen");
	private JLabel lblIstTemperatur = new JLabel("IstTemperatur");
	private JLabel lblUberschriftIstTemperatur = new JLabel("Ist- Temperatur:");
	private JLabel lblUberschriftSollTemperatur = new JLabel("Soll- Temperatur:");
	private JSlider temperaturEinstellung = new JSlider();
	private JLabel lblHeizungswert = new JLabel("kein Regelwert");
	private JLabel lblUberschriftHeizung = new JLabel("Heizung:");




	
    public SmokeView(){
        initialize();
    }
    
	private void initialize() {


		this.setBounds(0, 0, 800, 480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.getContentPane().setLayout(null);
		
		
		getContentPane().add(temperaturEinstellung);
		getContentPane().add(lblSollTemperatur);
		getContentPane().add(lblIstTemperatur);
		getContentPane().add(lblUberschriftIstTemperatur);
		getContentPane().add(lblUberschriftSollTemperatur);
	
		lblSollTemperatur.setBounds(41, 137, 98, 16);
		this.getContentPane().add(lblSollTemperatur);
		
		lblIstTemperatur.setBounds(41, 234, 130, 16);
		this.getContentPane().add(lblIstTemperatur);
		
		lblUberschriftIstTemperatur.setBounds(41, 212, 130, 16);
		this.getContentPane().add(lblUberschriftIstTemperatur);
		
		lblUberschriftSollTemperatur.setBounds(41, 74, 130, 16);
		this.getContentPane().add(lblUberschriftSollTemperatur);
		
		lblUberschrift.setBounds(6, 29, 788, 16);
		lblUberschrift.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblUberschrift);

		temperaturEinstellung.setMaximum(120);
		temperaturEinstellung.setMinimum(0);
		temperaturEinstellung.setBounds(41, 102, 190, 29);
		this.getContentPane().add(temperaturEinstellung);
		
		lblUberschriftHeizung.setBounds(295, 74, 61, 16);
		getContentPane().add(lblUberschriftHeizung);
		
		lblHeizungswert.setBounds(295, 137, 130, 16);
		getContentPane().add(lblHeizungswert);
	}
	
	
	
	/*
	 * Setter Methoden
	 */
	public void setIstTemperatur(String IstTemperatur){
        this.lblIstTemperatur.setText(IstTemperatur);
    }
	
	public void setSollTemperatur(String SollTemperatur){
		this.lblSollTemperatur.setText(SollTemperatur);
	}
	
	public void setHeizungswert(String Heizungswert){
		this.lblHeizungswert.setText(Heizungswert);
	}
	
	
	/*
	 * Getter Methoden
	 */
	public int getSollTemperatur(){
		return this.temperaturEinstellung.getValue();
	}
	
	
	
	/*
	 * Listener für die verschiedenen Buttons etc...
	 */
	public void setSollTemperaturListener(ChangeListener l){
		temperaturEinstellung.addChangeListener(l);
			
	}
}
