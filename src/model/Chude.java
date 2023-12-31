package model;
// Generated Aug 21, 2023 3:25:15 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Chude generated by hbm2java
 */
@Entity
@Table(name = "chude", catalog = "toeic")
public class Chude implements java.io.Serializable {

	private String maCd;
	private String tenCd;
	private String hinhAnhCd;
	private Set<Baitap> baitaps = new HashSet<Baitap>(0);
	private Set<Tuvung> tuvungs = new HashSet<Tuvung>(0);
	private Set<Taikhoanthuchienchude> taikhoanthuchienchudes = new HashSet<Taikhoanthuchienchude>(0);

	public Chude() {
	}

	public Chude(String maCd, String tenCd, String hinhAnhCd) {
		this.maCd = maCd;
		this.tenCd = tenCd;
		this.hinhAnhCd = hinhAnhCd;
	}

	public Chude(String maCd, String tenCd, String hinhAnhCd, Set<Baitap> baitaps, Set<Tuvung> tuvungs,
			Set<Taikhoanthuchienchude> taikhoanthuchienchudes) {
		this.maCd = maCd;
		this.tenCd = tenCd;
		this.hinhAnhCd = hinhAnhCd;
		this.baitaps = baitaps;
		this.tuvungs = tuvungs;
		this.taikhoanthuchienchudes = taikhoanthuchienchudes;
	}

	@Id

	@Column(name = "MaCD", unique = true, nullable = false, length = 10)
	public String getMaCd() {
		return this.maCd;
	}

	public void setMaCd(String maCd) {
		this.maCd = maCd;
	}

	@Column(name = "TenCD", nullable = false, length = 30)
	public String getTenCd() {
		return this.tenCd;
	}

	public void setTenCd(String tenCd) {
		this.tenCd = tenCd;
	}

	@Column(name = "HinhAnhCD", nullable = false, length = 30)
	public String getHinhAnhCd() {
		return this.hinhAnhCd;
	}

	public void setHinhAnhCd(String hinhAnhCd) {
		this.hinhAnhCd = hinhAnhCd;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chude")
	public Set<Baitap> getBaitaps() {
		return this.baitaps;
	}

	public void setBaitaps(Set<Baitap> baitaps) {
		this.baitaps = baitaps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chude")
	public Set<Tuvung> getTuvungs() {
		return this.tuvungs;
	}

	public void setTuvungs(Set<Tuvung> tuvungs) {
		this.tuvungs = tuvungs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chude")
	public Set<Taikhoanthuchienchude> getTaikhoanthuchienchudes() {
		return this.taikhoanthuchienchudes;
	}

	public void setTaikhoanthuchienchudes(Set<Taikhoanthuchienchude> taikhoanthuchienchudes) {
		this.taikhoanthuchienchudes = taikhoanthuchienchudes;
	}

}
