
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PrincipalView implements Observador {

	private JFrame frmExamplejavamemcached;
	private Controller c;
	private JTextArea cache;

	public PrincipalView(Controller c2) {
		this.c = c2;
		this.c.anadirVista(this);
		initialize();

		this.frmExamplejavamemcached.setVisible(true);
		// this.frmExamplejavamemcached.pack();
		Dimension d = new Dimension(570, 320);
		// this.frmExamplejavamemcached.setPreferredSize(d);
		this.frmExamplejavamemcached.setSize(d);

		this.frmExamplejavamemcached.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frmExamplejavamemcached.dispose();
				c.CerrarConex(); // close the conexion client
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExamplejavamemcached = new JFrame();
		frmExamplejavamemcached.setTitle("ExampleJavaMemcached");
		frmExamplejavamemcached.setBounds(100, 100, 450, 300);
		frmExamplejavamemcached.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExamplejavamemcached.getContentPane().setLayout(null);

		cache = new JTextArea();
		cache.setBounds(257, 11, 220, 250);
		frmExamplejavamemcached.getContentPane().add(cache);

		JButton btnNewButton = new JButton("Insert Elements");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					c.IntroducirDatos();
					JOptionPane.showMessageDialog(null,
							"Inserted 5 elements with a lapse of 3 seg",
							"Insert Elements", JOptionPane.INFORMATION_MESSAGE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(42, 70, 160, 23);
		frmExamplejavamemcached.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Update Memcached");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Get the elements from Memcached at the moment
				c.getDatos();
			}
		});
		btnNewButton_1.setBounds(42, 167, 160, 23);
		frmExamplejavamemcached.getContentPane().add(btnNewButton_1);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see Observador#ActualizarDatos(java.lang.String)
	 */
	public void ActualizarDatos(String datos) {
		// TODO Auto-generated method stub
		this.cache.setText(datos);
	}
}
