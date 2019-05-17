package console;

public class PersonTamVang extends Person{
	protected String maTamVang,liDo;
	protected Address noiDen;
	protected Date ngayDi,ngayVe;
	public PersonTamVang()
	{
		super();
		maTamVang = "";
		liDo = "";
		noiDen = new Address();
		ngayDi = new Date();
		ngayVe = new Date();
	}
	public void setMaTamVang(String maTamVang)
	{
		this.maTamVang = maTamVang;
	}
	public String getMaTamVang()
	{
		return this.maTamVang;
	}
	public void setLiDo(String liDo)
	{
		this.liDo = liDo;
	}
	public String getLiDo()
	{
		return this.liDo;
	}
	public void setNoiDen(String noiDen)
	{
		this.noiDen.setAddress(noiDen);
	}
	public void setNgayDi(int d,int m,int y)
	{
		ngayDi = new Date(d,m,y);
	}
	public String getNgayDi()
	{
		return ngayDi.toString();
	}
	public void setNgayVe(int d,int m,int y)
	{
		ngayVe = new Date(d,m,y);
	}
	public String getNgayVe()
	{
		return ngayVe.toString();
	}
}
