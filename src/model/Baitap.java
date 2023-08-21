package model;
// Generated Aug 21, 2023 3:25:15 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Baitap generated by hbm2java
 */
@Entity
@Table(name = "baitap", catalog = "toeic")
public class Baitap implements java.io.Serializable {

	private String maBt;
	private Chude chude;
	private String cauHoi;
	private String goiY;
	private String dapAn;
	private int diemSo;

	public Baitap() {
	}

	public Baitap(String maBt, Chude chude, String cauHoi, String goiY, String dapAn, int diemSo) {
		this.maBt = maBt;
		this.chude = chude;
		this.cauHoi = cauHoi;
		this.goiY = goiY;
		this.dapAn = dapAn;
		this.diemSo = diemSo;
	}

	@Id

	@Column(name = "MaBT", unique = true, nullable = false, length = 10)
	public String getMaBt() {
		return this.maBt;
	}

	public void setMaBt(String maBt) {
		this.maBt = maBt;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaCD", nullable = false)
	public Chude getChude() {
		return this.chude;
	}

	public void setChude(Chude chude) {
		this.chude = chude;
	}

	@Column(name = "CauHoi", nullable = false, length = 150)
	public String getCauHoi() {
		return this.cauHoi;
	}

	public void setCauHoi(String cauHoi) {
		this.cauHoi = cauHoi;
	}

	@Column(name = "GoiY", nullable = false, length = 50)
	public String getGoiY() {
		return this.goiY;
	}

	public void setGoiY(String goiY) {
		this.goiY = goiY;
	}

	@Column(name = "DapAn", nullable = false, length = 50)
	public String getDapAn() {
		return this.dapAn;
	}

	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
	}

	@Column(name = "DiemSo", nullable = false)
	public int getDiemSo() {
		return this.diemSo;
	}

	public void setDiemSo(int diemSo) {
		this.diemSo = diemSo;
	}

}
