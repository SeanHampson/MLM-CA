package MLM;

public class Query
{
	private String gender;				/* Gender of person */
	private boolean parentBusiness;		/* Parent/Guardian had own business */
	private boolean urban;				/* Lives at an urban address = True */
	private boolean businessStudent;	/* Studied Business = True */
	private boolean success;			/* Became an entrepreneur = True */
	
	public Query(String gender, boolean parentBusiness, boolean urban,
			boolean businessStudent, boolean success)
	{
		setGender(gender);
		setParentBusiness(parentBusiness);
		setUrban(urban);
		setBusinessStudent(businessStudent);
		setSuccess(success);
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
