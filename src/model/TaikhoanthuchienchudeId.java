package model;
// Generated Jul 20, 2023 7:38:23 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TaikhoanthuchienchudeId generated by hbm2java
 */
@Embeddable
public class TaikhoanthuchienchudeId implements java.io.Serializable {

	private int maTk;
	private int maCd;

	public TaikhoanthuchienchudeId() {
	}

	public TaikhoanthuchienchudeId(int maTk, int maCd) {
		this.maTk = maTk;
		this.maCd = maCd;
	}

	@Column(name = "MaTK", nullable = false)
	public int getMaTk() {
		return this.maTk;
	}

	public void setMaTk(int maTk) {
		this.maTk = maTk;
	}

	@Column(name = "MaCD", nullable = false)
	public int getMaCd() {
		return this.maCd;
	}

	public void setMaCd(int maCd) {
		this.maCd = maCd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TaikhoanthuchienchudeId))
			return false;
		TaikhoanthuchienchudeId castOther = (TaikhoanthuchienchudeId) other;

		return (this.getMaTk() == castOther.getMaTk()) && (this.getMaCd() == castOther.getMaCd());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMaTk();
		result = 37 * result + this.getMaCd();
		return result;
	}

}
