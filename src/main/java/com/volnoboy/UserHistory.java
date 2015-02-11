package com.volnoboy;

import java.util.Date;

/**
 * @author Volodymyr Volnoboy (vvolnoboy@luxoft.com)
 * @since 2/11/15 12:09 PM
 */
public class UserHistory {
	public UserHistory() {

	}
	public UserHistory(Date entryTime, String entry) {
		this.entryTime = entryTime;
		this.entry = entry;
	}

	private Date entryTime;
	private String entry;

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserHistory that = (UserHistory) o;

		if (entry != null ? !entry.equals(that.entry) : that.entry != null) return false;
		if (entryTime != null ? !entryTime.equals(that.entryTime) : that.entryTime != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = entryTime != null ? entryTime.hashCode() : 0;
		result = 31 * result + (entry != null ? entry.hashCode() : 0);
		return result;
	}
}
