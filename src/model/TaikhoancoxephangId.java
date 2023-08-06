package model;
// Generated Jul 30, 2023 7:12:18 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TaikhoancoxephangId generated by hbm2java
 */
@Embeddable
public class TaikhoancoxephangId implements java.io.Serializable {

	private int maTk;
	private int maXh;
	private int maBt;

	public TaikhoancoxephangId() {
	}

	public TaikhoancoxephangId(int maTk, int maXh, int maBt) {
		this.maTk = maTk;
		this.maXh = maXh;
		this.maBt = maBt;
	}

	@Column(name = "MaTK", nullable = false)
	public int getMaTk() {
		return this.maTk;
	}

	public void setMaTk(int maTk) {
		this.maTk = maTk;
	}

	@Column(name = "MaXH", nullable = false)
	public int getMaXh() {
		return this.maXh;
	}

	public void setMaXh(int maXh) {
		this.maXh = maXh;
	}

	@Column(name = "MaBT", nullable = false)
	public int getMaBt() {
		return this.maBt;
	}

	public void setMaBt(int maBt) {
		this.maBt = maBt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TaikhoancoxephangId))
			return false;
		TaikhoancoxephangId castOther = (TaikhoancoxephangId) other;

		return (this.getMaTk() == castOther.getMaTk()) && (this.getMaXh() == castOther.getMaXh())
				&& (this.getMaBt() == castOther.getMaBt());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getMaTk();
		result = 37 * result + this.getMaXh();
		result = 37 * result + this.getMaBt();
		return result;
	}

}
