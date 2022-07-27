package com.ssafy.live4.collection.set;

// TODO: SmartPhone이 다른 SmartPhone과 번호를 기준으로 비교가능하게 처리하시오.
 public class SmartPhone implements Comparable<SmartPhone>{
    // END:

    String number;

    public SmartPhone(String number) {
        this.number = number;
    }

    public String toString() {
        return "전화 번호: " + number;
    }

    // TODO: 동일한 번호의 SmartPhone이면 하나만 추가될 수 있도록 처리하시오.
    @Override
    public boolean equals(Object obj) {
    	boolean result = false;
    	if(obj != null && obj instanceof SmartPhone) {
    		SmartPhone param = (SmartPhone) obj;
    		result = (this.number.equals(param.number));
    	}
    	return result;
    }
    // END:

	@Override
	public int compareTo(SmartPhone o) {
		return this.number.compareTo(o.number);
	}

	public int hashCode() {
		return number.hashCode();
	}
	
}
