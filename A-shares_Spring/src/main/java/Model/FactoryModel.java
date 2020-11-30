package Model;

public class FactoryModel {
	private Member		M;
	private Share		S;
	private Share_Order S_O;
	public Member getM() {
		return M;
	}
	public void setM(Member m) {
		this.M = m;
	}
	public Share getS() {
		return S;
	}
	public void setS(Share s) {
		this.S = s;
	}
	public Share_Order getS_O() {
		return S_O;
	}
	public void setS_O(Share_Order s_O) {
		this.S_O = s_O;
	}
	
	
}
