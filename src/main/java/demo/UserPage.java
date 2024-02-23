package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class UserPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField ProductNameField;
	private JTextField ProductQuantitiesField;
	private JTextField PriceField;


	/**
	 * Create the frame.
	 */
	public UserPage(final String userSes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Welcome,");
		JLabel lblNewLabel_1 = new JLabel(userSes);
		
		JButton CategoryButton = new JButton("Product Category");
		
		JButton InvoiceButton = new JButton("Invoice");
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Product", "Category", "Quantities", "Price"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(113);
		table.getColumnModel().getColumn(1).setPreferredWidth(159);
		table.getColumnModel().getColumn(2).setPreferredWidth(306);
		table.setAutoCreateRowSorter(true);
		
		final JButton AddButon = new JButton("Add Product");
		
		JButton ResetButton = new JButton("Reset");
		
		JLabel lblNewLabel_2 = new JLabel("Product Name");
		
		JLabel lblNewLabel_2_1 = new JLabel("Product Category");
		
		JLabel lblNewLabel_2_2 = new JLabel("Product Quantities");
		
		ProductNameField = new JTextField();
		ProductNameField.setColumns(10);
		
		ProductQuantitiesField = new JTextField();
		ProductQuantitiesField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		JButton DeleteButton = new JButton("Delete");
		
		final JButton LogoutButton = new JButton("Logout");
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Product Price");
		
		PriceField = new JTextField();
		PriceField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(lblNewLabel_1))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(ProductNameField, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(ProductQuantitiesField, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(AddButon, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(ResetButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(DeleteButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(CategoryButton, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(InvoiceButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
							.addComponent(LogoutButton)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(PriceField, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
					.addGap(111))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2))
						.addComponent(ProductNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_2_1))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_2))
						.addComponent(ProductQuantitiesField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_2_1)
						.addComponent(PriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(AddButon)
						.addComponent(ResetButton)
						.addComponent(DeleteButton))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(CategoryButton)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(InvoiceButton)
							.addComponent(LogoutButton))))
		);
		contentPane.setLayout(gl_contentPane);

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		DefaultComboBoxModel modelCombo = (DefaultComboBoxModel) comboBox.getModel();
		
		try {
            Connection connection = DemoConnection.getConnection();
            PreparedStatement st = connection.prepareStatement("SELECT a.*, b.* FROM `product` a \r\n"
            		+ "JOIN `product_category` b ON a.product_cate = b.pd_cate_id;");
            ResultSet rs = st.executeQuery();
            String productName,productCategory;
            
            PreparedStatement st2 = connection.prepareStatement("SELECT * FROM `product_category` WHERE 1 ");
            ResultSet rs2 = st2.executeQuery();
            
            while(rs.next()) {
            	int productID = Integer.parseInt(rs.getString("product_id"));
            	productName = rs.getString("product_name");
            	productCategory = rs.getString("pd_cate_name");
            	int productQuantities = Integer.parseInt(rs.getString("product_quan"));
            	float productPrice = Float.parseFloat(rs.getString("product_price"));
            	
            	Object[] row = { productID, productName, productCategory, productQuantities, productPrice };
            	model.addRow(row);
        	}
            
            while(rs2.next()) {
            	modelCombo.addElement(rs2.getString("pd_cate_name"));
            }
            
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

		ResetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductNameField.setText("");
				ProductQuantitiesField.setText("");
				PriceField.setText("");
			}
		});
	
		AddButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String proName = ProductNameField.getText();
				String proCate = (String) comboBox.getSelectedItem();
				String proQuan = ProductQuantitiesField.getText();
				String proPrice = PriceField.getText();
				String proCateId = null;
				
				if (!proName.isEmpty() && !proCate.isEmpty() && !proQuan.isEmpty() && !proPrice.isEmpty()) {
					try {
						Integer.parseInt(proQuan);
						Integer.parseInt(proPrice);
						try {
							Connection connection = DemoConnection.getConnection();
							PreparedStatement st1 = connection
									.prepareStatement("SELECT `pd_cate_id` FROM `product_category` WHERE `pd_cate_name`=? ");
							st1.setString(1, proCate);
							ResultSet rs2 = st1.executeQuery();
							
							if (rs2.next()) {
								proCateId = rs2.getString("pd_cate_id");
							}
							
							if (!proCateId.isEmpty()) {
					            PreparedStatement st = connection
					            		.prepareStatement("INSERT INTO `product` (`product_name`, `product_cate`, `product_price` ,`product_quan`) VALUES (?, ?, ?, ?);");
					            st.setString(1, proName);
					            st.setString(2, proCateId);
					            st.setString(3, proPrice);
					            st.setString(4, proQuan);
					            int rs = st.executeUpdate();
					            
					            if(rs > 0) {
					            	JOptionPane.showMessageDialog(AddButon, "them san pham thanh cong");
					            	
					            	try {
					                    Connection connection1 = DemoConnection.getConnection();
					                    PreparedStatement st11 = connection1.prepareStatement("SELECT a.*, b.* FROM `product` a \r\n"
					                    		+ "JOIN `product_category` b ON a.product_cate = b.pd_cate_id;");
					                    ResultSet rs1 = st11.executeQuery();
					                    String productName,productCategory;
					                    
					                    while(rs1.next()) {
					                    	int productID = Integer.parseInt(rs1.getString("product_id"));
					                    	productName = rs1.getString("product_name");
					                    	productCategory = rs1.getString("pd_cate_name");
					                    	int productQuantities = Integer.parseInt(rs1.getString("product_quan"));
					                    	float productPrice = Float.parseFloat(rs1.getString("product_price"));
					                    	
					                    	Object[] row = { productID, productName, productCategory, productQuantities, productPrice };
					                    	model.addRow(row);
					                	}
					                } catch (SQLException sqlException) {
					                    sqlException.printStackTrace();
					                }
					            } else {	            
					            	JOptionPane.showMessageDialog(AddButon, "them san pham that bai");
					            }
							} else {	            
				            	JOptionPane.showMessageDialog(AddButon, "phai nhap so");
				            }
							
						} catch (SQLException sqlException) {
							sqlException.printStackTrace();
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(AddButon, "them san pham that bai");
					}
				}
			}
		});
		
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if(row >= 0 ) {
					String productID = (String) table.getValueAt(row, 0);
					
					try {
						Connection connection = DemoConnection.getConnection();
						PreparedStatement st = connection
								.prepareStatement("DELETE FROM product WHERE product_id = ?;");
						st.setString(1, productID);
						int rs = st.executeUpdate();
						
						if (rs > 0) {
							JOptionPane.showMessageDialog(DeleteButton, "da xoa san pham");
							model.removeRow(row);
						}
					} catch (SQLException sqlException) {
						sqlException.printStackTrace();
					}
				}
			}
			
		});
		
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(LogoutButton, "Are you sure?");
				
				if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    Login obj = new Login();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
			}
		});
	}
}
