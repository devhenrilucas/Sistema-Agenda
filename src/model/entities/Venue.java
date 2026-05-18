package model.entities;

import java.util.Objects;

public class Venue {
	private String venueName;
	private Integer maxCapacity;
	private Integer Id;
	public Venue(Integer id, String venueName, Integer maxCapacity) {
		super();
		this.venueName = venueName;
		this.maxCapacity = maxCapacity;
		Id = id;
	}
	
	public Venue () { super(); };

	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public Integer getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "Venue [venueName=" + venueName + ", maxCapacity=" + maxCapacity + ", Id=" + Id + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		  if (this == obj)
		   return true;
		  if (obj == null)
		   return false;
		  if (getClass() != obj.getClass())
		   return false;
		  Venue other = (Venue) obj;
		  return Objects.equals(Id, other.Id);
		}

}
