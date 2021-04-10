package MLM;

public class Query
{
	// Gender of person = Male or Female
	private String gender;
	// Parent/Guardian had own business = True
	private boolean parentBusiness;
	// Has a part time job = True
	private boolean ptJob;
	// Lives at an urban address = True
	private boolean urban;
	// Studied Business = True
	private boolean businessStudent;
	
	public Query(String gender, boolean parentBusiness, boolean ptJob, 
			boolean urban, boolean businessStudent)
	{
		setGender(gender.toLowerCase());
		setParentBusiness(parentBusiness);
		setPtJob(ptJob);
		setUrban(urban);
		setBusinessStudent(businessStudent);
	}
	
	public String toString()
	{
		String summary = getGender() + ',' + isParentBusiness() + ',' 
		+ isPtJob() + ',' + isUrban() + ',' + isBusinessStudent() +  '\n';
		
		return summary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if(gender.equals("male") || gender.equals("female")) {
			this.gender = gender;
		}
	}

	public boolean isParentBusiness() {
		return parentBusiness;
	}

	public void setParentBusiness(boolean parentBusiness) {
		this.parentBusiness = parentBusiness;
	}

	public boolean isPtJob() {
		return ptJob;
	}

	public void setPtJob(boolean ptJob) {
		this.ptJob = ptJob;
	}

	public boolean isUrban() {
		return urban;
	}

	public void setUrban(boolean urban) {
		this.urban = urban;
	}

	public boolean isBusinessStudent() {
		return businessStudent;
	}

	public void setBusinessStudent(boolean businessStudent) {
		this.businessStudent = businessStudent;
	}
}