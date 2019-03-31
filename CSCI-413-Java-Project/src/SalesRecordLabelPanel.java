import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SalesRecordLabelPanel extends JPanel {

	private static final int SALES_RECORD_PANEL_HEIGHT = 16;
	private JLabel dateLabel = new JLabel();
	private JLabel timeLabel = new JLabel();
	private JLabel employeeLabel = new JLabel();
	private JLabel tableNumberLabel = new JLabel();
	private JLabel menuItemLabel = new JLabel();
	private JLabel menuItemPriceLabel = new JLabel();
	private Font salesRecordFont = new Font("Arial", Font.BOLD, 16);

	public SalesRecordLabelPanel(String date, String time, String employee, String tableNumber, String menuItem, String menuItemPrice) {
		
		setBackground(Color.WHITE);
		dateLabel.setText(date);
		timeLabel.setText(time);
		employeeLabel.setText(employee);
		tableNumberLabel.setText(tableNumber);
		menuItemLabel.setText(menuItem);
		menuItemPriceLabel.setText(menuItemPrice);
		dateLabel.setHorizontalAlignment(JLabel.LEFT);
		timeLabel.setHorizontalAlignment(JLabel.LEFT);
		employeeLabel.setHorizontalAlignment(JLabel.LEFT);
		tableNumberLabel.setHorizontalAlignment(JLabel.LEFT);
		menuItemLabel.setHorizontalAlignment(JLabel.RIGHT);
		menuItemPriceLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		dateLabel.setPreferredSize(new Dimension((int)(SalesReportFrame.salesRecordsPanel.getWidth() * 0.15), SALES_RECORD_PANEL_HEIGHT));
		timeLabel.setPreferredSize(new Dimension((int)(SalesReportFrame.salesRecordsPanel.getWidth() * 0.15), SALES_RECORD_PANEL_HEIGHT));
		employeeLabel.setPreferredSize(new Dimension((int)(SalesReportFrame.salesRecordsPanel.getWidth() * 0.28), SALES_RECORD_PANEL_HEIGHT));
		tableNumberLabel.setPreferredSize(new Dimension((int)(SalesReportFrame.salesRecordsPanel.getWidth() * 0.15), SALES_RECORD_PANEL_HEIGHT));
		menuItemLabel.setPreferredSize(new Dimension((int)(SalesReportFrame.salesRecordsPanel.getWidth() * 0.15), SALES_RECORD_PANEL_HEIGHT));
		menuItemPriceLabel.setPreferredSize(new Dimension((int)(SalesReportFrame.salesRecordsPanel.getWidth() * 0.08), SALES_RECORD_PANEL_HEIGHT));
		
		dateLabel.setFont(salesRecordFont);
		timeLabel.setFont(salesRecordFont);
		employeeLabel.setFont(salesRecordFont);
		tableNumberLabel.setFont(salesRecordFont);
		menuItemLabel.setFont(salesRecordFont);
		menuItemPriceLabel.setFont(salesRecordFont);
		
		setLayout(new FlowLayout());
		add(dateLabel);
		add(timeLabel);
		add(employeeLabel);
		add(tableNumberLabel);
		add(menuItemLabel);
		add(menuItemPriceLabel);
	}
}
