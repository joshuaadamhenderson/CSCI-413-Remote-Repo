import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class EmployeePayrollLabelPanel extends JPanel {

	private static final int SALES_RECORD_PANEL_HEIGHT = 16;
	private JLabel shiftDateLabel = new JLabel();
	private JLabel shiftStartLabel = new JLabel();
	private JLabel shiftEndLabel = new JLabel();
	private JLabel hoursWorkedLabel = new JLabel();
	private JLabel payRateLabel = new JLabel();
	private JLabel shiftPayLabel = new JLabel();
	private Font employeePayrollFont = new Font("Arial", Font.BOLD, 16);
	private static final int EMPLOYEE_PAYROLL_PANEL_HEIGHT = 16;
	public EmployeePayrollLabelPanel(String shiftDate, String shiftStart, String shiftEnd, String hoursWorked, String payRate, String shiftPay) {
		
		setBackground(Color.WHITE);
		shiftDateLabel.setText(shiftDate);
		shiftStartLabel.setText(shiftStart);
		shiftEndLabel.setText(shiftEnd);
		hoursWorkedLabel.setText(hoursWorked);
		payRateLabel.setText(payRate);
		shiftPayLabel.setText(shiftPay);
		
		shiftDateLabel.setHorizontalAlignment(JLabel.LEFT);
		shiftStartLabel.setHorizontalAlignment(JLabel.LEFT);
		shiftEndLabel.setHorizontalAlignment(JLabel.LEFT);
		hoursWorkedLabel.setHorizontalAlignment(JLabel.LEFT);
		payRateLabel.setHorizontalAlignment(JLabel.RIGHT);
		shiftPayLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		shiftDateLabel.setPreferredSize(new Dimension((int)(EmployeePayrollFrame.employeePayrollPanel.getWidth() * 0.13), EMPLOYEE_PAYROLL_PANEL_HEIGHT));
		shiftStartLabel.setPreferredSize(new Dimension((int)(EmployeePayrollFrame.employeePayrollPanel.getWidth() * 0.13), EMPLOYEE_PAYROLL_PANEL_HEIGHT));
		shiftEndLabel.setPreferredSize(new Dimension((int)(EmployeePayrollFrame.employeePayrollPanel.getWidth() * 0.13), EMPLOYEE_PAYROLL_PANEL_HEIGHT));
		hoursWorkedLabel.setPreferredSize(new Dimension((int)(EmployeePayrollFrame.employeePayrollPanel.getWidth() * 0.21), EMPLOYEE_PAYROLL_PANEL_HEIGHT));
		payRateLabel.setPreferredSize(new Dimension((int)(EmployeePayrollFrame.employeePayrollPanel.getWidth() * 0.12), EMPLOYEE_PAYROLL_PANEL_HEIGHT));
		shiftPayLabel.setPreferredSize(new Dimension((int)(EmployeePayrollFrame.employeePayrollPanel.getWidth() * 0.22), EMPLOYEE_PAYROLL_PANEL_HEIGHT));
		
		shiftDateLabel.setFont(employeePayrollFont);
		shiftStartLabel.setFont(employeePayrollFont);
		shiftEndLabel.setFont(employeePayrollFont);
		hoursWorkedLabel.setFont(employeePayrollFont);
		payRateLabel.setFont(employeePayrollFont);
		shiftPayLabel.setFont(employeePayrollFont);
		
		setLayout(new FlowLayout());
		add(shiftDateLabel);
		add(shiftStartLabel);
		add(shiftEndLabel);
		add(hoursWorkedLabel);
		add(payRateLabel);
		add(shiftPayLabel);
	}
}
