package library;

import java.util.ArrayList;

import library.enumerations.ReportType;
import library.enumerations.UserType;

public class ReportUI 
{
	private UserType user;
	private ReportType type;
	private ArrayList<Gain> listGain;

	public UserType getUser() {
		return user;
	}

	public void setUser(UserType user) {
		this.user = user;
	}
	
	public boolean isBranch()
	{
		if(user == UserType.BranchManager_Type)
		{
			return true;
		}
		return false;
	}
	
	public boolean isManager()
	{
		if(user == UserType.GeneralManager_Type)
		{
			return true;
		}
		return false;
	}

	public ReportType getType() {
		return type;
	}

	public void setType(ReportType type) {
		this.type = type;
	}

	public ArrayList<Gain> getListGain() {
		return listGain;
	}

	public void setListGain(ArrayList<Gain> listGain) {
		this.listGain = listGain;
	}

}
