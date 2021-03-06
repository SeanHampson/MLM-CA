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
import javax.swing.border.TitledBorder;

/* UI for a Query */
@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{
	private ButtonGroup gender, business, job, address, student;
	private JRadioButton male, female, 
					ownedBusiness, noBusiness,
					ptJob, noJob,
					urban, rural, 
					businessStudent, notBusinessStudent; 
	private JButton submit;
	private JPanel studentGender, parentGuardian, partTime, urbanOrRural,
			studiesBusiness;
	private JLabel futureEntrepreneurLabel, resultLabel;

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
		((TitledBorder) studentGender.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 14));
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
		
		/* ========== Parent/Guardian had own business ========== */
		
		// Panel
		parentGuardian = new JPanel();
		parentGuardian.setBorder(BorderFactory.createTitledBorder("Parent/Guardian had own Business"));
		((TitledBorder) parentGuardian.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 14));
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
		
		/* ========== Has a part time job ========== */
		
		// Panel
		partTime = new JPanel();
		partTime.setBorder(BorderFactory.createTitledBorder("Has a Part Time Job"));
		((TitledBorder) partTime.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 14));
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
		
		/* ========== Urban or rural address ========== */
		
		// Panel
		urbanOrRural = new JPanel();
		urbanOrRural.setBorder(BorderFactory.createTitledBorder("Urban or Rural Address"));
		((TitledBorder) urbanOrRural.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 14));
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
		
		/* ========== Studies business subjects ========== */
		
		// Panel
		studiesBusiness = new JPanel();
		studiesBusiness.setBorder(BorderFactory.createTitledBorder("Studies Business Subjects"));
		((TitledBorder) studiesBusiness.getBorder()).setTitleFont(new Font("Arial", Font.BOLD, 14));
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
		
		/* ========== Submit button ========== */
		
		// Button
		submit = new JButton("Submit");
		submit.setFont(new Font("Arial", Font.BOLD, 24));
		submit.addActionListener(this);
		
		/* ========== Future Entrepreneur Label ========== */
		
		// Label
		futureEntrepreneurLabel = new JLabel("Future Entrepreneur:", SwingConstants.CENTER);
		futureEntrepreneurLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		
		/* ========== Future Entrepreneur Label ========== */
		
		// Label
		resultLabel = new JLabel("", SwingConstants.CENTER);
		resultLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		
		// Add to frame
		add(studentGender);
		add(parentGuardian);
		add(partTime);
		add(urbanOrRural);
		add(studiesBusiness);
		add(submit);
		add(futureEntrepreneurLabel);
		add(resultLabel);
		
		setVisible(true);
	}
	
	public String toString()
	{
		String summary = "Naive Bayes by Sean Hampson C19301641";
		
		return summary;
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
		
		/* Boolean parameters initialize */
		boolean businessBool = false, jobBool = false, addressBool = false, studentBool = false;
		
		/* Boolean parameters set to true depending on value*/
		if(businessText == "Yes") businessBool = true;
		if(jobText == "Yes") jobBool = true;
		if(addressText == "Urban") addressBool = true;
		if(studentText == "Yes") studentBool = true;
		
		Query q1 = new Query(genderText, businessBool, jobBool, addressBool, studentBool);
		
		ProcessQuery p1 = new ProcessQuery(q1);
		
		String result = p1.getProb();
		if(result.equals("yes"))
		{
			resultLabel.setText("YES");
		}
		else
		{
			resultLabel.setText("NO");
		}
	}
}