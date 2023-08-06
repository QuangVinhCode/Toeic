package model;
// Generated Jul 30, 2023 7:12:18 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Taikhoancoxephang generated by hbm2java
 */
@Entity
@Table(name = "taikhoancoxephang", catalog = "toeic")
public class Taikhoancoxephang implements java.io.Serializable {

	private TaikhoancoxephangId id;
	private Taikhoanthuchienbaitap taikhoanthuchienbaitap;
	private Xephang xephang;
	private int thuHang;

	public Taikhoancoxephang() {
	}

	public Taikhoancoxephang(TaikhoancoxephangId id, Taikhoanthuchienbaitap taikhoanthuchienbaitap, Xephang xephang,
			int thuHang) {
		this.id = id;
		this.taikhoanthuchienbaitap = taikhoanthuchienbaitap;
		this.xephang = xephang;
		this.thuHang = thuHang;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "maTk", column = @Column(name = "MaTK", nullable = false)),
			@AttributeOverride(name = "maXh", column = @Column(name = "MaXH", nullable = false)),
			@AttributeOverride(name = "maBt", column = @Column(name = "MaBT", nullable = false)) })
	public TaikhoancoxephangId getId() {
		return this.id;
	}

	public void setId(TaikhoancoxephangId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "MaBT", referencedColumnName = "MaTK", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "MaTK", referencedColumnName = "MaBT", nullable = false, insertable = false, updatable = false) })
	public Taikhoanthuchienbaitap getTaikhoanthuchienbaitap() {
		return this.taikhoanthuchienbaitap;
	}

	public void setTaikhoanthuchienbaitap(Taikhoanthuchienbaitap taikhoanthuchienbaitap) {
		this.taikhoanthuchienbaitap = taikhoanthuchienbaitap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MaXH", nullable = false, insertable = false, updatable = false)
	public Xephang getXephang() {
		return this.xephang;
	}

	public void setXephang(Xephang xephang) {
		this.xephang = xephang;
	}

	@Column(name = "ThuHang", nullable = false)
	public int getThuHang() {
		return this.thuHang;
	}

	public void setThuHang(int thuHang) {
		this.thuHang = thuHang;
	}

}
