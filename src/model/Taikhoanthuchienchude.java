package model;
// Generated Jul 20, 2023 7:38:23 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Taikhoanthuchienchude generated by hbm2java
 */
@Entity
@Table(name = "taikhoanthuchienchude", catalog = "toeic")
public class Taikhoanthuchienchude implements java.io.Serializable {

	private TaikhoanthuchienchudeId id;
	private Chude chude;
	private Taikhoan taikhoan;
	private Date ngayTh;

	public Taikhoanthuchienchude() {
	}

	public Taikhoanthuchienchude(TaikhoanthuchienchudeId id, Chude chude, Taikhoan taikhoan, Date ngayTh) {
		this.id = id;
		this.chude = chude;
		this.taikhoan = taikhoan;
		this.ngayTh = ngayTh;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "maTk", column = @Column(name = "MaTK", nullable = false)),
			@AttributeOverride(name = "maCd", column = @Column(name = "MaCD", nullable = false)) })
	public TaikhoanthuchienchudeId getId() {
		return this.id;
	}

	public void setId(TaikhoanthuchienchudeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaCD", nullable = false, insertable = false, updatable = false)
	public Chude getChude() {
		return this.chude;
	}

	public void setChude(Chude chude) {
		this.chude = chude;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaTK", nullable = false, insertable = false, updatable = false)
	public Taikhoan getTaikhoan() {
		return this.taikhoan;
	}

	public void setTaikhoan(Taikhoan taikhoan) {
		this.taikhoan = taikhoan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NgayTH", nullable = false, length = 10)
	public Date getNgayTh() {
		return this.ngayTh;
	}

	public void setNgayTh(Date ngayTh) {
		this.ngayTh = ngayTh;
	}

}
