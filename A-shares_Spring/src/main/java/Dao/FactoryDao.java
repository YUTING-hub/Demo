package Dao;

public class FactoryDao {
	private MemberDao 		 MD;
	private ShareDao 		 SD;
	private Share_OrderDao S_OD;
	public MemberDao getMD() {
		return MD;
	}
	public void setMD(MemberDao mD) {
		MD = mD;
	}
	public ShareDao getSD() {
		return SD;
	}
	public void setSD(ShareDao sD) {
		SD = sD;
	}
	public Share_OrderDao getS_OD() {
		return S_OD;
	}
	public void setS_OD(Share_OrderDao s_OD) {
		S_OD = s_OD;
	}
}
