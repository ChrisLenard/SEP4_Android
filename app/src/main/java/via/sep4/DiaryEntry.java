package via.sep4;

import java.util.Date;

public class DiaryEntry
{
	private int id;
	private String entry;
	private Date dateAdded;

public DiaryEntry(int id, String entry, Date dateAdded)
{
	this.id = id;
	this.entry = entry;
	this.dateAdded = dateAdded;
}

public int getId()
{
	return id;
}

public void setId(int id)
{
	this.id = id;
}

public String getEntry()
{
	return entry;
}

public void setEntry(String entry)
{
	this.entry = entry;
}

public Date getDateAdded()
{
	return dateAdded;
}

public void setDateAdded(Date dateAdded)
{
	this.dateAdded = dateAdded;
}
}
