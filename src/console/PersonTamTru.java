package console;

public class PersonTamTru extends Person{
	protected String maThuongTru,soHoKhau,quanHeChuHo;
	protected Address noiOTruoc = new Address();
	protected Date ngayChuyenDen = new Date();
	public PersonTamTru()
	{
		super();
		maThuongTru = "";
		soHoKhau = "";
		quanHeChuHo = "";
		
	}
	public void setMaThuongTru(String maThuongTru)
	{
		this.maThuongTru = maThuongTru;
	}
	public String getMaThuongTru()
	{
		return this.maThuongTru;
	}
	public void setSoHoKhau(String soHoKhau)
	{
		this.soHoKhau = soHoKhau;
	}
	public String getSoHoKhau()
	{
		return this.soHoKhau;
	}
	public void setQuanHeChuHo(String quanHeChuHo)
	{
		this.quanHeChuHo = quanHeChuHo;
	}
	public String getQuanHeChuHo()
	{
		return this.quanHeChuHo;
	}
	public void setNoiOTruoc(String noiOTruoc)
	{
		this.noiOTruoc.setAddress(noiOTruoc);
	}
	public String getNoiOTruoc()
	{
		return this.noiOTruoc.toString();
	}
	public void setNgayChuyenDen(int d,int m,int y)
	{
		ngayChuyenDen = new Date(d,m,y);
	}
	public String getNgayChuyenDen()
	{
		return ngayChuyenDen.toString();
	}
}
