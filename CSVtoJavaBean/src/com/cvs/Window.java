package com.cvs;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class Window implements ActionListener {

	private JFrame frame;
	private JTextArea textArea;
	private JButton btnStart, btnZapisz, btnOtworz;
	ArrayList<Bean> list = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Konwenter");
		frame.setBounds(10, 10, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tekst do zapisania do beana:");
		lblNewLabel_1.setBounds(10, 5, 227, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textArea = new JTextArea();
		textArea.setBounds(10, 25, 1165, 650);
		frame.getContentPane().add(textArea);

		JScrollPane scorllPane = new JScrollPane(textArea);
		scorllPane.setBounds(10, 25, 1165, 650);
		frame.getContentPane().add(scorllPane);

		btnStart = new JButton("Start");
		btnStart.setBounds(10, 700, 146, 23);
		frame.getContentPane().add(btnStart);
		btnStart.addActionListener(this);

		btnOtworz = new JButton("Otworz");
		btnOtworz.setBounds(210, 700, 146, 23);
		frame.getContentPane().add(btnOtworz);
		btnOtworz.addActionListener(this);

		btnZapisz = new JButton("Zapisz");
		btnZapisz.setBounds(410, 700, 146, 23);
		frame.getContentPane().add(btnZapisz);
		btnZapisz.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		Object ktoryPrzycisk = ev.getSource();
		if (ktoryPrzycisk == btnStart) {
			List<String> lista = new ArrayList<String>();

			Scanner scanner = new Scanner(textArea.getText());
			if (scanner.hasNext()) {
				while (scanner.hasNext()) {

					String text = scanner.nextLine();
					lista.add(text);

				}
				lista.remove(0);

				for (String linia : lista) {
					// Dzielenie na poszczegolne pola (oodzielone przecinkami)
					String[] l = linia.split(",");
					// Tworzenie obiektu i wywolanie konstruktora, ktory
					// przyjmuje
					// jako argumenty dane
					Bean bean = new Bean(Integer.parseInt(l[0]), // nr
							l[1], l[2], l[3], l[4], l[5], l[6], l[7], l[8], l[9]);

					list.add(bean);

				}
				JOptionPane.showMessageDialog(null, "Utworzono " + (list.size() + " obiektów"));
			}

			else {
				JOptionPane.showMessageDialog(null, "Plik nie został wybrany ");
				scanner.close();
			}
			scanner.close();
		}

		if (ktoryPrzycisk == btnOtworz) {

			JFileChooser chooser = new JFileChooser();
			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
				;
			{
				try (BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {

					String text = null;
					while ((text = br.readLine()) != null) {
						textArea.append(text + "\r\n");
					}
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
		if (ktoryPrzycisk == btnZapisz) {

			JFileChooser chooser = new JFileChooser();
			if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
				;
			{
				File plik = chooser.getSelectedFile();

				JOptionPane.showMessageDialog(null, "Wybrany plik to " + plik);

				try {
					PrintWriter writer = new PrintWriter(plik);
					Scanner scanner = new Scanner(textArea.getText() + "\n");
					while (scanner.hasNext()) {
						writer.println(scanner.nextLine());
					}

					scanner.close();
					writer.close();

				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
			}
		}
	}
}
