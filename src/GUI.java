import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private Integer start_x = 10;
	private Integer allocate_y = 50;
	private Integer size_y = 30;
	private Integer input_x = 100;
	private Integer policy_x = 250;
	private Integer ok_x = policy_x + 100;
	private Integer lbl_w = 100;
	private Integer lbl_h = 20;
	private Integer deAllocate_lbl_y = allocate_y + 3 * lbl_h;
	private Integer deFregment_lbl_y = deAllocate_lbl_y + 3 * lbl_h;
	private Integer adress_lbl_y = allocate_y + 2 * lbl_h;
	JButton deAllocate_ok;
	JButton allocate_ok;
	private Integer window_x = 200;
	private Integer window_y = 200;
	private Integer window_w = 450;
	private Integer window_h = 300;

	private Integer textField_h = 20;
	private Integer memoryTextField_w = 200;
	private Integer memoryTextField_x = 100;
	private Integer memoryTextField_y = 100;

	private Integer header_x = 100;
	private Integer header_y = 10;
	private Integer header_w = 500;
	private Integer header_h = 100;

	private Integer submit_h = textField_h * 2;
	private Integer submit_w = memoryTextField_w / 2;
	private Integer submit_x = memoryTextField_x + 30;
	private Integer submit_y = memoryTextField_y + 50;

	public Integer memory_lbl_x = 400;
	public Integer memory_lbl_y = 300;
	public Integer memory_y = 333;
	public Integer memory_w = 900;
	public Integer memory_h = 200;
	JTextField size_txt;
	JTextField adress_txt;
	JComboBox<String> policyCombo;
	JComboBox<String> case_num;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(window_x, window_y, window_w, window_h);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		initiate_memory();
	}

	public void initiate_memory() {
		JLabel header = new JLabel("MEMORY SIMULATION PROGRAM");
		header.setBounds(header_x, header_y, header_w, header_h);
		contentPane.add(header);

		JTextField memorySize = new JTextField("Initial Memory Size");
		memorySize.setBounds(memoryTextField_x, memoryTextField_y, memoryTextField_w, textField_h);
		contentPane.add(memorySize);

		JButton submit = new JButton("OK");
		submit.setBounds(submit_x, submit_y, submit_w, submit_h);
		contentPane.add(submit);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isInteger(memorySize.getText())) {
					visualize(Integer.decode(memorySize.getText()));
					header.setVisible(false);
					memorySize.setVisible(false);
					submit.setVisible(false);
					repaint();
				} else
					error_msg();
			}
		});

	}

	Boolean isInteger(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9')
				return false;
		}
		return s.length() > 0;
	}
	Vector<String> policies ;
	public void simulation_design() {
		setBounds(10, 10, 1000, 700);

		JLabel allocate_lbl = new JLabel("Allocate      :");
		allocate_lbl.setBounds(start_x, allocate_y, lbl_w, lbl_h);
		contentPane.add(allocate_lbl);

		JLabel size_lbl = new JLabel("size");
		size_lbl.setBounds(input_x + lbl_w / 4, size_y, lbl_w, lbl_h);
		contentPane.add(size_lbl);

		size_txt = new JTextField();
		size_txt.setBounds(input_x, allocate_y, lbl_w, lbl_h);
		contentPane.add(size_txt);

		allocate_ok = new JButton("OK");
		allocate_ok.setBounds(ok_x, allocate_y, lbl_w, lbl_h);
		contentPane.add(allocate_ok);

		policies = new Vector<String>();
		policies.add("First-Fit");
		policies.add("BEST-FIT");
		policies.add("WORST-FIT");
		policyCombo = new JComboBox<String>(policies);
		policyCombo.setBounds(policy_x, allocate_y, lbl_w, lbl_h);
		contentPane.add(policyCombo);

		JLabel deAllocate_lbl = new JLabel("Deallocate :");
		deAllocate_lbl.setBounds(start_x, deAllocate_lbl_y, lbl_w, lbl_h);
		contentPane.add(deAllocate_lbl);

		JLabel adress_lbl = new JLabel("Adress");
		adress_lbl.setBounds(input_x + lbl_w / 4, adress_lbl_y, lbl_w, lbl_h);
		contentPane.add(adress_lbl);

		adress_txt = new JTextField();
		adress_txt.setBounds(input_x, deAllocate_lbl_y, lbl_w, lbl_h);
		contentPane.add(adress_txt);

		deAllocate_ok = new JButton("OK");
		deAllocate_ok.setBounds(ok_x, deAllocate_lbl_y, lbl_w, lbl_h);
		contentPane.add(deAllocate_ok);

		JLabel deFregment_lbl = new JLabel("Defregment:");
		deFregment_lbl.setBounds(start_x, deFregment_lbl_y, lbl_w, lbl_h);
		contentPane.add(deFregment_lbl);

		Vector<String> choices = new Vector<String>();
		choices.add("Case #:");
		choices.add("1");
		choices.add("2");
		choices.add("3");
		case_num = new JComboBox<String>(choices);
		case_num.setBounds(input_x, deFregment_lbl_y, lbl_w, lbl_h);
		contentPane.add(case_num);
	}

	public void show_memory() {
		JLabel memory_lbl = new JLabel("MEMORY");
		memory_lbl.setBounds(memory_lbl_x, memory_lbl_y, lbl_w, lbl_h);
		contentPane.add(memory_lbl);

		Integer cur_x = start_x;
		for (int i = 0; i < MMS.memory.size(); ++i) {
			JLabel cur_part = new JLabel();
			cur_part.setBounds(cur_x, memory_y,
					(int) ((1.0 * MMS.memory.get(i).getPartitionSize() / MMS.t_size) * (1.0 * memory_w)), memory_h);
			cur_part.setBorder(BorderFactory.createLineBorder(Color.black));
			contentPane.add(cur_part);

			JLabel start_adress = new JLabel(String.valueOf(MMS.memory.get(i).getStartAddress()));
			start_adress.setBounds(cur_x, memory_y - 20, lbl_w, lbl_h);
			contentPane.add(start_adress);

			JLabel allocated = new JLabel();
			allocated.setBounds(cur_x, memory_y,
					(int) (((1.0 * MMS.memory.get(i).getReservedSize()) / (1.0 * MMS.memory.get(i).getPartitionSize()))
							* 1.0 * cur_part.getWidth()),
					memory_h);
			allocated.setBackground(Color.green);
			allocated.setOpaque(true);
			allocated.setBorder(BorderFactory.createLineBorder(Color.blue));
			contentPane.add(allocated);

			cur_x += cur_part.getWidth();
		}
		JLabel memory = new JLabel();
		memory.setBounds(start_x - 5, memory_y - 5, memory_w + 10, memory_h + 10);
		memory.setOpaque(false);
		memory.setBorder(BorderFactory.createLineBorder(Color.RED));
		contentPane.add(memory);
	}

	public void visualize(Integer memory_size) {
		MMS.init(memory_size);
		clearAndSet();
	}

	public void error_msg() {
		JOptionPane.showMessageDialog(null, "please enter a valid number");
	}

	public void clearAndSet() {
		contentPane.removeAll();
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		simulation_design();
		show_memory();
		validate();
		repaint();
		Action();
	}

	private void Action() {
		// TODO Auto-generated method stub
		allocate_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (isInteger(size_txt.getText()) && Integer.decode(size_txt.getText()) > 0) {
					if (MMS.allocate(MMS.callTheRightPolicy(policies.get(policyCombo.getSelectedIndex())), Integer.decode(size_txt.getText())) != -1) {
						clearAndSet();
					} else {
						JOptionPane.showMessageDialog(null, "No Enough Space");
					}
				} else {

					error_msg();
				}
			}
		});
		deAllocate_ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (isInteger(adress_txt.getText())) {
					if (MMS.deallocate(Integer.decode(adress_txt.getText()))) {
						clearAndSet();
					} else {
						JOptionPane.showMessageDialog(null, "No Such Adress");
					}
				} else {

					error_msg();
				}
			}
		});

		case_num.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (case_num.getSelectedIndex() > 0) {
					MMS.defragment(case_num.getSelectedIndex());
					clearAndSet();
				}
			}
		});
	
	}

}
