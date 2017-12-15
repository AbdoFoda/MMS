import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	private Integer window_x = 200;
	private Integer window_y = 200;
	private Integer window_w = 450;
	private Integer window_h = 300;

	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(window_x, window_y, window_w, window_h);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		initiate_memory();
	}

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
				} else
					JOptionPane.showMessageDialog(null, "please enter a valid number");
			}
		});

	}

	Boolean isInteger(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9')
				return false;
		}
		return true;
	}

	public void visualize(Integer memory_size) {
		MMS.init(memory_size);
		JLabel allocate = new JLabel("Allocate new Size:");
//		allocate.setBounds(allocate_x, allocate_y, allocate_w, allocate_h);
	}

}
