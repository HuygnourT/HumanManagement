
public class Person {
	String maNhanKhau,hoVaTen,cmnd,queQuan,noiSinh,danToc,ngheNghiep,ngaySinh,gioiTinh,sdt;
	Person(String maNhanKhau,String hoVaTen,String cmnd,String queQuan,String noiSinh,String danToc,String ngheNghiep,String ngaySinh,String gioiTinh, String sdt)
	{
		this.maNhanKhau = maNhanKhau;
		this.hoVaTen = hoVaTen;
		this.cmnd = cmnd;
		this.queQuan = queQuan;
		this.noiSinh = noiSinh;
		this.danToc = danToc;
		this.ngheNghiep = ngheNghiep;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
	}
	Person()
	{
		this.maNhanKhau = "";
		this.hoVaTen = "";
		this.cmnd = "";
		this.queQuan = "";
		this.noiSinh = "";
		this.danToc = "";
		this.ngheNghiep = "";
		this.ngaySinh = "";
		this.gioiTinh = "";
		this.sdt = "";
	}
	public void setMaNhanKhau(String maNhanKhau)
	{
		this.maNhanKhau = maNhanKhau;
	}
	public String getMaNhanKhau()
	{
		return maNhanKhau;
	}
	public void setHoVaTen(String hoVaTen)
	{
		this.hoVaTen = hoVaTen;
	}
	public String getHoVaTen()
	{
		return hoVaTen;
	}
	public void setCmnd(String cmnd)
	{
		this.cmnd = cmnd;
	}
	public String getCmnd()
	{
		return cmnd;
	}
	public void setQueQuan(String queQuan)
	{
		this.queQuan = queQuan;
	}
	public String getQueQuan()
	{
		return queQuan;
	}
	public void setNoiSinh(String noiSinh)
	{
		this.noiSinh = noiSinh;
	}
	public String getNoiSinh()
	{
		return noiSinh;
	}
	public void setDanToc(String danToc)
	{
		this.danToc = danToc;
	}
	public String getDanToc()
	{
		return danToc;
	}
	public void setNgheNghiep(String ngheNghiep)
	{
		this.ngheNghiep = ngheNghiep;
	}
	public String getNgheNghiep()
	{
		return ngheNghiep;
	}
	public void setNgaySinh(String ngaySinh)
	{
		this.ngaySinh = ngaySinh;
	}
	public String getNgaySinh()
	{
		return ngaySinh;
	}
	public void setGioiTinh(String gioiTinh)
	{
		this.gioiTinh = gioiTinh;
	}
	public String getGioiTinh()
	{
		return gioiTinh;
	}
	public void setSdt(String sdt)
	{
		this.sdt = sdt;
	}
	public String getSdt()
	{
		return sdt;
	}
}
