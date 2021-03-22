package MLM;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

/* UI for a Query */
@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
	private ButtonGroup gender, business, job, address, student, successful;
	private JRadioButton male, female, 
					ownedBusiness, noBusiness,
					ptJob, noJob,
					urban, rural, 
					businessStudent, notBusinessStudent, 
					entrepreneur, notEntrepreneur;
	private JButton submit;
	private JPanel studentGender, parentGuardian, partTime, urbanOrRural,
			studiesBusiness, becameEntrepreneur;
	private JLabel probability;

	public GUI(String title)
	{
		super(title);
		setResizable(false);
		setLayout(new GridLayout(8, 1));
		setSize(300, 400);
		
		/* ========== Student gender ========== */
		
		// Panel
		studentGender = new JPanel();
		studentGender.setBorder(BorderFactory.createTitledBorder("Student Gender"));
		studentGender.setLayout(new BoxLayout(studentGender, BoxLayout.X_AXIS));
		
		// Radio Buttons
		male   = new JRadioButton("Male", true);
		male.setActionCommand( male.getText() );
		
		female = new JRadioButton("Female", false);
		female.setActionCommand( female.getText() );
		
		// Button Group
		gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		
		// Add to panel
		studentGender.add(male);
		studentGender.add(female);
		
		// Add to frame
		add(studentGender);
		
		/* ========== Parent/Guardian had own business ========== */
		
		// Panel
		parentGuardian = new JPanel();
		parentGuardian.setBorder(BorderFactory.createTitledBorder("Parent/Guardian had own Business"));
		parentGuardian.setLayout(new BoxLayout(parentGuardian, BoxLayout.X_AXIS));
		
		// Radio Buttons
		ownedBusiness = new JRadioButton("Yes", true);
		ownedBusiness.setActionCommand( ownedBusiness.getText() );
		
		noBusiness = new JRadioButton("No", false);
		noBusiness.setActionCommand( noBusiness.getText() );
		
		// Button Group
		business = new ButtonGroup();
		business.add(ownedBusiness);
		business.add(noBusiness);
		
		// Add to panel
		parentGuardian.add(ownedBusiness);
		parentGuardian.add(noBusiness);
		
		// Add to frame
		add(parentGuardian);
		
		/* ========== Has a part time job ========== */
		
		// Panel
		partTime = new JPanel();
		partTime.setBorder(BorderFactory.createTitledBorder("Has a Part Time Job"));
		partTime.setLayout(new BoxLayout(partTime, BoxLayout.X_AXIS));
		
		// Radio Buttons
		ptJob = new JRadioButton("Yes", true);
		ptJob.setActionCommand( ptJob.getText() );
		
		noJob = new JRadioButton("No", false);
		noJob.setActionCommand( noJob.getText() );
		
		// Button Group
		job = new ButtonGroup();
		job.add(ptJob);
		job.add(noJob);

		// Add to panel
		partTime.add(ptJob);
		partTime.add(noJob);
		
		// Add to frame
		add(partTime);
		
		/* ========== Urban or rural address ========== */
		
		// Panel
		urbanOrRural = new JPanel();
		urbanOrRural.setBorder(BorderFactory.createTitledBorder("Urban or Rural Address"));
		urbanOrRural.setLayout(new BoxLayout(urbanOrRural, BoxLayout.X_AXIS));
		
		// Radio Buttons
		urban = new JRadioButton("Urban", true);
		urban.setActionCommand( urban.getText() );
		
		rural = new JRadioButton("Rural", false);
		rural.setActionCommand( rural.getText() );
		
		// Button Group
		address = new ButtonGroup();
		address.add(urban);
		address.add(rural);
		
		// Add to panel
		urbanOrRural.add(urban);
		urbanOrRural.add(rural);
		
		// Add to frame
		add(urbanOrRural);
		
		/* ========== Studies business subjects ========== */
		
		// Panel
		studiesBusiness = new JPanel();
		studiesBusiness.setBorder(BorderFactory.createTitledBorder("Studies Business Subjects"));
		studiesBusiness.setLayout(new BoxLayout(studiesBusiness, BoxLayout.X_AXIS));
		
		// Radio Buttons
		businessStudent = new JRadioButton("Yes", true);
		businessStudent.setActionCommand( businessStudent.getText() );
		
		notBusinessStudent = new JRadioButton("No", false);
		notBusinessStudent.setActionCommand( notBusinessStudent.getText() );
		
		// Button Group
		student = new ButtonGroup();
		student.add(businessStudent);
		student.add(notBusinessStudent);
		
		// Add to panel
		studiesBusiness.add(businessStudent);
		studiesBusiness.add(notBusinessStudent);
		
		// Add to frame
		add(studiesBusiness);
	
		/* ========== Become an Entrepreneur ========== */
		
		// Panel
		becameEntrepreneur = new JPanel();
		becameEntrepreneur.setBorder(BorderFactory.createTitledBorder("Became an Entrepreneur"));
		becameEntrepreneur.setLayout(new BoxLayout(becameEntrepreneur, BoxLayout.X_AXIS));
		
		// Radio Buttons
		entrepreneur = new JRadioButton("Yes", true);
		entrepreneur.setActionCommand( entrepreneur.getText() );
		
		notEntrepreneur = new JRadioButton("No", false);
		notEntrepreneur.setActionCommand( notEntrepreneur.getText() );
		
		// Button Group
		successful = new ButtonGroup();
		successful.add(entrepreneur);
		successful.add(notEntrepreneur);
		
		// Add to panel
		becameEntrepreneur.add(entrepreneur);
		becameEntrepreneur.add(notEntrepreneur);
		
		// Add to frame
		add(becameEntrepreneur);
		
		/* ========== Submit button ========== */
		
		// Button
		submit = new JButton("Submit");
		submit.addActionListener(this);
		
		// Add to frame
		add(submit);
		
		/* ========== Probability Label ========== */
		
		// Label
		probability = new JLabel("Probability: 0%", SwingConstants.CENTER);
		probability.setFont(new Font("Calibri", Font.BOLD, 20));
		
		// Add to frame
		add(probability);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		/* Grab text value from radio buttons */
		String genderText = gender.getSelection().getActionCommand();
		String businessText = business.getSelection().getActionCommand();
		String jobText = job.getSelection().getActionCommand();
		String addressText = address.getSelection().getActionCommand();
		String studentText = student.getSelection().getActionCommand();
		String successfulText = successful.getSelection().getActionCommand();
		
		/* Boolean parameters initialize */
		boolean bBool = false,jBool = false, aBool = false, stBool = false, suBool = false;
		
		/* Boolean parameters set to true depending on value*/
		if(businessText == "Yes") bBool = true;
		if(jobText == "Yes") jBool = true;
		if(addressText == "Urban") aBool = true;
		if(studentText == "Yes") stBool = true;
		if(successfulText == "Yes") suBool = true;
		
		Query q1 = new Query(genderText, bBool, jBool, aBool, stBool, suBool);
		System.out.println(q1);
	}
}
