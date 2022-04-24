package shoplap.dto;

public class ChangePassword {
	private String oldpass;
	private String newpass;
	private String reNewpass;

	public String getOldpass() {
		return oldpass;
	}

	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public String getReNewpass() {
		return reNewpass;
	}

	public void setReNewpass(String reNewpass) {
		this.reNewpass = reNewpass;
	}

}
