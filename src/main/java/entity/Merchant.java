package entity;

public class Merchant {
	private int merchantId;
	private String merchantName;
	private AddressPoint merchantAddressPoint;
	
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public AddressPoint getMerchantAddressPoint() {
		return merchantAddressPoint;
	}
	public void setMerchantAddressPoint(AddressPoint merchantAddressPoint) {
		this.merchantAddressPoint = merchantAddressPoint;
	}
	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", merchantName=" + merchantName + ", merchantAddressPoint="
				+ merchantAddressPoint + "]";
	}
	
}
