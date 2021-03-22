package MLM;

public class Query
{
	private String gender;				/* Gender of person = Male or Female*/
	private boolean parentBusiness;		/* Parent/Guardian had own business = True*/
	private boolean ptJob;				/* Has a part time job = True*/
	private boolean urban;				/* Lives at an urban address = True */
	private boolean businessStudent;	/* Studied Business = True */
	private boolean success;			/* Became an entrepreneur = True */
	
	public Query(String gender, boolean parentBusiness, boolean ptJob, 
			boolean urban, boolean businessStudent, boolean success)
	{
		setGender(gender);
		setParentBusiness(parentBusiness);
		setPtJob(ptJob);
		setUrban(urban);
		setBusinessStudent(businessStudent);
		setSuccess(success);
	}
	
	public String toString()
	{
		String summary = getGender() + '\n' + isParentBusiness() + '\n' + isPtJob() + '\n' +
				isUrban() + '\n' + isBusinessStudent() + '\n' + isSuccess() + '\n';
		
		return summary;
		
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
