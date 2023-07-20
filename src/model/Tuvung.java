package model;
// Generated Jul 20, 2023 7:38:23 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Tuvung generated by hbm2java
 */
@Entity
@Table(name = "tuvung", catalog = "toeic")
public class Tuvung implements java.io.Serializable {

	private Integer maTv;
	private Chude chude;
	private String tenTuVung;
	private String dichTv;
	private String hinhAnhTv;

	public Tuvung() {
	}

	public Tuvung(Chude chude, String tenTuVung, String dichTv, String hinhAnhTv) {
		this.chude = chude;
		this.tenTuVung = tenTuVung;
		this.dichTv = dichTv;
		this.hinhAnhTv = hinhAnhTv;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "MaTV", unique = true, nullable = false)
	public Integer getMaTv() {
		return this.maTv;
	}

	public void setMaTv(Integer maTv) {
		this.maTv = maTv;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaCD", nullable = false)
	public Chude getChude() {
		return this.chude;
	}

	public void setChude(Chude chude) {
		this.chude = chude;
	}

	@Column(name = "TenTuVung", nullable = false, length = 50)
	public String getTenTuVung() {
		return this.tenTuVung;
	}

	public void setTenTuVung(String tenTuVung) {
		this.tenTuVung = tenTuVung;
	}

	@Column(name = "DichTV", nullable = false, length = 50)
	public String getDichTv() {
		return this.dichTv;
	}

	public void setDichTv(String dichTv) {
		this.dichTv = dichTv;
	}

	@Column(name = "HinhAnhTV", nullable = false, length = 30)
	public String getHinhAnhTv() {
		return this.hinhAnhTv;
	}

	public void setHinhAnhTv(String hinhAnhTv) {
		this.hinhAnhTv = hinhAnhTv;
	}

}
