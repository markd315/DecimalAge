import java.applet.Applet;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.joda.time.DateTime;


public class DecimalAge extends Applet implements ActionListener
{
	private static final long serialVersionUID = 2872339633771276097L;
	Button okButton;
	TextField yearField, monthField, dayField, hourField, minField, responseField;
	Checkbox PM;
	DateTime bd, dt;
	final int SECONDSINYEAR = 31536000;
	final int SECONDSINLEAPYEAR = 31622400;
	final int AVGYEAR = 31557600;
	@Override
	public void init()
	{
		setLayout(null);
		okButton = new Button("Generate age");
		yearField = new TextField("Year", 4);
		monthField = new TextField("MM", 2);
		dayField = new TextField("DD", 2);
		hourField = new TextField("HH", 2);
		minField = new TextField("MM", 2);
		PM = new Checkbox("PM?");
		responseField = new TextField("Response", 1000);
		
		yearField.setBounds(0, 5, 70, 20);
		monthField.setBounds(75, 5, 35, 20);
		dayField.setBounds(115, 5, 35, 20);
		hourField.setBounds(0, 30, 35, 20);
		minField.setBounds(40, 30, 35, 20);
		PM.setBounds(80, 30, 40, 20);
		okButton.setBounds(0, 50, 190, 30);
		responseField.setBounds(0,90,190,100);
		
		add(okButton);
		add(yearField);
		add(monthField);
		add(dayField);
		add(hourField);
		add(minField);
		add(PM);
		add(responseField);

		okButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		bd = new DateTime(Integer.parseInt(yearField.getText()), Integer.parseInt(monthField.getText()), Integer.parseInt(dayField.getText()), Integer.parseInt(hourField.getText()), Integer.parseInt(minField.getText()), 0, 0);
		dt = new DateTime();
		long seconds = (dt.getMillis() - bd.getMillis())/(long)1000.0;
		double years = seconds/31557600.0;
		responseField.setText(String.valueOf(years));
	}
}
